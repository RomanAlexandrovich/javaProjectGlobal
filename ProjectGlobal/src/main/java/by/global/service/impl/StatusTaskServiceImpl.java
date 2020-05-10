package by.global.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.global.model.StatusTask;
import by.global.repos.StatusTaskRepository;
import by.global.service.StatusTaskService;

@Service
public class StatusTaskServiceImpl implements StatusTaskService{
@Autowired
private StatusTaskRepository repoStatusTask;
	@Override
	public StatusTask findByNameStatusTask(String nameStatus) {
		return repoStatusTask.findByNameStatusTask(nameStatus);
	}
	@Override
	public List<StatusTask> findAllStatusTask() {
		return repoStatusTask.findAll();
	}

}
