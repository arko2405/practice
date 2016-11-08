package com.autocomplete.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;

import com.autocomplete.bean.TrieNode;

public class Trie<E> {

	private TrieNode<E> root;

	public Trie() {
		this.root = new TrieNode<>(' ');
	}

	public void addUserToTrie(String key, E associatedDataObject) {
		addUserToTrie(key, associatedDataObject, root,"");
	}

	private void addUserToTrie(String key, E associatedDataObject, TrieNode<E> node,String word) {
		if (StringUtils.isBlank(key)) {
			return;
		}
		char firstChar = key.charAt(0);
		node.addChild(firstChar);
		TrieNode<E> childNode = node.getChildNode(firstChar);
		word = word + firstChar;
		childNode.setWordFormedTillThis(word);
		if (key.length() > 1) {
			addUserToTrie(key.substring(1), associatedDataObject, childNode,word);
		} else {
			childNode.setIsLeaf(true);
			childNode.addAssociatedData(associatedDataObject);
		}
	}


	private TrieNode<E> getKeyByMatchedPrefix(String prefix, TrieNode<E> node) {
		if (StringUtils.isBlank(prefix)) {
			return node;
		}
		char firstChar = prefix.charAt(0);
		TrieNode<E> childNode = node.getChildNode(firstChar);
		if (childNode == null) {
			return null;
		} else if (prefix.length() == 1) {
			return childNode;
		} else {
			return getKeyByMatchedPrefix(prefix.substring(1), childNode);
		}
	}
	
	public List<TrieNode<E>> findComplete(String prefix) {
	    TrieNode<E> matchedNode = getKeyByMatchedPrefix(prefix,root);
	    List<TrieNode<E>> completeLists = new ArrayList<>();
	    findCompleteRecursive(matchedNode,completeLists);
	    return completeLists;
	  }

	  private void findCompleteRecursive(TrieNode<E> node,List<TrieNode<E>> completions) {
	    if (node == null) {
	      return;
	    }
	    if (node.isLeaf()) {
	      completions.add(node);
	    }
	    Map<Character, TrieNode<E>> childNodes = node.getChildNodes();
	    for (Entry<Character, TrieNode<E>> entry : childNodes.entrySet()) {
	    	findCompleteRecursive(entry.getValue(),completions);
	    }
	  }

}
