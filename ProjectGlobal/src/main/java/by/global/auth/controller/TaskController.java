package by.global.auth.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import by.global.model.StatusTask;
import by.global.model.Task;
import by.global.model.UserMY;
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
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserMY userMY = serviceUser.findByUsername(auth.getName());
		model.addAttribute("user", userMY);
		Task editTask = serviceTask.findbyIdTasks(idTask);
		model.addAttribute("listStatusTask", serviceStatusTask.findAllStatusTask());
		model.addAttribute("task", editTask);
		return "task";
	}
	@PostMapping(value = { "/task-{idTask}" })
	public String successTask(@PathVariable Integer idTask,@ModelAttribute("statusTask") StatusTask status, Model model) {
		Task getIdTask = serviceTask.findbyIdTasks(idTask);
		model.addAttribute("task", getIdTask);
		getIdTask.setTaskStatus(status);
		serviceTask.saveTask(getIdTask);
		return "task";
	}
	
	@GetMapping(value = { "/task-{idTask}/{nameStatus}" })
	public String success2(@PathVariable Integer idTask,@PathVariable String nameStatus, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserMY userMY = serviceUser.findByUsername(auth.getName());
		model.addAttribute("user", userMY);
		Task editTask = serviceTask.findbyIdTasks(idTask);
		editTask.setTaskStatus(serviceStatusTask.findByNameStatusTask(nameStatus));
		model.addAttribute("listStatusTask", serviceStatusTask.findAllStatusTask());
		model.addAttribute("task", editTask);
		serviceTask.saveTask(editTask);
		return "task";	
}
	@GetMapping(value = { "/task_all" })
	public String taskAll(Model model) {
		int ToDo= 0,Process= 0,Done = 0,Close= 0;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserMY userMY = serviceUser.findByUsername(auth.getName());
		model.addAttribute("user", userMY);
		List<Task> listTaskUserAll = new ArrayList<Task>();
		List<Task> listTaskAll = serviceTask.fillAllTask();
		for (Task task : listTaskAll) {
			if (task.getTaskUser().equals(userMY)) {
				listTaskUserAll.add(task);
			}}
		model.addAttribute("listTaskUser", listTaskUserAll);
		model.addAttribute("countTaskUser", listTaskUserAll.size());
		for (Task task_1 : listTaskUserAll) {
			switch (task_1.getTaskStatus().getIdStatusTask()) {
			case 1:
				ToDo++;
				break;
			case 2:
				Process++;
				break;
			case 3:
				Done++;
				break;
			case 4:
				Close++;
				break;	
				}
			}
		model.addAttribute("ToDo", ToDo);
		model.addAttribute("Process", Process);
		model.addAttribute("Done", Done);
		model.addAttribute("Close", Close);
		
		return "task_all";	
	}
	@GetMapping("/delete-{idTask}")
	public String deleteTask(@PathVariable int idTask) {
		serviceTask.deleteTask(idTask);
		return "redirect:/task_all";
	}
}
