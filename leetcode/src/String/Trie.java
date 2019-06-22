package String;

public class Trie {
	public static void main(String args[]) {
		String s0 = "abc";
		String s1 = "jak";
		String s2 = "htttp";
		insert(s0.toCharArray());
		insert(s1.toCharArray());
		insert(s2.toCharArray());
		System.out.println(search("jak".toCharArray()));
		System.out.println(search("ht".toCharArray()));
	}
	
	static class TrieNode {
		public char data;
		public TrieNode[] children = new TrieNode[26];
		public boolean isEndingChar = false;
		TrieNode(char data) {
			this.data =data;
		}
	}
	private static TrieNode root = new TrieNode('\\');
	
	public static void insert(char[] text) {
		TrieNode p = root;
		for(int i =0;i<text.length;i++) {
			int index = text[i]-'a';
			if(p.children[index]==null) {
				TrieNode newNode = new TrieNode(text[i]);
				p.children[index] = newNode;
			}
			p = p.children[index];
		}
		p.isEndingChar = true;
	}
	
	public static boolean search(char[] pattern) {
		TrieNode p = root;
		for(int i=0;i<pattern.length;i++) {
			int index = pattern[i]-'a';
			if(p.children[index]==null) {
				return false;
			}
			p=p.children[index];
		}
		if(p.isEndingChar==false) {
			return false;
		}
		return true;
	}
}
