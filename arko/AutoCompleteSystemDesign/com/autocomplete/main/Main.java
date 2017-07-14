package com.autocomplete.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.autocomplete.bean.Address;
import com.autocomplete.bean.TrieNode;
import com.autocomplete.bean.User;
import com.autocomplete.controller.AddressController;
import com.autocomplete.controller.AutoCompleteController;
import com.autocomplete.controller.UserController;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no. of User to load");
		int n = sc.nextInt();
		AutoCompleteController autoCompleteController = new AutoCompleteController();
		for (int i = 0; i < n; i++) {
			System.out.println("Enter name : ");
			String name = sc.next();
			System.out.println("Enter email : ");
			String email = sc.next();
			System.out.println("Enter Address : ");
			System.out.println("Enter City : ");
			String city = sc.next();
			System.out.println("Enter locality : ");
			String locality = sc.next();
			System.out.println("Enter pin : ");
			Integer pin = sc.nextInt();
			User user = new User(name, email, new Address(city, locality, pin));
			autoCompleteController.addUser(user);
		}
		while (true) {
			String prefix = "";
			Integer index = 0;
			List<TrieNode<User>> result = new ArrayList<>();
			System.out.println(
					"Keep enterting characters (single char at a time) or enter 'select-<index of suggested string from 0>' for retriving");
			while (!prefix.contains("select")) {
				String temp = sc.next();
				if (temp.contains("select")) {
					String t[] = temp.split("-");
					index = Integer.parseInt(t[1]);
					break;
				}
				prefix = prefix + temp;
				result = autoCompleteController.autoComplete(prefix);
				for (int i = 0; i < result.size(); i++) {
					System.out.print(result.get(i).getWordFormedTillThis() + " ");
				}
			}
			for (int i = 0; i < result.get(index).getAssociatedDatas().size(); i++) {
				System.out.println(result.get(index).getAssociatedDatas().get(i));
			}

		}

	}

}
