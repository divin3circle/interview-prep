# IntelliJ IDEA Setup Guide for Interview Preparation

This guide provides step-by-step instructions for configuring IntelliJ IDEA to maximize productivity during interview preparation and actual technical interviews.

## Initial Setup

### 1. First Launch Configuration

When you first launch IntelliJ IDEA:

1. **Choose UI Theme**
   - Light theme: Better for screen sharing (recommended for interviews)
   - Dark theme: Easier on eyes for extended practice sessions
   - You can change this later: File → Settings → Appearance & Behavior → Appearance

2. **Skip Plugin Installation** (for now)
   - Default plugins are sufficient for interview prep
   - Can add plugins later if needed

3. **Create New Project**
   - Select "New Project"
   - Choose "Java" from left sidebar
   - Name: `interview-prep`
   - Location: Choose preferred directory
   - Build system: "IntelliJ" (simplest option)
   - JDK: Select installed JDK (11 or higher)

### 2. Project Structure Configuration

**File → Project Structure** (Ctrl + Alt + Shift + S)

#### Project Settings

- **Project SDK**: Select JDK 11 or higher
- **Project Language Level**: Match SDK version
- **Project Compiler Output**: Leave default

#### Modules

- **Sources**: Ensure `src` folder is marked as "Sources" (blue folder icon)
- **Paths**: Use default settings

## Editor Configuration

### Code Style Settings

**File → Settings → Editor → Code Style → Java**

#### Tabs and Indents
```
Tab size: 4
Indent: 4
Continuation indent: 8
☑ Use tab character: OFF (use spaces)
```

#### Wrapping and Braces
```
Hard wrap at: 120
☑ Ensure right margin is not exceeded
```

**Braces Placement**:
- Class declaration: End of line
- Method declaration: End of line
- Other: End of line

**Force Braces**:
- ☑ if() statement
- ☑ for() statement
- ☑ while() statement

#### Imports
```
☑ Use single class import
Class count to use import with '*': 999
Names count to use static import with '*': 999
```

**Import Order**:
1. All other imports
2. java.*
3. javax.*

### Font Configuration

**File → Settings → Editor → Font**

```
Font: JetBrains Mono (or Consolas, Monaco)
Size: 14 (increase to 16-18 for screen sharing)
Line height: 1.2
☑ Enable ligatures (optional, for aesthetic)
```

### Auto-Import Settings

**File → Settings → Editor → General → Auto Import**

```
☑ Add unambiguous imports on the fly
☑ Optimize imports on the fly
```

This automatically adds imports as you type, saving time during interviews.

### Code Completion

**File → Settings → Editor → General → Code Completion**

```
☑ Match case: OFF (more flexible)
☑ Show suggestions as you type
☑ Insert selected suggestion by pressing space
```

## Live Templates for Common Patterns

Live templates allow you to type abbreviations that expand into code snippets.

**File → Settings → Editor → Live Templates**

### Create Custom Templates

#### Template 1: Array Iteration
**Abbreviation**: `fora`
```java
for (int i = 0; i < $ARRAY$.length; i++) {
    $ELEMENT_TYPE$ $VAR$ = $ARRAY$[i];
    $END$
}
```

#### Template 2: HashMap Creation
**Abbreviation**: `hashmap`
```java
Map<$KEY_TYPE$, $VALUE_TYPE$> $VAR$ = new HashMap<>();
```

#### Template 3: Test Case
**Abbreviation**: `test`
```java
// Test Case: $DESCRIPTION$
int[] input = {$VALUES$};
int expected = $EXPECTED$;
int actual = solution($PARAMS$);
System.out.println("Expected: " + expected + ", Actual: " + actual);
$END$
```

#### Template 4: Binary Tree Node
**Abbreviation**: `treenode`
```java
TreeNode $VAR$ = new TreeNode($VALUE$);
```

## Useful Plugins (Optional)

**File → Settings → Plugins**

### Recommended for Interview Prep

1. **Key Promoter X**
   - Helps learn keyboard shortcuts
   - Shows shortcut hints when using mouse

2. **Rainbow Brackets**
   - Colors matching brackets
   - Easier to track nested structures

3. **String Manipulation**
   - Quick case conversion
   - Useful for variable naming

**Installation**: Search in Marketplace tab → Install → Restart IDE

## Keyboard Shortcuts Configuration

**File → Settings → Keymap**

### Verify Essential Shortcuts

Ensure these shortcuts are configured (default keymap):

| Action | Shortcut (Windows/Linux) | Shortcut (macOS) |
|--------|-------------------------|------------------|
| Run | Shift + F10 | Ctrl + R |
| Debug | Shift + F9 | Ctrl + D |
| Stop | Ctrl + F2 | Cmd + F2 |
| Reformat Code | Ctrl + Alt + L | Cmd + Option + L |
| Optimize Imports | Ctrl + Alt + O | Ctrl + Option + O |
| Generate | Alt + Insert | Cmd + N |
| Quick Fix | Alt + Enter | Option + Enter |
| Search Everywhere | Double Shift | Double Shift |

### Customize for Efficiency

**Add Custom Shortcut for "Run Main"**:
1. Search for "Run context configuration"
2. Right-click → Add Keyboard Shortcut
3. Set to: Ctrl + Shift + F10 (Windows) or Cmd + Shift + R (macOS)

