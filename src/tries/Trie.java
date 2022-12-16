package tries;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    private class TrieNode {
        Map<Character, TrieNode> child;
        boolean endOfWord;

        TrieNode() {
            this.child = new HashMap<>();
            this.endOfWord = false;
        }
    }

    TrieNode root;

    /** createTrie **/
    public void createTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.child.get(ch);
            if (node == null) {
                node = new TrieNode();
                current.child.put(ch, node);
            }
            current = node;
        }
        current.endOfWord = true;
        System.out.println("Successfully inserted " + word + " in the Trie!");
    }

    /** Search for a prefix in Trie **/
    public boolean prefixSearch(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            TrieNode node = current.child.get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return true;
    }

    /** Search for a word in Trie **/
    public boolean search(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            TrieNode node = current.child.get(ch);
            if (node == null) { //CASE#1 -- if node does not exist for given char then return false
                return false;
            }
            current = node;
        }
        return current.endOfWord;
    }

    /** Delete word from Trie **/
    public void deleteWord(String word) {
        if (search(word)) {
            deleteWord(root, word, 0);
        }
    }

    /** Delete word **/
    private boolean deleteWord(TrieNode current, String word, int index) {
        if (index == word.length()) {
            //when end of word is reached only delete if current.endOfWord is true.
            if (!current.endOfWord) {
                return false;
            }
            current.endOfWord = false;
            //if current has no other mapping then return true
            return current.child.size() == 0;
        }
        char ch = word.charAt(index);
        TrieNode node = current.child.get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = deleteWord(node, word, index + 1);
        //if true is returned then delete the mapping of character and trienode reference from map.
        if (shouldDeleteCurrentNode) {
            current.child.remove(ch);
            //return true if no mappings are left in the map.
            return current.child.size() == 0;
        }
        return false;
    }

    /** main method **/
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.createTrie();

        System.out.println("Inserting word 'apple': ");
        trie.insert("apple");
        System.out.println("Inserting word 'app': ");
        trie.insert("app");

        System.out.println("Searching prefix 'ap': " + trie.prefixSearch("ap"));
        System.out.println("Searching word 'ap': " + trie.search("apple"));
        System.out.println("Deleting word 'app': ");
        trie.deleteWord("app");
        System.out.println("Searching prefix 'apple': " + trie.prefixSearch("apple"));
    }

}
