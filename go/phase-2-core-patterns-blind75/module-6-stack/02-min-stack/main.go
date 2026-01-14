package main

import "fmt"

type MinStack struct {
	stack    []int
	minStack []int
}

func Constructor() MinStack {
	return MinStack{
		stack:    []int{},
		minStack: []int{},
	}
}

func (this *MinStack) Push(val int) {
	this.stack = append(this.stack, val)
	
	// If minStack is empty or val is <= current min, push to minStack
	if len(this.minStack) == 0 || val <= this.minStack[len(this.minStack)-1] {
		this.minStack = append(this.minStack, val)
	}
}

func (this *MinStack) Pop() {
	if len(this.stack) == 0 {
		return
	}
	
	val := this.stack[len(this.stack)-1]
	this.stack = this.stack[:len(this.stack)-1]
	
	// If popped value is the current minimum, remove from minStack too
	if val == this.minStack[len(this.minStack)-1] {
		this.minStack = this.minStack[:len(this.minStack)-1]
	}
}

func (this *MinStack) Top() int {
	if len(this.stack) == 0 {
		return 0
	}
	return this.stack[len(this.stack)-1]
}

func (this *MinStack) GetMin() int {
	if len(this.minStack) == 0 {
		return 0
	}
	return this.minStack[len(this.minStack)-1]
}

func main() {
	obj := Constructor()
	obj.Push(-2)
	obj.Push(0)
	obj.Push(-3)
	
	m1 := obj.GetMin()
	fmt.Printf("GetMin(): %d (Expected -3)\n", m1)
	
	obj.Pop()
	
	t := obj.Top()
	fmt.Printf("Top(): %d (Expected 0)\n", t)
	
	m2 := obj.GetMin()
	fmt.Printf("GetMin(): %d (Expected -2)\n", m2)
}
