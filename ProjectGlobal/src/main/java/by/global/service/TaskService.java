package by.global.service;

import java.util.List;

import by.global.model.Task;

public interface TaskService {
	void deleteTask(Integer idTask);
	void saveTask(Task newTask);
	Task findbyIdTasks(Integer idTask);
	List<Task> fillAllTask();

}
