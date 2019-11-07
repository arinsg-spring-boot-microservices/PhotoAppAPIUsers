package com.arindamsg.photoapp.api.users.ui.services;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.arindamsg.photoapp.api.users.data.UserEntity;
import com.arindamsg.photoapp.api.users.data.UsersRepository;
import com.arindamsg.photoapp.api.users.ui.models.UserModel;
import com.arindamsg.photoapp.api.users.ui.models.UserRequestModel;
import com.arindamsg.photoapp.api.users.ui.models.UserResponseModel;


@Service
public class UserServiceImpl implements UserService{
		
	UsersRepository usersRepository;
	//BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public UserServiceImpl(UsersRepository usersRepository /*,BCryptPasswordEncoder bCryptPasswordEncoder*/) {
		this.usersRepository=usersRepository;
		//this.bCryptPasswordEncoder=bCryptPasswordEncoder;
	}

	public UserResponseModel createUser(UserRequestModel user) {
		UserModel userModel= new UserModel();
		userModel.setFirstName(user.getFirstName());
		userModel.setLastName(user.getLastName());
		userModel.setEmail(user.getEmail());
		//userModel.setPassword(user.getPassword());
		userModel.setUserId(UUID.randomUUID().toString());
		String enCryptedPassword="test";//bCryptPasswordEncoder.encode(user.getPassword());
			
		ModelMapper modelMapper =new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity entity= modelMapper.map(userModel, UserEntity.class);
		entity.setEncryptedPassword(enCryptedPassword);
		
		usersRepository.save(entity);
		
		UserResponseModel userResponseModel=modelMapper.map(entity, UserResponseModel.class);
		
		return userResponseModel;

	}

	
}
