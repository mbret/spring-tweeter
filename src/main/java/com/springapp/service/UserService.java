package com.springapp.service;

import com.springapp.domain.exception.ActivationNotFoundException;
import com.springapp.domain.exception.AuthenticationException;
import com.springapp.domain.exception.UserExistException;
import com.springapp.domain.exception.UserNotFoundException;
import com.springapp.domain.model.Password;
import com.springapp.domain.model.User;

public interface UserService extends Service<User>{

    public void registerAccount(User u) throws UserExistException;

    public User activateAccount(String activationKey) throws ActivationNotFoundException;

    public void changePassword(Password password);

    public User authenticate(String mail, String password) throws AuthenticationException;

    public User getUserById(String userId) throws UserNotFoundException;

    public User getUserByMail(String mail) throws UserNotFoundException;

    public void unregisterAccount(User u);

//    public void addUser(User user) throws UserExistException;

}