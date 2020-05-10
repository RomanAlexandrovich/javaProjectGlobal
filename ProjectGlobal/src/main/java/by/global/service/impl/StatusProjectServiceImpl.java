package by.global.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.global.model.StatusProject;
import by.global.repos.StatusProjectRepos;
import by.global.service.StatusProjectService;
@Service
public class StatusProjectServiceImpl implements StatusProjectService{
@Autowired
private StatusProjectRepos repoStatusProject;
	@Override
	public StatusProject findByNameStatusProject(String nameStatusProject) {
		return repoStatusProject.findByNameStatusProject(nameStatusProject);
	}
	@Override
	public List<StatusProject> findAllStatus() {
		return repoStatusProject.findAll();
	}

}
