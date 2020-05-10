package by.global.service;

import java.util.List;

import by.global.model.StatusTask;

public interface StatusTaskService {
	StatusTask findByNameStatusTask(String nameStatus);
	List<StatusTask> findAllStatusTask();

}
