package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	public User findByName(String name);
	public User findByNameAndPassword(String name, String password);
	public List<User> findByAddress(String name);
}