## Appearance Settings for Interviews

### Presentation Mode

**View → Appearance → Enter Presentation Mode**

This mode:
- Increases font size automatically
- Hides tool windows
- Maximizes editor space
- Perfect for screen sharing

**Exit**: View → Appearance → Exit Presentation Mode

### Distraction-Free Mode

**View → Appearance → Enter Distraction Free Mode**

- Removes all UI elements
- Centers editor
- Good for focused practice

### Font Size Adjustment

**Quick Zoom**: Ctrl + Mouse Wheel (Cmd + Mouse Wheel on macOS)

Enable this:
**File → Settings → Editor → General**
```
☑ Change font size with Ctrl+Mouse Wheel
```

## Debugger Configuration

### Breakpoint Settings

**File → Settings → Build, Execution, Deployment → Debugger**

```
☑ Show debug window on breakpoint
☑ Focus application on breakpoint
```

### Quick Debug Tips

1. **Set Breakpoint**: Click left gutter or Ctrl + F8
2. **Debug Run**: Shift + F9
3. **Step Over**: F8
4. **Step Into**: F7
5. **Evaluate Expression**: Alt + F8

## Performance Optimization

### Increase Memory Allocation

For large projects or heavy usage:

**Help → Edit Custom VM Options**

Add or modify:
```
-Xmx2048m
-Xms512m
```

This allocates more memory to IntelliJ.

### Exclude Unnecessary Directories

**File → Project Structure → Modules → Excluded**

Exclude:
- `out/` (build output)
- `.idea/` (IDE settings)
- Any large non-source directories

## Testing Your Configuration

### Create Test File

1. Right-click `src` → New → Java Class
2. Name: `ConfigTest`
3. Add code:

```java
import java.util.*;

public class ConfigTest {
    public static void main(String[] args) {
        // Test auto-import (should auto-import Arrays)
        int[] arr = {1, 2, 3};
        System.out.println(Arrays.toString(arr));
        
        // Test code completion (type "List" and Ctrl+Space)
        List<Integer> list = new ArrayList<>();
        
        // Test formatting (Ctrl+Alt+L)
        for(int i=0;i<10;i++){System.out.println(i);}
        
        // Test quick fix (Alt+Enter on yellow bulb)
        String unused = "test";
        
        System.out.println("Configuration test complete!");
    }
}
```

4. **Run**: Right-click → Run 'ConfigTest.main()'

### Verification Checklist

- [ ] Code runs successfully
- [ ] Auto-import works (Arrays is imported)
- [ ] Code completion suggests classes
- [ ] Format code (Ctrl+Alt+L) properly indents
- [ ] Quick fix (Alt+Enter) suggests removing unused variable
- [ ] Syntax highlighting is clear
- [ ] Font size is readable

## Interview-Specific Settings

### Before a Virtual Interview

1. **Increase Font Size**: View → Appearance → Increase Font Size (16-18pt)
2. **Light Theme**: File → Settings → Appearance → Theme → IntelliJ Light
3. **Hide Unnecessary Windows**: View → Tool Windows → Hide All
4. **Test Screen Share**: Share screen with friend to verify readability
5. **Close Distractions**: Close email, chat, notifications

### During Interview

1. **Use Presentation Mode**: View → Appearance → Enter Presentation Mode
2. **Think Aloud**: Explain what you're typing
3. **Use Shortcuts**: Demonstrates proficiency
4. **Format Regularly**: Keep code clean with Ctrl+Alt+L

## Troubleshooting

### Issue: Slow Performance

**Solutions**:
- Increase memory allocation (see Performance Optimization)
- Disable unnecessary plugins
- Exclude build directories
- Clear caches: File → Invalidate Caches → Invalidate and Restart

### Issue: Shortcuts Not Working

**Solutions**:
- Check keymap: File → Settings → Keymap
- Verify no conflicts with OS shortcuts
- Try default keymap: Keymap → Reset to defaults

### Issue: Auto-Import Not Working

**Solutions**:
- Enable: File → Settings → Editor → General → Auto Import
- Check if class is in classpath
- Verify JDK is properly configured

### Issue: Cannot Run Code

**Solutions**:
- Verify `public static void main(String[] args)` exists
- Check file is in `src` directory (marked as Sources)
- Rebuild project: Build → Rebuild Project

## Quick Reference Card

Print or save this for quick access:

### Essential Shortcuts
```
Run:              Shift + F10
Format:           Ctrl + Alt + L
Generate:         Alt + Insert
Quick Fix:        Alt + Enter
Search:           Double Shift
Complete:         Ctrl + Space
Comment:          Ctrl + /
Duplicate Line:   Ctrl + D
Delete Line:      Ctrl + Y
```

### Before Interview
```
1. Increase font size (16-18pt)
2. Light theme
3. Test screen share
4. Close distractions
5. Enter Presentation Mode
```

---

**Your IDE should be an extension of your thinking, not an obstacle. Invest time in proper configuration to maximize efficiency during interviews and practice.**

## Next Steps

1. Complete this setup
2. Review [Shortcuts Cheatsheet](shortcuts-cheatsheet.md)
3. Practice with [starter code](starter-code/)
4. Begin solving problems with your configured environment
