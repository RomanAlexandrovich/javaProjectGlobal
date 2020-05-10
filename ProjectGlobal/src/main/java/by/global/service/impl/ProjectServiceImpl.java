package by.global.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.global.model.ProjectGlobal;
import by.global.repos.ImageProjectRepos;
import by.global.repos.ImageUserRepository;
import by.global.repos.ProjectRepository;
import by.global.service.ProjectService;
@Service
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectRepository repoProject;
	@Autowired
	private ImageProjectRepos repoImage;
	@Override
	public void deleteProject(int idProject) {
		repoProject.deleteById(idProject);	
	}

	@Override
	public void saveProject(ProjectGlobal newProject) {
		repoProject.save(newProject);
		
	}

	@Override
	public ProjectGlobal findbyIdProject(Integer idProject) {
		return repoProject.getByIdProject(idProject);
	}

	@Override
	public List<ProjectGlobal> fillAllProject() {
		return repoProject.findAll();
	}

}
