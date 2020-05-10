package by.global.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.global.model.ImageProject;
import by.global.repos.ImageProjectRepos;
import by.global.service.ImageProjectService;
@Service
public class ImageProjectServiceImpl implements ImageProjectService {

	@Autowired
	private ImageProjectRepos repoImageProject;

	@Override
	public List<ImageProject> AllImageProgect() {
		return repoImageProject.findAll();
	}

}
