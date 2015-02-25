package com.springapp.service.support;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springapp.dao.ActivationDao;
import com.springapp.dao.UserDao;
import com.springapp.domain.exception.ActivationNotFoundException;
import com.springapp.domain.exception.AuthenticationException;
import com.springapp.domain.exception.UserExistException;
import com.springapp.domain.exception.UserNotFoundException;
import com.springapp.domain.model.Tweet;
import com.springapp.domain.model.User;
import com.springapp.service.UserService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class UserServiceDao implements UserService {

    private UserDao userDao;
    private ActivationDao activationDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setActivationDao(ActivationDao activationDao) {
        this.activationDao = activationDao;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED,
            isolation = Isolation.SERIALIZABLE,
            rollbackFor = {RuntimeException.class, UserExistException.class})
    public void registerAccount(User u) throws UserExistException {

        // Set User UUID
        u.setId(UUID.randomUUID().toString());

        // Create User entry
        try {
            userDao.create(u);
        }
        catch(DuplicateKeyException e) {
            throw new UserExistException("User exists " + u.getMail());
        }
//
//        // Create Activation entry
//        Activation a = new Activation();
//        a.setActivationKey(UUID.randomUUID().toString());
//        a.setUserId(u.getId());

        // Send mail
        // TODO

    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED,
            isolation = Isolation.SERIALIZABLE)
    public User activateAccount(String activationKey) throws ActivationNotFoundException {

        // Get Activation entry
        try {
            return userDao.getUser(activationDao.getActivation(activationKey));

			/*User u = userDao.getUser(activationDao.getActivation(activationKey));

			u.setValid(true);
			userDao.updateUser(u);

			activationDao.deleteActivation(activationKey);

			return u;*/
        }
        catch(IncorrectResultSizeDataAccessException e) {
            throw new ActivationNotFoundException("Activation not found " + activationKey);
        }
    }

    public User authenticate(String mail, String password) throws AuthenticationException {

        // Cipher Password
        // TODO

        // Get User entry
        try {
            User u = userDao.getUserByMail(mail);
            if(!userDao.getUser(u.getId().toString()).getPassword().equals(password)) {
                throw new AuthenticationException("Authentication failed " + mail);
            }
            return u;
        }
        catch(IncorrectResultSizeDataAccessException e) {
            e.printStackTrace();
            throw new AuthenticationException("Authentication failed " + mail);
        }

    }

    public User getUserById(String userId) throws UserNotFoundException {
        try {
            return userDao.getUser(userId);
        }
        catch(IncorrectResultSizeDataAccessException e) {
            throw new UserNotFoundException("User not found " + userId);
        }
    }

    public User getUserByMail(String mail) throws UserNotFoundException {
        try {
            return userDao.getUserByMail(mail);
        }
        catch(IncorrectResultSizeDataAccessException e) {
            throw new UserNotFoundException("User not found " + mail);
        }
    }

    public User getUserByName(String name) throws UserNotFoundException {
        try {
            return userDao.getUserByName(name);
        }
        catch(IncorrectResultSizeDataAccessException e) {
            throw new UserNotFoundException("User not found " + name);
        }
    }
    

	
	public void unfollow(String followed, String follower){
		userDao.unfollow(followed, follower);
	}
	
	public void follow(String followed, String follower){
		userDao.follow(followed, follower);
	}

    public void unregisterAccount(User u) {
        // TODO
    }

    @Override
    public User findOne(Object id) {
        return this.userDao.findOne(id);
    }

    @Override
    public void create(User user){
        this.userDao.create(user);
    }

    @Override
    public List findAll() {
        return this.userDao.findAll();
    }

	@Override
	public boolean isFollowing(String followed, String follower) {
		return userDao.isFollowing(followed, follower);
	}
	
	@Override
	public List<User> getFollowers(String followed){
		return userDao.getFollowers(followed);
	}
}
