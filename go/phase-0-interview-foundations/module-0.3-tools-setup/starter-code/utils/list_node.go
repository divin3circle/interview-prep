package utils

import "fmt"

// ListNode definition for singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

// NewListNode creates a new node with the given value.
func NewListNode(val int) *ListNode {
	return &ListNode{Val: val}
}

// PrintList prints the linked list from the current node.
func (head *ListNode) PrintList() {
	curr := head
	for curr != nil {
		fmt.Printf("%d -> ", curr.Val)
		curr = curr.Next
	}
	fmt.Println("nil")
}

// ArrayToList converts a slice of integers to a linked list.
func ArrayToList(nums []int) *ListNode {
	if len(nums) == 0 {
		return nil
	}
	head := &ListNode{Val: nums[0]}
	curr := head
	for i := 1; i < len(nums); i++ {
		curr.Next = &ListNode{Val: nums[i]}
		curr = curr.Next
	}
	return head
}
