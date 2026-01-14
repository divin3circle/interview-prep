package utils

import (
	"reflect"
	"testing"
)

// AssertEqual checks if two values are equal.
func AssertEqual(t *testing.T, got, want interface{}, msg string) {
	t.Helper()
	if !reflect.DeepEqual(got, want) {
		t.Errorf("%s: got %v, want %v", msg, got, want)
	}
}

// IntSliceEqual checks if two integer slices are equal.
func IntSliceEqual(a, b []int) bool {
	if len(a) != len(b) {
		return false
	}
	for i := range a {
		if a[i] != b[i] {
			return false
		}
	}
	return true
}
