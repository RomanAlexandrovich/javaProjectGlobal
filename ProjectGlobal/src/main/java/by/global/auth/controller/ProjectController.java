package by.global.auth.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import by.global.model.ProjectGlobal;
import by.global.model.Task;
import by.global.model.UserMY;
import by.global.service.ImageProjectService;
import by.global.service.ImageUserService;
import by.global.service.PosUserService;
import by.global.service.ProjectService;
import by.global.service.StatusProjectService;
import by.global.service.StatusUserService;
import by.global.service.TaskService;
import by.global.service.UserService;

@Controller
public class ProjectController {
	@Autowired
	private ProjectService serviceProject;
	@Autowired
	private UserService serviceUser;
	@Autowired
	private ImageProjectService serviceImageProject;
	@Autowired
	private StatusProjectService serviceStatusProject;
	@Autowired
	private StatusUserService statusUserService;
	@Autowired
	private ImageUserService imageUserService;
	@Autowired
	private PosUserService posUserService;
	@Autowired
	private TaskService serviceTask;
	

	@GetMapping("/project")
	public String createProject(Model model) {
		model.addAttribute("formProject", new ProjectGlobal());
		model.addAttribute("listUser", serviceUser.findAllUser());
		model.addAttribute("listImage", serviceImageProject.AllImageProgect());
		model.addAttribute("listStatus", serviceStatusProject.findAllStatus());
		model.addAttribute("listUsers", serviceUser.findAllUser());

		return "create_project";
	}

	@PostMapping("/project")
	public String createProject(@ModelAttribute("formProject") ProjectGlobal newProject, BindingResult bindingResult) {
		serviceProject.saveProject(newProject);
		return "redirect:/home";
	}

	@GetMapping("/project_user")
	public String projectAddUser(Model model) {
		UserMY userForm = new UserMY();
		model.addAttribute("addUser", userForm);
		model.addAttribute("listStatus", statusUserService.AllStatusUser());
		model.addAttribute("listImageUser", imageUserService.AllImageUser());
		model.addAttribute("listPositionUser", posUserService.AllPositionUser());
		model.addAttribute("listProjectAll", serviceProject.fillAllProject());
		model.addAttribute("listProjectAll", serviceProject.fillAllProject());

		return "projectAndUser";
	}
	@GetMapping(value = { "/project-{idProject}" })
	public String success(@PathVariable Integer idProject, Model model) {
		ProjectGlobal editProject = serviceProject.findbyIdProject(idProject);
		model.addAttribute("project",editProject);
		model.addAttribute("listTask",serviceTask.fillAllTask());
//		for (Task task : serviceTask.fillAllTask()) {
//			if (task.getCreationTaskProjectMain().equals(editProject.getIdProject())) {
//				
//			}
//		};
		return "view_project";
	}
	
	@GetMapping("/projectAccess")
	public String projectAccess(Model model) {
		model.addAttribute("listProject", serviceProject.fillAllProject());
		return "projectAccess";
	}
	@GetMapping(value = { "/project-{idProject}-editAccess" })
	public String projectAccessEdit(@PathVariable Integer idProject, Model model) {
		ProjectGlobal edit=serviceProject.findbyIdProject(idProject);
		model.addAttribute("project", new ProjectGlobal());
		model.addAttribute("projectEdit", edit);
		model.addAttribute("listUser", serviceUser.findAllUser());
		model.addAttribute("listImage", serviceImageProject.AllImageProgect());
		model.addAttribute("listStatus", serviceStatusProject.findAllStatus());
		model.addAttribute("listUsers", serviceUser.findAllUser());
		return "projectAccessProject";
	}
	@PostMapping(value = { "/project-{idProject}-editAccess" })
	public String editProject(@ModelAttribute("project") ProjectGlobal editProject,BindingResult bindingResult) {
	serviceProject.saveProject(editProject);
		return "redirect:/projectAccess";
	}
	@GetMapping(value = { "/projectDelete-{idProject}" })
	public String projectDelete(@PathVariable Integer idProject, Model model) {
		serviceProject.deleteProject(idProject);
		return "redirect:/projectAccess";
	}
	
}
