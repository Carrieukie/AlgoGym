package strings;

public class LeetCode208 {
//    public static void main(String[] args) {
//        Trie trie = new Trie();
//
//        // Inserting words
//        trie.insert("apple");
//        trie.insert("app");
//        trie.insert("application");
//
//        // Assertions for "apple" and "app"
//        assert trie.search("apple") : "Error: 'apple' should be found.";
//        assert trie.startsWith("applic") : "Error: 'applic' should be a valid prefix.";
//        assert !trie.search("applicat") : "Error: 'applicat' should not be found.";
//        assert trie.search("app") : "Error: 'app' should be found.";
//        assert trie.search("apple") : "Error: 'apple' should be found again.";
//        assert trie.startsWith("ap") : "Error: 'ap' should be a valid prefix.";
//        assert !trie.startsWith("apkk") : "Error: 'apkk' should not be a valid prefix.";
//        assert trie.search("apple") : "Error: 'apple' should be found.";
//        assert trie.search("app") : "Error: 'app' should be found.";
//        assert trie.startsWith("app") : "Error: 'app' should be a valid prefix.";
//
//        // Reset trie and insert new words
//        trie = new Trie();
//        trie.insert("bat");
//        trie.insert("batch");
//        trie.insert("batman");
//
//        // Assertions for "bat", "batch", "batman"
//        assert trie.search("bat") : "Error: 'bat' should be found.";
//        assert trie.startsWith("bat") : "Error: 'bat' should be a valid prefix.";
//        assert trie.search("batch") : "Error: 'batch' should be found.";
//        assert trie.search("batman") : "Error: 'batman' should be found.";
//        assert !trie.search("batwoman") : "Error: 'batwoman' should not be found.";
//
//        // Reset trie and test with no insertions
//        trie = new Trie();
//
//        // Assertions for empty trie
//        assert !trie.search("apple") : "Error: 'apple' should not be found in an empty trie.";
//        assert !trie.startsWith("appl") : "Error: 'appl' should not be a valid prefix in an empty trie.";
//
//        System.out.println("All test cases passed!");
//    }
}

class Trie {

    Node root;

    public Trie() {
        root = new Node('/');
    }

    public void insert(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (current.chars[currentChar - 'a'] == null) {
                current.chars[currentChar - 'a'] = new Node(currentChar);
            }
            current = current.chars[currentChar - 'a'];
        }
        current.setWord(true);
    }

    public boolean search(String word) {
        Node node = getNode(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }

    private Node getNode(String word){
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (current.chars[currentChar - 'a'] == null || current.chars[currentChar - 'a'].c !=  currentChar){
                return null;
            }
            current = current.chars[currentChar - 'a'];
        }
        return current;
    }

    private class Node {
        char c;
        Node[] chars;
        boolean isWord;

        Node(char c) {
            this.c = c;
            chars = new Node[26];
        }

        public void setWord(boolean word) {
            isWord = word;
        }

        public boolean isWord() {
            return isWord;
        }
    }
}
