package com.kodgemisi.filter;

import com.kodgemisi.usermanagement.User;
import com.kodgemisi.usermanagement.UserService;

import java.util.List;
import java.util.stream.Collectors;

public class FilterApiImpl implements FilterApi {

	private final UserService userService;

	public FilterApiImpl(UserService userService) {
		this.userService = userService;
	}

	@Override
	public List<User> unverifiedUnder18() {
		
		return userService.list().stream().filter(user -> !user.isVerified() && user.getAge() < 18)
				.toList();
	}

	@Override
	public List<User> verifiedWithTrPrimaryPhone() {
		
		return userService.list().stream().filter(user -> user.isVerified()
				&& user.getProfile().getPrimaryPhone().subSequence(0, 3).equals("+90"))
				.toList();
	}
}
