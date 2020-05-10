package by.global.service;

import java.util.List;

import by.global.model.StatusProject;

public interface StatusProjectService {
	StatusProject findByNameStatusProject(String nameStatusProject);
	List<StatusProject> findAllStatus();

}
