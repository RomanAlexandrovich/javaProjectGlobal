package by.global.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import by.global.auth.validator.UserValidator;
import by.global.model.ImageUser;
import by.global.model.UserMY;
import by.global.service.ImageUserService;
import by.global.service.PosUserService;
import by.global.service.ProjectService;
import by.global.service.SecurityService;
import by.global.service.StatusUserService;
import by.global.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private StatusUserService statusUserService;
	@Autowired
	private ImageUserService imageUserService;
	@Autowired
	private PosUserService posUserService;	
	@Autowired
	private ProjectService serviceProject;
	
	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;

	@GetMapping("/add_user")
	public String registration(Model model, boolean level) {
		UserMY userForm = new UserMY();
		model.addAttribute("addUser", userForm);
		model.addAttribute("listStatus", statusUserService.AllStatusUser());
		model.addAttribute("listImageUser", imageUserService.AllImageUser());
		model.addAttribute("listPositionUser", posUserService.AllPositionUser());
		model.addAttribute("listProjectAll", serviceProject.fillAllProject());
		return "create_user";
	}

	@PostMapping("/add_user")
	public String registration(@ModelAttribute("addUser") UserMY userForm,@RequestParam("levelRole") boolean level, BindingResult bindingResult) {
		userValidator.validate(userForm, bindingResult);
		userService.save(userForm,level);
//		securityService.autoLogin(userForm.getNameUser(), userForm.getPasswordConfirm());
		return "redirect:/home";
	}


	

	

	
}
