package com.stackroute.webapp.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.stackroute.webapp.model.User;

public class UserRepository {
	
	public List<User> userList;
	
	public UserRepository() {
		this.userList = new ArrayList<>();
	}

	public List<User> getUsersList() {
		return this.userList;
	}
	
	public void addUser(User user) {
		userList.add(user);
	}
	
	public void removeUser(String name) {
		Iterator<User> iterator = userList.iterator();
		while(iterator.hasNext()){
			User mem = (User) iterator.next();
			if(mem.getUsername().equals(name)) {
				iterator.remove();
			}
		}
	} 
}
