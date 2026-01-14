# Module 0.3: Tools Setup

## Introduction

Efficient problem-solving requires a properly configured development environment. This module guides you through setting up VS Code (or GoLand) for optimal productivity during interview preparation and actual interviews. A well-configured ecosystem allows you to focus on problem-solving rather than fighting with your tools.

## Prerequisites

- Go 1.21 or higher installed
- VS Code (free) or GoLand (paid/educational)
- Basic familiarity with terminal/command line

## Go Environment Setup

### 1. Install Go
- Visit: https://go.dev/dl/
- Download and install the version for your OS.
- Verify installation in terminal:
  ```bash
  go version
  ```

### 2. IDE Selection

**Option A: VS Code (Recommended for most)**
- Free, lightweight, standard in the Go community.
- Requires "Go" extension by the Go Team.

**Option B: GoLand (JetBrains)**
- Powerful, feature-rich, familiar if you come from IntelliJ/Java.
- Requires subscription.

### Initial Configuration

See [VS Code Setup Guide](vscode-setup.md) for detailed configuration instructions.

## Project Structure for Interview Prep

### Recommended Organization

```
interview-prep/
├── go.mod
├── arrays/
│   ├── two_sum.go
│   ├── two_sum_test.go
│   └── ...
├── strings/
├── linkedlists/
├── trees/
└── utils/
    ├── tree_node.go
    ├── list_node.go
    └── test_utils.go
```

### Creating Your Project

1. **Create Directory**:
   ```bash
   mkdir interview-prep
   cd interview-prep
   ```

2. **Initialize Go Module**:
   ```bash
   go mod init interview-prep
   ```

3. **Open in IDE**:
   ```bash
   code . # For VS Code
   # or open directory in GoLand
   ```

## Starter Code Templates

This repository provides essential starter code that you'll use repeatedly. Copy these files to your project's `utils` package.

### Core Data Structure Structs

- **[tree_node.go](starter-code/utils/tree_node.go)**: Binary tree node implementation
- **[list_node.go](starter-code/utils/list_node.go)**: Linked list node implementation
- **[test_utils.go](starter-code/utils/test_utils.go)**: Helper methods for testing

### Solution Template

- **[solution_template.go](starter-code/solution_template.go)**: Template for problem solutions

## Essential Keyboard Shortcuts

Mastering keyboard shortcuts dramatically improves coding speed. See [Shortcuts Cheatsheet](shortcuts-cheatsheet.md) for a comprehensive list.

### Top 10 Must-Know Shortcuts (VS Code)

| Action | Windows/Linux | macOS |
|--------|--------------|-------|
| Run Tests | `Ctrl` + `;` then `Ctrl` + `A` | `Ctrl` + `;` then `Ctrl` + `A` |
| Auto-complete | `Ctrl` + `Space` | `Ctrl` + `Space` |
| Quick Fix | `Ctrl` + `.` | `Cmd` + `.` |
| Format code | `Shift` + `Alt` + `F` | `Shift` + `Option` + `F` |
| Rename Symbol | `F2` | `F2` |
| Go to Definition | `F12` | `F12` |
| Comment/Uncomment | `Ctrl` + `/` | `Cmd` + `/` |
| Duplicate line | `Shift` + `Alt` + `Down` | `Shift` + `Option` + `Down` |
| Delete line | `Ctrl` + `Shift` + `K` | `Cmd` + `Shift` + `K` |
| Parameter Hints | `Ctrl` + `Shift` + `Space` | `Cmd` + `Shift` + `Space` |

## Interview Coding Best Practices

### Code Style Settings

Go has a standard formatter (`gofmt`). Your IDE should be configured to format on save.

1. **Naming**: `camelCase` for local variables, `PascalCase` for exported.
2. **Error Handling**: Explicit check (`if err != nil`).
3. **Imports**: Managed automatically by `goimports` (enable in IDE).

### Snippets

Create snippets for common patterns:

**Snippet: `test`** → Table-Driven Test Template
```go
func TestName(t *testing.T) {
    tests := []struct{
        name string
        input int
        want int
    }{
        {"base case", 0, 0},
    }
    for _, tt := range tests {
        t.Run(tt.name, func(t *testing.T) {
            got := Solution(tt.input)
            if got != tt.want {
                t.Errorf("got %v, want %v", got, tt.want)
            }
        })
    }
}
```

## Testing Your Setup

### Quick Verification

1. **Create a new Go file**: `main.go`
2. **Copy the following code**:

```go
package main

import (
	"fmt"
)

func main() {
	// Test basic functionality
	nums := []int{2, 7, 11, 15}
	target := 9

	fmt.Println("Testing environment setup...")
	fmt.Printf("Slice: %v\n", nums)
	fmt.Printf("Target: %d\n", target)

	// Test data structures
	// Note: In Go we use built-in maps
	m := make(map[int]int)
	m[2] = 0
	
	_, exists := m[2]
	fmt.Printf("Map working: %v\n", exists)

	fmt.Println("Setup verified successfully!")
}
```

3. **Run the file**:
   ```bash
   go run main.go
   ```

4. **Expected output**:
```
Testing environment setup...
Slice: [2 7 11 15]
Target: 9
Map working: true
Setup verified successfully!
```

## Common Setup Issues

### Issue 1: GOPATH/Module Errors
**Symptom**: "go.mod file not found"
**Solution**: Run `go mod init <name>` in your project root.

### Issue 2: Imports Not Resolving
**Symptom**: Red underlines on standard library packages.
**Solution**: Reload window in VS Code (`Cmd+Shift+P` -> "Developer: Reload Window") or ensure you opened the folder containing `go.mod`.

## Optimization for Interview Scenarios

### For Virtual Interviews
1. **Increase Font Size**: `Cmd` + `+`
2. **Zen Mode**: `Cmd` + `K` then `Z` (VS Code)
3. **Test Screen Sharing**: Ensure code is readable.

### For Coding on Whiteboard
1. **Practice Without `gopls`**: Try writing code in a plain text editor sometimes.
2. **Focus on Idioms**: Know how to write loops, map checks, and slice operations from memory.

## Next Steps

1. **Complete the Setup**: Follow [VS Code Setup Guide](vscode-setup.md)
2. **Copy Starter Code**: Add [starter code](starter-code/) to your project
3. **Test Your Environment**: Run the verification code above
4. **Start Practicing**: Begin with [Phase 1: DSA Foundations](../../phase-1-dsa-foundations/README.md)

## Additional Resources

- **Go Documentation**: https://go.dev/doc/
- **Go Tour**: https://go.dev/tour/
- **Effective Go**: https://go.dev/doc/effective_go

---

**Your development environment is a tool that should enhance, not hinder, your problem-solving. Invest time in proper setup now to save countless hours during practice and interviews.**
