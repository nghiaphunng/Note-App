package noteapp.service;

import noteapp.dto.LoginDTO;
import noteapp.dto.UserDTO;

public interface UserService {
	boolean checkRegisterUserName(UserDTO userDTO);
	boolean checkRegisterUserEmail(UserDTO userDTO);
	void registerAccUser(UserDTO userDTO);
	UserDTO checkLogin(LoginDTO loginDTO);
}
