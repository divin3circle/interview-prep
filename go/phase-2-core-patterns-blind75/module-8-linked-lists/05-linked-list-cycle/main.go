package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

// hasCycle detects if linked list has a cycle using Floyd's algorithm.
// Time: O(N)
// Space: O(1)
func hasCycle(head *ListNode) bool {
	slow, fast := head, head
	
	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
		
		if slow == fast {
			return true
		}
	}
	
	return false
}

func main() {
	// Test case 1: No cycle
	head1 := &ListNode{Val: 1}
	head1.Next = &ListNode{Val: 2}
	head1.Next.Next = &ListNode{Val: 3}
	fmt.Printf("List without cycle: %v\n", hasCycle(head1))
	
	// Test case 2: With cycle
	head2 := &ListNode{Val: 1}
	node2 := &ListNode{Val: 2}
	head2.Next = node2
	head2.Next.Next = &ListNode{Val: 3}
	head2.Next.Next.Next = node2 // Create cycle
	fmt.Printf("List with cycle: %v\n", hasCycle(head2))
}
