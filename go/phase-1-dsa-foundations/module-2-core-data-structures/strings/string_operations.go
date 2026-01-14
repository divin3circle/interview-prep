package main

import (
	"fmt"
	"sort"
	"strconv"
	"strings"
	"unicode"
)

// ========================================================================
// BASIC OPERATIONS
// ========================================================================

func DemonstrateBasicOperations() {
	fmt.Println("--- Basic String Operations ---")
	s := "Hello, World!"

	// 1. Length - O(1)
	fmt.Printf("Length (bytes): %d\n", len(s))

	// 2. Access Byte - O(1)
	fmt.Printf("Byte at index 1: %c\n", s[1])

	// 3. Substring - O(1)
	// s[start:end] -> start inclusive, end exclusive (shares memory!)
	fmt.Printf("Substring (0-5): %s\n", s[0:5])
	fmt.Printf("Substring (7+): %s\n", s[7:])

	// 4. Search - O(n*m)
	fmt.Printf("Index of 'World': %d\n", strings.Index(s, "World"))
	fmt.Printf("Contains 'Hello': %v\n", strings.Contains(s, "Hello"))

	// 5. Comparison
	s1 := "GoLang"
	s2 := "GoLang"
	// Direct comparison compares content in Go!
	fmt.Printf("s1 == s2: %v\n", s1 == s2)
	
	// Case insensitive
	fmt.Printf("EqualFold: %v\n", strings.EqualFold("golang", "GOLANG"))
}

// ========================================================================
// STRINGS BUILDER
// ========================================================================

func DemonstrateBuilder() {
	fmt.Println("\n--- strings.Builder (Mutable) ---")
	var sb strings.Builder

	// 1. WriteString - O(1) amortized
	sb.WriteString("Hello")
	sb.WriteString(" ")
	sb.WriteString("World")
	fmt.Printf("Built String: %s\n", sb.String())
	
	// Be careful: strings.Builder doesn't have Insert/DeleteAt methods like Java StringBuilder.
	// You have to manipulate slices for that or rebuild.
	
	// Reset to reuse buffer
	sb.Reset()
	sb.WriteString("Clean")
	fmt.Printf("Reset String: %s\n", sb.String())
}

// ========================================================================
// CHARACTER MANIPULATION (RUNES)
// ========================================================================

func DemonstrateRunes() {
	fmt.Println("\n--- Rune Manipulation ---")
	text := "Go 101"
	
	for _, r := range text {
		if unicode.IsLetter(r) {
			fmt.Print("L")
		} else if unicode.IsDigit(r) {
			fmt.Print("D")
		} else if unicode.IsSpace(r) {
			fmt.Print("_")
		}
	}
	fmt.Println()
}

// ========================================================================
// CONVERSIONS
// ========================================================================

func DemonstrateConversions() {
	fmt.Println("\n--- Conversions ---")
	
	// String to Rune Slice (Mutable char array equivalent)
	s := "hello"
	chars := []rune(s)
	// Sort runes (need specific slice sort wrapper or custom)
	sort.Slice(chars, func(i, j int) bool {
		return chars[i] < chars[j]
	})
	sorted := string(chars)
	fmt.Printf("Sorted String: %s\n", sorted)
	
	// Int to String
	numStr := strconv.Itoa(123)
	fmt.Printf("Int to String: %s\n", numStr)
	
	// String to Int
	n, err := strconv.Atoi("123")
	if err == nil {
		fmt.Printf("String to Int: %d\n", n)
	}
}

func main() {
	DemonstrateBasicOperations()
	DemonstrateBuilder()
	DemonstrateRunes()
	DemonstrateConversions()
}
