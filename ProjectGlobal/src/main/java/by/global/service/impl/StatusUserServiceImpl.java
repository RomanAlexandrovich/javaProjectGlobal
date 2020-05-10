package by.global.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.global.model.StatusUser;
import by.global.repos.StatusUserRepos;
import by.global.service.StatusUserService;

@Service
public class StatusUserServiceImpl implements StatusUserService {
	@Autowired
	private StatusUserRepos repoStatusUser;

	@Override
	public StatusUser findByNameStatusUser(String nameStatus) {
		return repoStatusUser.findByNameStatusUser(nameStatus);
	}

	@Override
	public List<StatusUser> AllStatusUser() {
		return repoStatusUser.findAll();
	}

}
