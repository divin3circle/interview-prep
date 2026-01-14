# VS Code Setup Guide for Go

Visual Studio Code (VS Code) is the most popular editor for Go development, thanks to the excellent support provided by the Go Team's extension.

## 1. Installation

1. **Download VS Code**: https://code.visualstudio.com/
2. **Install Go**: https://go.dev/dl/ (if not already done)

## 2. Extension Setup

1. Open VS Code.
2. Click on the **Extensions** icon in the sidebar (or press `Cmd+Shift+X`).
3. Search for **"Go"**.
4. Install the extension by **Go Team at Google**.

## 3. Tool Installation

The Go extension relies on a set of command-line tools.
1. Open the Command Palette (`Cmd+Shift+P`).
2. Type and select **"Go: Install/Update Tools"**.
3. Select all available tools (gopls, dlv, staticcheck, etc.).
4. Click **OK**.

## 4. Recommended Settings

Add these to your `settings.json` (`Cmd+,` then click "Open JSON") for an optimal experience:

```json
{
    "[go]": {
        "editor.defaultFormatter": "golang.go",
        "editor.formatOnSave": true,
        "editor.codeActionsOnSave": {
            "source.organizeImports": true
        }
    },
    "gopls": {
        "usePlaceholders": true,
        "completionDocumentation": true
    },
    "files.autoSave": "afterDelay"
}
```

## 5. Debugging Setup

1. Open a Go file with a `main()` function.
2. Press `F5` to start debugging.
3. VS Code might ask to create a `launch.json`. Select **"Go: Launch Package"**.

Example `launch.json` for a directory:
```json
{
    "version": "0.2.0",
    "configurations": [
        {
            "name": "Launch Package",
            "type": "go",
            "request": "launch",
            "mode": "auto",
            "program": "${workspaceFolder}"
        }
    ]
}
```

## 6. Verification

1. Create a `main.go`.
2. Type `pkgm` and press Tab (if using snippets) or type:
   ```go
   package main
   import "fmt"
   func main() {
       fmt.Println("Hello Go")
   }
   ```
3. Save the file. Verify that `import "fmt"` was not removed (it might be removed if unused, but here it is used).
4. Run with `F5` or `Ctrl+F5`.

## Troubleshooting

- **Intellisense not working?** Reload the window (`Cmd+Shift+P` -> "Reload Window").
- **"gopls" error?** Run "Go: Install/Update Tools" again.
