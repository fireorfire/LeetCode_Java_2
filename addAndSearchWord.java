public class WordDictionary {

    Trie trie = new Trie();

    // Adds a word into the data structure.
    public void addWord(String word) {
        trie.insert(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return trie.search(word);
    }
}
class TrieNode {
    // Initialize your data structure here.
    public Map<Character, TrieNode> map = new HashMap<>();
    public boolean flag;
    public TrieNode() {
        flag = false;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        char[] ch = word.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < ch.length; i ++) {
            if (node.map.containsKey(ch[i])) {
                node = node.map.get(ch[i]);
            } else {
                TrieNode newNode = new TrieNode();
                node.map.put(ch[i], newNode);
                node = newNode;
            }
        }
        node.flag = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;
        char[] ch = word.toCharArray();
        return track(node, ch, 0);
    }

    private boolean track(TrieNode node, char[] ch, int index) {
        for (int i = index; i < ch.length; i ++) {
            if (ch[i] == '.') {
                for (TrieNode trieNode : node.map.values()) {
                    if (track(trieNode, ch, i + 1)) {
                        return true;
                    }
                }
                return false;
            }
            if (!node.map.containsKey(ch[i])) {
                return false;
            }
            node = node.map.get(ch[i]);
        }
        return node.flag;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");