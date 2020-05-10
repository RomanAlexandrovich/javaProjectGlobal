package by.global.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import by.global.model.Task;
import by.global.service.ProjectService;
import by.global.service.StatusTaskService;
import by.global.service.TaskService;
import by.global.service.UrgencyService;
import by.global.service.UserService;

@Controller
public class TaskController {
	@Autowired
	private TaskService serviceTask;
	@Autowired
	private ProjectService serviceProject;
	@Autowired
	private UrgencyService serviceUrgency;
	@Autowired
	private UserService serviceUser;
	@Autowired
	private StatusTaskService serviceStatusTask;
	
	@GetMapping("/task")
	public String createTask(Model model) {
		Task newTask=new Task();
		model.addAttribute("formTask", newTask);
		model.addAttribute("listProject", serviceProject.fillAllProject());
		model.addAttribute("listUrgency", serviceUrgency.findAllUrgency());
		model.addAttribute("listUser", serviceUser.findAllUser());
		model.addAttribute("listStatusTask",serviceStatusTask.findAllStatusTask());
		return "create_task";
	}
	@PostMapping("/task")
	public String registration(@ModelAttribute("formTask") Task newTask, BindingResult bindingResult) {
		serviceTask.saveTask(newTask);
		return "redirect:/home";
	}
	@GetMapping(value = { "/task-{idTask}" })
	public String success(@PathVariable Integer idTask, Model model) {
		Task editTask = serviceTask.findbyIdTasks(idTask);
//		model.addAttribute("Task", editTask);
		model.addAttribute("task", editTask);
		return "task";
	}
	@PostMapping(value = { "/task-{idTask}" })
	public String successTask(@PathVariable Integer idTask, Model model) {
		Task getIdTask = serviceTask.findbyIdTasks(idTask);
		model.addAttribute("task", getIdTask);
		return "task";
	}

	

}
