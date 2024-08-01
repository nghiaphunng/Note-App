package noteapp.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import noteapp.dto.LoginDTO;
import noteapp.dto.UserDTO;
import noteapp.entity.User;
import noteapp.repository.UserRepository;
import noteapp.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private ModelMapper modelMapper;
	
	@Override
	public boolean checkRegisterUserEmail(UserDTO userDTO) {
		if(userRepository.existsByUserEmail(userDTO.getUserEmail())) return true;
		return false;
	}

	@Override
	public boolean checkRegisterUserName(UserDTO userDTO) {
		if(userRepository.existsByUserName(userDTO.getUserName())) return true;
		return false;
	}

	@Override
	public void registerAccUser(UserDTO userDTO) {
		User user = modelMapper.map(userDTO, User.class);
		userRepository.save(user);
	}

	@Override
	public UserDTO checkLogin(LoginDTO loginDTO) {
		User user = userRepository.findByUserNameAndUserPassword(loginDTO.getUserName(), loginDTO.getUserPassword());
		if(user != null) {
			 return modelMapper.map(user, UserDTO.class);
		}
		return null;
	}

}
