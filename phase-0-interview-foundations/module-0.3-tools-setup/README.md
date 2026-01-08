# Module 0.3: Tools Setup

## Introduction

Efficient problem-solving requires a properly configured development environment. This module guides you through setting up IntelliJ IDEA for optimal productivity during interview preparation and actual interviews. A well-configured IDE allows you to focus on problem-solving rather than fighting with your tools.

## Prerequisites

- Java Development Kit (JDK) 11 or higher
- IntelliJ IDEA (Community Edition is sufficient)
- Basic familiarity with Java programming

## IntelliJ IDEA Installation

### Download and Install

1. **Download IntelliJ IDEA**
   - Visit: https://www.jetbrains.com/idea/download/
   - Choose Community Edition (free) or Ultimate Edition
   - Select your operating system

2. **Install JDK** (if not already installed)
   - IntelliJ can download and configure JDK automatically
   - Alternatively, download from: https://adoptium.net/
   - Recommended: JDK 17 LTS or JDK 21 LTS

3. **Run the Installer**
   - Follow platform-specific installation instructions
   - Accept default settings for first-time users

### Initial Configuration

See [IntelliJ Setup Guide](intellij-setup.md) for detailed configuration instructions.

## Project Structure for Interview Prep

### Recommended Organization

```
interview-prep/
├── src/
│   ├── arrays/
│   │   ├── TwoSum.java
│   │   ├── ContainsDuplicate.java
│   │   └── ...
│   ├── strings/
│   ├── linkedlists/
│   ├── trees/
│   └── utils/
│       ├── TreeNode.java
│       ├── ListNode.java
│       └── TestUtils.java
└── README.md
```

### Creating Your Project

1. **Open IntelliJ IDEA**
2. **New Project** → Select "Java"
3. **Project Name**: interview-prep
4. **Location**: Choose your preferred directory
5. **Build System**: None (for simplicity) or Maven/Gradle
6. **JDK**: Select installed JDK
7. **Click Create**

## Starter Code Templates

This repository provides essential starter code that you'll use repeatedly. Copy these files to your project's `utils` package.

### Core Data Structure Classes

- **[TreeNode.java](starter-code/TreeNode.java)**: Binary tree node implementation
- **[ListNode.java](starter-code/ListNode.java)**: Linked list node implementation
- **[TestUtils.java](starter-code/TestUtils.java)**: Helper methods for testing

### Solution Template

- **[Solution.java](starter-code/Solution.java)**: Template for problem solutions

## Essential Keyboard Shortcuts

Mastering keyboard shortcuts dramatically improves coding speed. See [Shortcuts Cheatsheet](shortcuts-cheatsheet.md) for a comprehensive list.

### Top 10 Must-Know Shortcuts

| Action | Windows/Linux | macOS |
|--------|--------------|-------|
| Run main method | Ctrl + Shift + F10 | Cmd + Shift + R |
| Auto-complete | Ctrl + Space | Cmd + Space |
| Generate code | Alt + Insert | Cmd + N |
| Format code | Ctrl + Alt + L | Cmd + Option + L |
| Rename | Shift + F6 | Shift + F6 |
| Find | Ctrl + F | Cmd + F |
| Comment/Uncomment | Ctrl + / | Cmd + / |
| Duplicate line | Ctrl + D | Cmd + D |
| Delete line | Ctrl + Y | Cmd + Backspace |
| Show documentation | Ctrl + Q | Ctrl + J |

## Interview Coding Best Practices

### Code Style Settings

Configure IntelliJ to match common interview expectations:

1. **Indentation**: 4 spaces (Java standard)
2. **Line Length**: 100-120 characters
3. **Braces**: Always use braces for if/while/for
4. **Imports**: Auto-organize, no wildcards

### Live Templates

Create live templates for common patterns:

**Template: `psvm`** → `public static void main(String[] args)`
```java
public static void main(String[] args) {
    $END$
}
```

**Template: `sout`** → `System.out.println()`
```java
System.out.println($END$);
```

**Template: `fori`** → `for (int i = 0; i < ; i++)`
```java
for (int i = 0; i < $END$; i++) {
    
}
```

## Testing Your Setup

### Quick Verification

1. **Create a new Java file**: `TestSetup.java`
2. **Copy the following code**:

```java
public class TestSetup {
    public static void main(String[] args) {
        // Test basic functionality
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        
        System.out.println("Testing environment setup...");
        System.out.println("Array: " + java.util.Arrays.toString(nums));
        System.out.println("Target: " + target);
        
        // Test data structures
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
        map.put(2, 0);
        System.out.println("HashMap working: " + map.containsKey(2));
        
        System.out.println("Setup verified successfully!");
    }
}
```

3. **Run the file**: Right-click → Run 'TestSetup.main()'
4. **Expected output**:
```
Testing environment setup...
Array: [2, 7, 11, 15]
Target: 9
HashMap working: true
Setup verified successfully!
```

If you see this output, your environment is correctly configured.

## Common Setup Issues

### Issue 1: JDK Not Found

**Symptom**: "Project JDK is not defined"

**Solution**:
1. File → Project Structure → Project
2. Click "Edit" next to SDK
3. Add JDK → Select installation directory
4. Apply changes

### Issue 2: Cannot Run Main Method

**Symptom**: No run option appears

**Solution**:
1. Ensure file has `public static void main(String[] args)`
2. Right-click in editor → Run
3. Check that file is in `src` directory

### Issue 3: Imports Not Working

**Symptom**: Red underlines on Java classes

**Solution**:
1. File → Invalidate Caches → Invalidate and Restart
2. Verify JDK is properly configured
3. Check that file is in a source directory

## Optimization for Interview Scenarios

### For Virtual Interviews

1. **Increase Font Size**: View → Appearance → Increase Font Size (Ctrl + Mouse Wheel)
2. **Disable Distractions**: View → Appearance → Enter Presentation Mode
3. **Test Screen Sharing**: Ensure code is readable when shared

### For Coding on Whiteboard/CoderPad

1. **Practice Without Autocomplete**: Temporarily disable to build muscle memory
2. **Focus on Syntax**: IntelliJ highlights errors, but whiteboards don't
3. **Manual Testing**: Practice running code mentally before executing

## Next Steps

1. **Complete the Setup**: Follow [IntelliJ Setup Guide](intellij-setup.md)
2. **Learn Shortcuts**: Study [Shortcuts Cheatsheet](shortcuts-cheatsheet.md)
3. **Copy Starter Code**: Add [starter code](starter-code/) to your project
4. **Test Your Environment**: Run the verification code above
5. **Start Practicing**: Begin with [Phase 1: DSA Foundations](../../phase-1-dsa-foundations/README.md)

## Additional Resources

- **IntelliJ Documentation**: https://www.jetbrains.com/help/idea/
- **Java Tutorials**: https://docs.oracle.com/javase/tutorial/
- **Keyboard Shortcuts PDF**: [Download from JetBrains](https://www.jetbrains.com/idea/docs/IntelliJIDEA_ReferenceCard.pdf)

---

**Your development environment is a tool that should enhance, not hinder, your problem-solving. Invest time in proper setup now to save countless hours during practice and interviews.**
