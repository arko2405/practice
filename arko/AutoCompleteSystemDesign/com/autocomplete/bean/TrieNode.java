package com.autocomplete.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieNode<E> {

	private Character character;
	private Map<Character, TrieNode<E>> childNodes;
	private List<E> associatedDatas;
	private Boolean isLeaf;
	private String wordFormedTillThis;

	public TrieNode(Character character) {
		this.character = character;
		this.childNodes = new HashMap<>();
		this.associatedDatas = new ArrayList<>();
		this.isLeaf = false;
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public Map<Character, TrieNode<E>> getChildNodes() {
		return childNodes;
	}

	public void setChildNodes(Map<Character, TrieNode<E>> childNodes) {
		this.childNodes = childNodes;
	}

	public void addChild(char c) {
		if (childNodes.get(new Character(c)) == null) {
			childNodes.put(c, new TrieNode<E>(c));
		}
	}

	public TrieNode<E> getChildNode(char c) {
		return childNodes.get(new Character(c));
	}

	public boolean contains(char c) {
		return (childNodes.get(new Character(c)) != null);
	}

	public List<E> getAssociatedDatas() {
		return associatedDatas;
	}

	public void addAssociatedData(E associatedData) {
		this.associatedDatas.add(associatedData);
	}

	public Boolean isLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public String getWordFormedTillThis() {
		return wordFormedTillThis;
	}

	public void setWordFormedTillThis(String wordFormedTillThis) {
		this.wordFormedTillThis = wordFormedTillThis;
	}

}
