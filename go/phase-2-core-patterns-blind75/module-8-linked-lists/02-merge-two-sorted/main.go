package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

// mergeTwoLists merges two sorted linked lists.
// Time: O(N + M)
// Space: O(1)
func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
	dummy := &ListNode{}
	curr := dummy
	
	for list1 != nil && list2 != nil {
		if list1.Val <= list2.Val {
			curr.Next = list1
			list1 = list1.Next
		} else {
			curr.Next = list2
			list2 = list2.Next
		}
		curr = curr.Next
	}
	
	// Attach remaining nodes
	if list1 != nil {
		curr.Next = list1
	} else {
		curr.Next = list2
	}
	
	return dummy.Next
}

func createList(vals []int) *ListNode {
	if len(vals) == 0 {
		return nil
	}
	head := &ListNode{Val: vals[0]}
	curr := head
	for i := 1; i < len(vals); i++ {
		curr.Next = &ListNode{Val: vals[i]}
		curr = curr.Next
	}
	return head
}

func printList(head *ListNode) {
	vals := []int{}
	for head != nil {
		vals = append(vals, head.Val)
		head = head.Next
	}
	fmt.Println(vals)
}

func main() {
	list1 := createList([]int{1, 2, 4})
	list2 := createList([]int{1, 3, 4})
	
	fmt.Print("List 1: ")
	printList(list1)
	fmt.Print("List 2: ")
	printList(list2)
	
	merged := mergeTwoLists(list1, list2)
	fmt.Print("Merged: ")
	printList(merged)
}
