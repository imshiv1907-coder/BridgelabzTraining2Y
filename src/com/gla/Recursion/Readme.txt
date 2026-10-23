PROBLEM 1: UNDERSTANDING RECURSION MECHANICS Java Program: Directory Size Calculator

(a) RECURSIVE FUNCTION STRUCTURE

Java Code:

import java.io.File;

public class DirectorySizeCalculator {

public static long calculateSize(File file) {

    // Base case: If the item is a file, return its size
    if (file.isFile()) {
        return file.length();
    }

    // Recursive case: If it is a directory, calculate
    // the size of all files and subdirectories
    long totalSize = 0;
    File[] contents = file.listFiles();

    if (contents != null) {
        for (File item : contents) {
            totalSize += calculateSize(item);
        }
    }

    return totalSize;
}

public static void main(String[] args) {

    File directory = new File("project");

    long totalSize = calculateSize(directory);

    System.out.println("Total Directory Size: "
            + totalSize / 1024.0 + " KB");
}


}

Explanation:

Base Case: If the current item is a file, the function returns its size using file.length(). No further recursive calls are required.

Recursive Case: If the current item is a directory, the function visits each file and subdirectory recursively and adds their sizes to calculate the total directory size.

(b) EXECUTION TRACE AND CALL STACK

Given Directory Structure:

project/ |-- src/ | |-- main.java (100 KB) | |-- utils.java (50 KB) |-- docs/ | |-- readme.txt (10 KB) | |-- guides/ | |-- setup.pdf (200 KB) |-- config.xml (20 KB)

Step 1: calculateSize(project) is called. The directory contains src, docs, and config.xml.

Step 2: calculateSize(src) is called. calculateSize(main.java) returns 100 KB. calculateSize(utils.java) returns 50 KB. Total size of src = 100 + 50 = 150 KB.

Step 3: calculateSize(docs) is called. calculateSize(readme.txt) returns 10 KB. calculateSize(guides) is called. calculateSize(setup.pdf) returns 200 KB. Total size of guides = 200 KB. Total size of docs = 10 + 200 = 210 KB.

Step 4: calculateSize(config.xml) returns 20 KB.

Step 5: The project directory adds the returned values: Total size = 150 + 210 + 20 = 380 KB.

Final Call Stack Summary:

calculateSize(project) | |-- calculateSize(src) | |-- calculateSize(main.java) returns 100 KB | |-- calculateSize(utils.java) returns 50 KB | Returns 150 KB | |-- calculateSize(docs) | |-- calculateSize(readme.txt) returns 10 KB | |-- calculateSize(guides) | |-- calculateSize(setup.pdf) returns 200 KB | Returns 200 KB | Returns 210 KB | |-- calculateSize(config.xml) returns 20 KB | Returns 380 KB

Final Output: Total Directory Size: 380.0 KB

(c) TIME COMPLEXITY

Let F represent the number of files and D represent the number of directories.

Time Complexity: O(F + D)

Each file and directory is visited once. Therefore, the total execution time is proportional to the number of files and directories, assuming directory listing and file-size retrieval take constant time per entry.

Space Complexity: O(H)

H represents the maximum depth of the directory structure. The recursive function uses the call stack, so memory usage depends on the maximum nesting depth.

(d) ITERATIVE APPROACH

Yes, the problem can also be solved iteratively using a stack data structure.

In the iterative approach, a stack stores directories and files that still need to be processed. A loop removes one item at a time. If the item is a file, its size is added to the total. If it is a directory, its contents are added to the stack.

Comparison:

Recursive Approach:

Uses the function call stack.
Code is shorter and easier to understand.
Can cause stack overflow for extremely deep directory structures.

Iterative Approach:

Uses an explicit stack, such as ArrayDeque in Java.
Requires a loop and manual stack management.
Avoids recursion-related stack overflow.

Both approaches have O(F + D) time complexity.

(e) SYMBOLIC LINK CYCLE

A symbolic link can point to a directory that has already been visited. For example, directory A may contain directory B, and B may contain a symbolic link pointing back to A.

Without protection, the recursive function may continue visiting A, B, A, B indefinitely, causing infinite recursion or a stack overflow.

To prevent this problem:

Do not follow symbolic links when calculating directory sizes.
Alternatively, maintain a set of visited directories or filesystem object identifiers.
Before processing a directory, check whether it has already been visited. If it has, skip it.

Example check:

if (visited.contains(canonicalPath)) { return 0; }

visited.add(canonicalPath);

Here, canonicalPath represents a normalized or canonical path identifying the directory. A set of visited paths or filesystem object identifiers helps prevent cycles.

CONCLUSION

Recursion is suitable for calculating directory sizes because directories can contain nested subdirectories. The base case handles individual files, while the recursive case processes directories and adds the sizes returned by their contents.

For the given directory structure, the total size is 380 KB. The time complexity is O(F + D). An iterative solution using a stack is also possible, and symbolic-link cycle protection prevents infinite recursion.