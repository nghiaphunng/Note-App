package noteapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import noteapp.dto.LoginDTO;
import noteapp.dto.UserDTO;
import noteapp.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@GetMapping(value = {"/login"})
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		
		//kiem tra phien dang nhap da ton tai?
		HttpSession session = request.getSession(false);
		if(session != null) {
			UserDTO user = (UserDTO) session.getAttribute("user");
			if(user != null) modelAndView.setViewName("redirect:/home");
		}
		else {
			modelAndView.setViewName("login");
			modelAndView.addObject("user", new LoginDTO());
		}
		
		return modelAndView;
	}
	
	@PostMapping(value = {"/login"})
	public ModelAndView LoginHandle(@ModelAttribute("user") LoginDTO loginDTO, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		UserDTO userDTO = userService.checkLogin(loginDTO);
		if(userDTO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", userDTO);
			modelAndView.setViewName("redirect:/home");
		}
		else {
			modelAndView.setViewName("/login");
			modelAndView.addObject("msgLogin", "Tài khoản không tồn tại");
		}		
		return modelAndView;
	}
}
