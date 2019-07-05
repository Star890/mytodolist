package com.tts.ToDo.Service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.ToDo.Model.User;
import com.tts.ToDo.Repository.Repository;

@Service

public class UserService {
	@Autowired
	private Repository repository;
	private UserService userService;


// public void save(User user) {
//    repository.save(user);
//    
//} 
// public List <User>findAll(){
//     return (List<User>) repository.findAll();
//  }
 
}
//   
