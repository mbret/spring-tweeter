package com.springapp.dao;

import java.util.List;

import com.springapp.domain.model.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

@CacheConfig(cacheNames={"users"})
public interface UserDao extends Dao<User>{

	public List<User> getUsers();

	@Cacheable
	public User getUser(String id);
	
	public User getUserByMail(String mail);

	@CacheEvict(key = "#user.id")
	public void updateUser(User user);

	@CacheEvict
	public void deleteUser(String id);
}
