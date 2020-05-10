package by.global.service;

import java.util.List;

import by.global.model.ProjectGlobal;

public interface ProjectService {
	void deleteProject(int idProject);
	void saveProject(ProjectGlobal newProject);
	ProjectGlobal findbyIdProject(Integer idProject);
	List<ProjectGlobal> fillAllProject();


}
