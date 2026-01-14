package main

import "fmt"

func DemonstrateMap() {
	fmt.Println("--- Map Operations ---")
	// Key: Name, Value: Age
	m := make(map[string]int)

	// 1. Put
	m["Alice"] = 25
	m["Bob"] = 30
	m["Alice"] = 26 // Update
	fmt.Printf("Map: %v\n", m)

	// 2. Get
	fmt.Printf("Alice's Age: %d\n", m["Alice"])
	
	// Get with check
	val, exists := m["Charlie"]
	if !exists {
		fmt.Printf("Charlie not found (default int: %d)\n", val)
	}

	// 3. Delete
	delete(m, "Bob")
	
	// 4. Iteration (Order is random!)
	fmt.Print("Entries: ")
	for k, v := range m {
		fmt.Printf("%s=%d ", k, v)
	}
	fmt.Println()
}

func DemonstrateSet() {
	fmt.Println("\n--- Set (map[T]bool) Operations ---")
	set := make(map[string]bool)

	// 1. Add
	set["Apple"] = true
	set["Banana"] = true
	set["Apple"] = true // Duplicate (no-op effectively)
	
	fmt.Printf("Set: %v\n", set)

	// 2. Check Exists
	if set["Banana"] {
		fmt.Println("Has Banana")
	}

	// 3. Delete
	delete(set, "Banana")
	fmt.Printf("Has Banana? %v\n", set["Banana"])
}

func DemonstrateFrequencyCount() {
	fmt.Println("\n--- Frequency Count Pattern ---")
	arr := []string{"apple", "banana", "apple", "orange", "banana", "apple"}
	counts := make(map[string]int)

	for _, s := range arr {
		counts[s]++
	}

	fmt.Printf("Frequencies: %v\n", counts)
}

func main() {
	DemonstrateMap()
	DemonstrateSet()
	DemonstrateFrequencyCount()
}
