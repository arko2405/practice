package practice.trieProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Contacts {



	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	       String line = br.readLine();
	       	Trie trie = new Trie();
			int p = Integer.parseInt(line);
			while(p-->0){
				String s[] = br.readLine().split(" ");
				if(s[0].equalsIgnoreCase("add")){
					trie.loadTrie(s[1]);
				}
				else if(s[0].equalsIgnoreCase("find")){
					TrieNode node = trie.getKeyByMatchedPrefix(s[1], trie.root);
					int ans = node==null?0:node.getNoOfThroughThis();
					System.out.println(ans);
				}
			}
		

	}
	
	public static class TrieNode {

		public Character character;
		public TrieNode[] childNodes;
		public Integer noOfThroughThis;

		public TrieNode(Character character) {
			this.character = character;
			this.childNodes = new TrieNode[26];
			this.noOfThroughThis = 1;
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
			else
				childNodes[c-97].setNoOfThroughThis(childNodes[c-97].getNoOfThroughThis()+1);;
		}
		public TrieNode getChildNode(char c) {
			return childNodes[c-97];
		}

		public Integer getNoOfThroughThis() {
			return noOfThroughThis;
		}

		public void setNoOfThroughThis(Integer noOfThroughThis) {
			this.noOfThroughThis = noOfThroughThis;
		}
		
	}
	
     public static class Trie {

		public TrieNode root;

		public Trie() {
			this.root = new TrieNode(' ');
		}

		public void loadTrie(String key) {
			loadTrie(key,root);
		}

		private void loadTrie(String key,TrieNode node) {
			if (key.length()<=0) {
				return;
			}
			char firstChar = key.charAt(0);
			node.addChild(firstChar);
			TrieNode childNode = node.getChildNode(firstChar);
			if (key.length() > 1) {
				loadTrie(key.substring(1), childNode);
			} 
		}


		public TrieNode getKeyByMatchedPrefix(String prefix, TrieNode node) {
			if (prefix.length()<=0) {
				return node;
			}
			char firstChar = prefix.charAt(0);
			TrieNode childNode = node.getChildNode(firstChar);
			if (childNode == null) {
				return null;
			} else if (prefix.length() == 1) {
				return childNode;
			} else {
				return getKeyByMatchedPrefix(prefix.substring(1), childNode);
			}
		}
		

	}
 }
/*

We're going to make our own Contacts application! The application must perform two types of operations:

add name, where  is a string denoting a contact name. This must store  as a new contact in the application.
find partial, where  is a string denoting a partial name to search the application for. It must count the number of contacts starting with  and print the count on a new line.
Given  sequential add and find operations, perform each operation in order.

Input Format

The first line contains a single integer, , denoting the number of operations to perform. 
Each line  of the  subsequent lines contains an operation in one of the two forms defined above.

Constraints




It is guaranteed that  and  contain lowercase English letters only.
Output Format

For each find partial operation, print the number of contact names starting with  on a new line.

Sample Input

4
add hack
add hackerrank
find hac
find hak
Sample Output

2
0

*/