package com.gla.Recursion;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class DirectorySizeCalculator {

    // (a) Recursive approach
    public static long calculateSize(File file) {

        // Base case: if it is a file, return its size
        if (file.isFile()) {
            return file.length();
        }

        // Recursive case: calculate the size of a directory
        long totalSize = 0;

        File[] contents = file.listFiles();

        if (contents != null) {
            for (File item : contents) {
                totalSize += calculateSize(item);
            }
        }

        return totalSize;
    }

    // (d) Iterative approach using a stack
    public static long calculateSizeIterative(File root) {
        long totalSize = 0;
        Deque<File> stack = new ArrayDeque<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            File current = stack.pop();

            if (current.isFile()) {
                totalSize += current.length();
            } else {
                File[] contents = current.listFiles();

                if (contents != null) {
                    for (File item : contents) {
                        stack.push(item);
                    }
                }
            }
        }

        return totalSize;
    }

    // (e) Recursive approach with symbolic-link cycle protection
    public static long calculateSizeSafe(
            Path path, Set<Object> visited) throws IOException {

        // Do not follow symbolic links
        if (Files.isSymbolicLink(path)) {
            return 0;
        }

        // Identify the file or directory
        Object key = Files.readAttributes(
                path,
                java.nio.file.attribute.BasicFileAttributes.class
        ).fileKey();

        // Prevent revisiting the same filesystem object
        if (key != null && !visited.add(key)) {
            return 0;
        }

        if (Files.isRegularFile(path)) {
            return Files.size(path);
        }

        if (Files.isDirectory(path)) {
            long totalSize = 0;

            try (var stream = Files.list(path)) {
                for (Path child : (Iterable<Path>) stream::iterator) {
                    totalSize += calculateSizeSafe(child, visited);
                }
            }

            return totalSize;
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {

        // Replace with your actual directory path
        File directory = new File("project");

        System.out.println("Recursive size: "
                + calculateSize(directory) + " bytes");

        System.out.println("Iterative size: "
                + calculateSizeIterative(directory) + " bytes");

        Set<Object> visited = new HashSet<>();

        System.out.println("Safe size: "
                + calculateSizeSafe(directory.toPath(), visited)
                + " bytes");
    }
}
