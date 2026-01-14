package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

// reorderList reorders list to L0→Ln→L1→Ln-1→L2→Ln-2→…
// Time: O(N)
// Space: O(1)
func reorderList(head *ListNode) {
	if head == nil || head.Next == nil {
		return
	}
	
	// Step 1: Find middle using slow/fast pointers
	slow, fast := head, head
	for fast.Next != nil && fast.Next.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
	}
	
	// Step 2: Reverse second half
	second := reverseList(slow.Next)
	slow.Next = nil // Split the list
	
	// Step 3: Merge two halves
	first := head
	for second != nil {
		tmp1, tmp2 := first.Next, second.Next
		first.Next = second
		second.Next = tmp1
		first, second = tmp1, tmp2
	}
}

func reverseList(head *ListNode) *ListNode {
	var prev *ListNode
	for head != nil {
		next := head.Next
		head.Next = prev
		prev = head
		head = next
	}
	return prev
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
	tests := [][]int{
		{1, 2, 3, 4},
		{1, 2, 3, 4, 5},
	}
	
	for i, test := range tests {
		head := createList(test)
		fmt.Printf("Test %d: Input: ", i+1)
		printList(head)
		reorderList(head)
		fmt.Printf("Output: ")
		printList(head)
		fmt.Println()
	}
}
