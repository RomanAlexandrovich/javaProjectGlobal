package by.global.auth.controller;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import by.global.model.Task;
import by.global.model.UserMY;
import by.global.service.TaskService;
import by.global.service.UserService;

@Controller
public class AdminController {
	@Autowired
	private UserService serviceUser;
	@Autowired
	private TaskService serviceTask;

	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");
		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");
		return "login";
	}

	@GetMapping("/admin")
	public String administation() {
		return "admin";
	}

	@GetMapping({ "/", "/home" })
	public String welcome(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserMY userMY = serviceUser.findByUsername(auth.getName());
		List<Task> listTask = serviceTask.fillAllTask();
		List<Task> listTaskUserAll = new ArrayList<Task>();
		List<Task> listTaskUserToDo = new ArrayList<Task>();
		List<Task> listTaskUserClose = new ArrayList<Task>();
		List<Task> listTaskUserInProcess = new ArrayList<Task>();
		List<Task> listTaskUserDone = new ArrayList<Task>();
		for (Task task : listTask) {
			if (task.getTaskUser().equals(userMY)) {
				listTaskUserAll.add(task);
				switch (task.getTaskStatus().getNameStatusTask()) {
				case "ToDo":
					listTaskUserToDo.add(task);
					break;
				case "In Process":
					listTaskUserInProcess.add(task);
					break;
				case "Done":
					listTaskUserDone.add(task);
					break;
				case "Close":
					listTaskUserClose.add(task);
					break;	}
				}
		}
		model.addAttribute("totalTasks", listTaskUserAll.size());
		model.addAttribute("user", userMY);
		model.addAttribute("listProject", userMY.getListProject());
		model.addAttribute("listTaskUser", listTaskUserAll);
		model.addAttribute("listTaskToDo", listTaskUserToDo.size());
		model.addAttribute("listTaskInProcess", listTaskUserInProcess.size());
		model.addAttribute("listTaskDone", listTaskUserDone.size());
		model.addAttribute("listTaskClose", listTaskUserClose.size());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		ZonedDateTime zdt=ZonedDateTime.now();
		model.addAttribute("localTime", zdt.format(dtf));
		return "home";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
		}
		return "redirect:/login";
	}

}
