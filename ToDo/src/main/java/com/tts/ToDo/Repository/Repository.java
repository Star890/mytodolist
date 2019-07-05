package com.tts.ToDo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.tts.ToDo.Model.User;

public interface Repository extends CrudRepository<User, Long>{
	
}