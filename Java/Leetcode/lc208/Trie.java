package lc208;


class Trie {

  private class TrieNode {
    private TrieNode[] children;
    private boolean isEndOfWord;

    public TrieNode() {
      children = new TrieNode[26];
      isEndOfWord = false;
    }
  }

  private final TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode node = root;
    for (char ch: word.toCharArray()) {
      int index = ch - 'a';
      if (node.children[index] == null) {
        node.children[index] = new TrieNode();
      }

      node = node.children[index];
    }

    node.isEndOfWord = true;
  }

  public boolean search(String word) {
    TrieNode node = root;
    for (char ch: word.toCharArray()) {
      int index = ch - 'a';
      if (node.children[index] == null) {
        return false;
      }
      node = node.children[index];
    }
    return node.isEndOfWord;
  }

  public boolean startsWith(String prefix){
    TrieNode node = root;
    for (char ch : prefix.toCharArray()) {
      int index = ch - 'a';
      if (node.children[index] == null) {
        return false;
      }
      node = node.children[index];
    }
    return true;
  }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */