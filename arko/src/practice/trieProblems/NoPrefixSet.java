package practice.trieProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class NoPrefixSet {

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	       String line = br.readLine();
	       	Trie trie = new Trie();
			int p = Integer.parseInt(line);
			Boolean ans = true;
			while(p-->0){
				String s = br.readLine();
				ans = trie.loadTrie(s);
				if(!ans){
					System.out.println("BAD SET");
					System.out.println(s);
					break;
				}
			}
			if (ans) {
				System.out.println("GOOD SET");
			}
	}
	
	public static class TrieNode {

		public Character character;
		public TrieNode[] childNodes;
		private Boolean isLeaf;
		
		public TrieNode(Character character) {
			this.character = character;
			this.childNodes = new TrieNode[26];
			this.isLeaf=false;
		}

		public Character getCharacter() {
			return character;
		}
		public TrieNode[] getChildNodes() {
			return childNodes;
		}

		public void addChild(char c) {
			if (childNodes[c-97] == null) {
				childNodes[c-97]=new TrieNode(c);
			}
		}
		public TrieNode getChildNode(char c) {
			return childNodes[c-97];
		}

		public Boolean isLeaf() {
			return isLeaf;
		}

		public void setIsLeaf(Boolean isLeaf) {
			this.isLeaf = isLeaf;
		}
	}
	
     public static class Trie {

		public TrieNode root;

		public Trie() {
			this.root = new TrieNode(' ');
		}

		public boolean loadTrie(String key) {
			return loadTrie(key,root);
		}

		private boolean loadTrie(String key,TrieNode node) {
			if (key.length()<=0) {
				return true;
			}
			char firstChar = key.charAt(0);
			if(node.getChildNode(firstChar)!=null && key.length()==1)
				return false;
			node.addChild(firstChar);
			TrieNode childNode = node.getChildNode(firstChar);
			if(childNode.isLeaf)
				return false;
			if (key.length() > 1) {
				return loadTrie(key.substring(1), childNode);
			} 
			else {
				childNode.setIsLeaf(true);
			}
			return true;
		}
	}
 }
/*
Given  strings. Each string contains only lowercase letters from (both inclusive). The set of  strings is said to be GOOD SET if no string is prefix of another string else, it is BAD SET. (If two strings are identical, they are considered prefixes of each other.)

For example, aab, abcde, aabcd is BAD SET because aab is prefix of aabcd.

Print GOOD SET if it satisfies the problem requirement. 
Else, print BAD SET and the first string for which the condition fails.

Input Format 
First line contains , the number of strings in the set. 
Then next  lines follow, where  line contains  string.

Constraints 
 
 Length of the string 

Output Format 
Output GOOD SET if the set is valid. 
Else, output BAD SET followed by the first string for which the condition fails.

Sample Input00

7
aab
defgab
abcde
aabcde
cedaaa
bbbbbbbbbb
jabjjjad
Sample Output00

BAD SET
aabcde
Sample Input01

4
aab
aac
aacghgh
aabghgh
Sample Output01

BAD SET
aacghgh

*/