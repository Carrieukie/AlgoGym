package strings;

import java.util.HashMap;

public class LeetCode211 {
    public static void main(String[] args) {

    }
}

class WordDictionary {
    Node root = new Node();

    // Constructor
    public WordDictionary() {

    }

    // Add a word to the Trie
    public void addWord(String word) {
        Node current = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new Node();
            }
            current = current.children[index];
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        return searchHelper(word, 0, root);  // Use helper function for recursion
    }

    private boolean searchHelper(String word, int index, Node current) {
        if (index == word.length()) {
            return current.isWord;
        }

        char c = word.charAt(index);

        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (current.children[i] != null && searchHelper(word, index + 1, current.children[i])) {
                    return true;
                }
            }
            return false;
        } else {
            int childIndex = c - 'a';
            if (current.children[childIndex] == null) {
                return false;
            }
            return searchHelper(word, index + 1, current.children[childIndex]);
        }
    }

    private class Node {
        Node[] children;
        boolean isWord;

        // Node constructor
        Node() {
            children = new Node[26];
        }
    }
}

