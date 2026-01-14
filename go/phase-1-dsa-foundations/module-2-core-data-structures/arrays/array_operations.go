package main

import (
	"fmt"
	"sort"
)

// ========================================================================
// BASIC OPERATIONS
// ========================================================================

// AccessElement gets element at specific index.
// Time: O(1)
func AccessElement(arr []int, index int) int {
	if index < 0 || index >= len(arr) {
		panic(fmt.Sprintf("Index %d out of bounds", index))
	}
	return arr[index] // Go naturally panics, but explicit check is fine for clarity
}

// LinearSearch finds element in unsorted slice.
// Time: O(n)
func LinearSearch(arr []int, target int) int {
	for i, v := range arr {
		if v == target {
			return i
		}
	}
	return -1
}

// BinarySearch finds element in sorted slice.
// Time: O(log n)
func BinarySearch(arr []int, target int) int {
	left, right := 0, len(arr)-1
	
	for left <= right {
		mid := left + (right-left)/2
		
		if arr[mid] == target {
			return mid
		} else if arr[mid] < target {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	return -1
}

// ========================================================================
// INSERTION/DELETION OPERATIONS
// ========================================================================

// InsertAtEnd adds element. Go's append is O(1) amortized.
func InsertAtEnd(arr []int, val int) []int {
	return append(arr, val)
}

// InsertAtPosition inserts value at index.
// Time: O(n) - Must shift elements
func InsertAtPosition(arr []int, index int, value int) []int {
	if index < 0 || index > len(arr) {
		panic("Invalid index")
	}
	
	// Create space: append zero value
	arr = append(arr, 0)
	
	// Shift elements: copy(dst, src)
	// We want to move elements from [index...] to [index+1...]
	copy(arr[index+1:], arr[index:])
	
	// Insert value
	arr[index] = value
	return arr
}

// DeleteAtPosition removes element at index.
// Time: O(n)
func DeleteAtPosition(arr []int, index int) []int {
	if index < 0 || index >= len(arr) {
		panic("Invalid index")
	}
	// Combine slice before index and slice after index
	return append(arr[:index], arr[index+1:]...)
}

// ========================================================================
// TWO POINTER TECHNIQUES
// ========================================================================

// RemoveDuplicates from sorted slice (in-place).
// Returns new length (or sliced slice).
// Time: O(n)
func RemoveDuplicates(arr []int) []int {
	if len(arr) == 0 {
		return arr
	}
	
	writeIndex := 1
	for readIndex := 1; readIndex < len(arr); readIndex++ {
		if arr[readIndex] != arr[readIndex-1] {
			arr[writeIndex] = arr[readIndex]
			writeIndex++
		}
	}
	
	return arr[:writeIndex]
}

// TwoSumSorted finds indices of two numbers that add up to target.
// Time: O(n)
func TwoSumSorted(arr []int, target int) []int {
	left, right := 0, len(arr)-1
	
	for left < right {
		sum := arr[left] + arr[right]
		if sum == target {
			return []int{left, right}
		} else if sum < target {
			left++
		} else {
			right--
		}
	}
	return []int{-1, -1}
}

// ========================================================================
// SLIDING WINDOW
// ========================================================================

// MaxSumSubarray returns max sum of subarray of size k.
// Time: O(n)
func MaxSumSubarray(arr []int, k int) int {
	if len(arr) < k {
		panic("Array smaller than window")
	}
	
	windowSum := 0
	// First window
	for i := 0; i < k; i++ {
		windowSum += arr[i]
	}
	
	maxSum := windowSum
	
	// Slide
	for i := k; i < len(arr); i++ {
		windowSum = windowSum - arr[i-k] + arr[i]
		if windowSum > maxSum {
			maxSum = windowSum
		}
	}
	return maxSum
}

// ========================================================================
// KADANE'S ALGORITHM
// ========================================================================

// MaxSubarraySum (Kadane's) handles negative numbers.
// Time: O(n)
func MaxSubarraySum(arr []int) int {
	if len(arr) == 0 {
		return 0
	}
	
	maxSoFar := arr[0]
	maxEndingHere := arr[0]
	
	for i := 1; i < len(arr); i++ {
		// Start new subarray or extend
		if arr[i] > maxEndingHere+arr[i] {
			maxEndingHere = arr[i]
		} else {
			maxEndingHere += arr[i]
		}
		
		if maxEndingHere > maxSoFar {
			maxSoFar = maxEndingHere
		}
	}
	return maxSoFar
}

// ========================================================================
// UTILS
// ========================================================================

func Reverse(arr []int) {
	for i, j := 0, len(arr)-1; i < j; i, j = i+1, j-1 {
		arr[i], arr[j] = arr[j], arr[i]
	}
}

// Main function to demonstrate
func main() {
	fmt.Println("=== Array/Slice Operations Demo ===")
	
	arr := []int{5, 2, 8, 1, 9, 3}
	fmt.Printf("Original: %v\n", arr)
	
	// Insert
	arr = InsertAtEnd(arr, 99)
	fmt.Printf("Append 99: %v\n", arr)
	
	arr = InsertAtPosition(arr, 2, 42)
	fmt.Printf("Insert 42 at idx 2: %v\n", arr)
	
	// Delete
	arr = DeleteAtPosition(arr, 2)
	fmt.Printf("Deleted idx 2: %v\n", arr)
	
	// Sort
	sort.Ints(arr)
	fmt.Printf("Sorted: %v\n", arr)
	
	// Binary Search
	idx := BinarySearch(arr, 8)
	fmt.Printf("Binary Search for 8: index %d\n", idx)
	
	// Two Sum
	sortedNums := []int{1, 3, 5, 7, 9, 11}
	pair := TwoSumSorted(sortedNums, 12)
	fmt.Printf("Two Sum (12) on %v: indices %v\n", sortedNums, pair)
	
	// Sliding Window
	swNums := []int{1, 4, 2, 10, 23, 3, 1, 0, 20}
	fmt.Printf("Max sum window(4) of %v: %d\n", swNums, MaxSumSubarray(swNums, 4))
	
	// Kadane
	negNums := []int{-2, 1, -3, 4, -1, 2, 1, -5, 4}
	fmt.Printf("Max subarray sum of %v: %d\n", negNums, MaxSubarraySum(negNums))
}
