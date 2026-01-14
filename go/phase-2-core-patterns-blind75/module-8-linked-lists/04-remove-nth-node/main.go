package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

// removeNthFromEnd removes nth node from end of list.
// Time: O(N)
// Space: O(1)
func removeNthFromEnd(head *ListNode, n int) *ListNode {
	dummy := &ListNode{Next: head}
	first, second := dummy, dummy
	
	// Move first n+1 steps ahead
	for i := 0; i <= n; i++ {
		first = first.Next
	}
	
	// Move both until first reaches end
	for first != nil {
		first = first.Next
		second = second.Next
	}
	
	// Remove nth node from end
	second.Next = second.Next.Next
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
	head := createList([]int{1, 2, 3, 4, 5})
	fmt.Print("Input: ")
	printList(head)
	
	result := removeNthFromEnd(head, 2)
	fmt.Print("After removing 2nd from end: ")
	printList(result)
}
