package main

import "fmt"

// ListNode definition
type ListNode struct {
	Val  int
	Next *ListNode
}

// SinglyLinkedList definition
type SinglyLinkedList struct {
	Head *ListNode
	Size int
}

// NewSinglyLinkedList creates a new empty list
func NewSinglyLinkedList() *SinglyLinkedList {
	return &SinglyLinkedList{}
}

// AddFirst adds a node to the beginning - O(1)
func (ll *SinglyLinkedList) AddFirst(val int) {
	newNode := &ListNode{Val: val}
	newNode.Next = ll.Head
	ll.Head = newNode
	ll.Size++
}

// AddLast adds a node to the end - O(n)
func (ll *SinglyLinkedList) AddLast(val int) {
	newNode := &ListNode{Val: val}
	if ll.Head == nil {
		ll.Head = newNode
		ll.Size++
		return
	}

	curr := ll.Head
	for curr.Next != nil {
		curr = curr.Next
	}
	curr.Next = newNode
	ll.Size++
}

// Delete removes the first occurrence of val - O(n)
func (ll *SinglyLinkedList) Delete(val int) bool {
	if ll.Head == nil {
		return false
	}

	if ll.Head.Val == val {
		ll.Head = ll.Head.Next
		ll.Size--
		return true
	}

	curr := ll.Head
	for curr.Next != nil {
		if curr.Next.Val == val {
			curr.Next = curr.Next.Next
			ll.Size--
			return true
		}
		curr = curr.Next
	}
	return false
}

// Reverse reverses the list in-place - O(n)
func (ll *SinglyLinkedList) Reverse() {
	var prev *ListNode
	curr := ll.Head
	for curr != nil {
		nextTemp := curr.Next
		curr.Next = prev
		prev = curr
		curr = nextTemp
	}
	ll.Head = prev
}

// Print displays list contents
func (ll *SinglyLinkedList) Print() {
	curr := ll.Head
	fmt.Print("Singly List: ")
	for curr != nil {
		fmt.Printf("%d -> ", curr.Val)
		curr = curr.Next
	}
	fmt.Println("nil")
}

func main() {
	ll := NewSinglyLinkedList()
	ll.AddFirst(10)
	ll.AddLast(20)
	ll.AddLast(30)
	ll.Print() // 10 -> 20 -> 30 -> nil

	ll.Delete(20)
	ll.Print() // 10 -> 30 -> nil

	ll.Reverse()
	ll.Print() // 30 -> 10 -> nil
}
