package main

import "fmt"

// topKFrequent returns k most frequent elements using Bucket Sort.
// Time: O(N)
// Space: O(N)
func topKFrequent(nums []int, k int) []int {
	// 1. Count frequencies
	counts := make(map[int]int)
	for _, n := range nums {
		counts[n]++
	}
	
	// 2. Create buckets where index = frequency
	// Max possible frequency is len(nums)
	buckets := make([][]int, len(nums)+1)
	for n, count := range counts {
		buckets[count] = append(buckets[count], n)
	}
	
	// 3. Collect from end (highest freq)
	var res []int
	for i := len(buckets) - 1; i > 0; i-- {
		if len(buckets[i]) > 0 {
			res = append(res, buckets[i]...)
			if len(res) >= k {
				return res[:k]
			}
		}
	}
	
	return res
}

func main() {
	nums := []int{1, 1, 1, 2, 2, 3}
	k := 2
	result := topKFrequent(nums, k)
	fmt.Printf("Input: %v, k=%d\n", nums, k)
	fmt.Printf("Output: %v\n", result)
}
