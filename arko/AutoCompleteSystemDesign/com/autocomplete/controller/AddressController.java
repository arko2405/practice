package com.autocomplete.controller;

import java.util.List;

import com.autocomplete.bean.TrieNode;
import com.autocomplete.bean.User;
import com.autocomplete.data.Trie;

public class AddressController {
	private Trie<User> trie;

	public AddressController() {
		this.trie = new Trie<>();
	}

	public void addAddressToTrie(User user) {
		trie.addUserToTrie(user.getAddress().getCity(), user);
	}

	public List<TrieNode<User>> autoComplete(String prefix) {
		return trie.findComplete(prefix);

	}
}
