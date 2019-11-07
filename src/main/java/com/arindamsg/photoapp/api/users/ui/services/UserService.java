package com.arindamsg.photoapp.api.users.ui.services;

import com.arindamsg.photoapp.api.users.ui.models.UserRequestModel;
import com.arindamsg.photoapp.api.users.ui.models.UserResponseModel;

public interface UserService {
	public UserResponseModel createUser(UserRequestModel user);

}
