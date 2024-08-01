package noteapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import noteapp.dto.UserDTO;
import noteapp.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class RegisterController {
	@Autowired 
	private UserService userService;
	
	@GetMapping(value = {"/register"})
	public ModelAndView register(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		
		HttpSession session = request.getSession();
		UserDTO user = (UserDTO) session.getAttribute("user");
		if(user != null) {
			modelAndView.setViewName("redirect:/home");
		}
		else {
			modelAndView.setViewName("register");
			UserDTO userDTO = new UserDTO();
			modelAndView.addObject("user", userDTO);
		}		
		return modelAndView;
	}
	
	@PostMapping(value = {"/register"})
	public ModelAndView RegisterHandle(@ModelAttribute("user") UserDTO userDTO) {
		ModelAndView modelAndView = new ModelAndView();
		if(userService.checkRegisterUserEmail(userDTO)) {
			modelAndView.addObject("msgRegister", "Email đã được sử dụng");
		}
		else if(userService.checkRegisterUserName(userDTO)) {
			modelAndView.addObject("msgRegister", "Tên tài khoản đã được sử dụng");
		}
		else {
			modelAndView.addObject("msgRegister", "Đăng ký tài khoản thành công");
			userService.registerAccUser(userDTO);
		}
		modelAndView.setViewName("register");		
		return modelAndView;
	}
}
