package com.springapp.service;

import java.util.List;

import com.springapp.domain.exception.ActivationNotFoundException;
import com.springapp.domain.exception.AuthenticationException;
import com.springapp.domain.exception.UserExistException;
import com.springapp.domain.exception.UserNotFoundException;
import com.springapp.domain.model.Tweet;
import com.springapp.domain.model.User;

public interface UserService extends Service<User>{

    public void registerAccount(User u) throws UserExistException;

    public User activateAccount(String activationKey) throws ActivationNotFoundException;

    public User authenticate(String mail, String password) throws AuthenticationException;

    public User getUserById(String userId) throws UserNotFoundException;

    public User getUserByMail(String mail) throws UserNotFoundException;

    public void unregisterAccount(User u);

	public User getUserByName(String name) throws UserNotFoundException;

	
	public void unfollow(String followed, String follower);

	public void follow(String followed, String follower);
	public boolean isFollowing(String followed, String follower);
	
	public List<User> getFollowers(String followed);

//    public void addUser(User user) throws UserExistException;

}