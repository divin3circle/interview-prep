package main

import "fmt"

// DoublyNode definition
type DoublyNode struct {
	Val  int
	Prev *DoublyNode
	Next *DoublyNode
}

// DoublyLinkedList with Head and Tail pointers
type DoublyLinkedList struct {
	Head *DoublyNode
	Tail *DoublyNode
	Size int
}

func NewDoublyLinkedList() *DoublyLinkedList {
	return &DoublyLinkedList{}
}

// AddFirst adds to beginning - O(1)
func (dll *DoublyLinkedList) AddFirst(val int) {
	newNode := &DoublyNode{Val: val}
	if dll.Head == nil {
		dll.Head = newNode
		dll.Tail = newNode
	} else {
		newNode.Next = dll.Head
		dll.Head.Prev = newNode
		dll.Head = newNode
	}
	dll.Size++
}

// AddLast adds to end - O(1)
func (dll *DoublyLinkedList) AddLast(val int) {
	newNode := &DoublyNode{Val: val}
	if dll.Tail == nil {
		dll.Head = newNode
		dll.Tail = newNode
	} else {
		dll.Tail.Next = newNode
		newNode.Prev = dll.Tail
		dll.Tail = newNode
	}
	dll.Size++
}

// Delete removes first occurrence - O(n)
func (dll *DoublyLinkedList) Delete(val int) bool {
	curr := dll.Head
	for curr != nil {
		if curr.Val == val {
			dll.removeNode(curr)
			return true
		}
		curr = curr.Next
	}
	return false
}

// removeNode helper - O(1)
func (dll *DoublyLinkedList) removeNode(node *DoublyNode) {
	if node == dll.Head {
		dll.Head = node.Next
		if dll.Head != nil {
			dll.Head.Prev = nil
		} else {
			dll.Tail = nil
		}
	} else if node == dll.Tail {
		dll.Tail = node.Prev
		if dll.Tail != nil {
			dll.Tail.Next = nil
		} else {
			dll.Head = nil
		}
	} else {
		node.Prev.Next = node.Next
		node.Next.Prev = node.Prev
	}
	dll.Size--
}

func (dll *DoublyLinkedList) PrintForward() {
	curr := dll.Head
	fmt.Print("Fwd: ")
	for curr != nil {
		fmt.Printf("%d <-> ", curr.Val)
		curr = curr.Next
	}
	fmt.Println("nil")
}

func (dll *DoublyLinkedList) PrintBackward() {
	curr := dll.Tail
	fmt.Print("Bwd: ")
	for curr != nil {
		fmt.Printf("%d <-> ", curr.Val)
		curr = curr.Prev
	}
	fmt.Println("nil")
}

func main() {
	dll := NewDoublyLinkedList()
	dll.AddLast(1)
	dll.AddLast(2)
	dll.AddLast(3)
	
	dll.PrintForward()  // 1 <-> 2 <-> 3 <-> nil
	dll.PrintBackward() // 3 <-> 2 <-> 1 <-> nil
	
	dll.Delete(2)
	dll.PrintForward()  // 1 <-> 3 <-> nil
}
