package com.autocomplete.controller;


import java.util.List;

import com.autocomplete.bean.TrieNode;
import com.autocomplete.bean.User;
import com.autocomplete.data.Trie;

public class UserController {

	private Trie<User> trie;

	public UserController() {
		this.trie = new Trie<>();
	}
	
	public void addUserToTrie(User user) {
		trie.addUserToTrie(user.getName(), user);
	}
	
	public List<TrieNode<User>> autoComplete(String prefix) {
		return trie.findComplete(prefix);
	}
}
