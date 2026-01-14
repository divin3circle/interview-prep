package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

// reverseList reverses a singly linked list.
// Time: O(N)
// Space: O(1)
func reverseList(head *ListNode) *ListNode {
	var prev *ListNode
	curr := head
	
	for curr != nil {
		next := curr.Next
		curr.Next = prev
		prev = curr
		curr = next
	}
	
	return prev
}

// Helper functions for testing
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
	tests := [][]int{
		{1, 2, 3, 4, 5},
		{1, 2},
		{},
	}
	
	for i, test := range tests {
		head := createList(test)
		fmt.Printf("Test %d: Input: ", i+1)
		printList(head)
		reversed := reverseList(head)
		fmt.Printf("Output: ")
		printList(reversed)
		fmt.Println()
	}
}
