package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

// addTwoNumbers adds two numbers represented as linked lists.
// Time: O(max(N, M))
// Space: O(max(N, M))
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	dummy := &ListNode{}
	curr := dummy
	carry := 0
	
	for l1 != nil || l2 != nil || carry != 0 {
		sum := carry
		
		if l1 != nil {
			sum += l1.Val
			l1 = l1.Next
		}
		if l2 != nil {
			sum += l2.Val
			l2 = l2.Next
		}
		
		carry = sum / 10
		curr.Next = &ListNode{Val: sum % 10}
		curr = curr.Next
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
	l1 := createList([]int{2, 4, 3}) // 342
	l2 := createList([]int{5, 6, 4}) // 465
	
	fmt.Print("L1: ")
	printList(l1)
	fmt.Print("L2: ")
	printList(l2)
	
	result := addTwoNumbers(l1, l2)
	fmt.Print("Sum: ")
	printList(result) // 807 -> [7,0,8]
}
