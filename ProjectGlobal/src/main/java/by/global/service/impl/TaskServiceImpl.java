package by.global.service.impl;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.global.model.Task;
import by.global.repos.TaskRepository;
import by.global.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
	@Autowired
	private TaskRepository repoTask;

	@Override
	public void deleteTask(Integer idTask) {
		repoTask.deleteById(idTask);
	}

	@Override
	public void saveTask(Task newTask) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
		ZonedDateTime zdt=ZonedDateTime.now();
		newTask.setTimeTask(zdt.format(dtf));
		newTask.setCommentTask("");
		repoTask.save(newTask);
	}

	@Override
	public Task findbyIdTasks(Integer idTask) {
		return repoTask.findByIdTask(idTask);
	}

	@Override
	public List<Task> fillAllTask() {
		return repoTask.findAll();
	}

}
