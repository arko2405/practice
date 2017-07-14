package com.autocomplete.controller;

import java.util.ArrayList;
import java.util.List;

import com.autocomplete.bean.TrieNode;
import com.autocomplete.bean.User;

public class AutoCompleteController {

	private UserController userController;
	private AddressController addressController;

	public AutoCompleteController() {
		this.userController = new UserController();
		this.addressController = new AddressController();
	}

	public void addUser(User user) {
		userController.addUserToTrie(user);
		addressController.addAddressToTrie(user);
	}

	public List<TrieNode<User>> autoComplete(String prefix) {
		List<TrieNode<User>> result = new ArrayList<>();
		result.addAll(userController.autoComplete(prefix));
		result.addAll(addressController.autoComplete(prefix));
		return result;
	}

}
