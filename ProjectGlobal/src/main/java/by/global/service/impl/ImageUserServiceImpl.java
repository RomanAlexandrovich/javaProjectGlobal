package by.global.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.global.model.ImageUser;
import by.global.repos.ImageUserRepository;
import by.global.service.ImageUserService;
@Service
public class ImageUserServiceImpl implements ImageUserService{
@Autowired
private ImageUserRepository repoImageUser;

	@Override
	public List<ImageUser> AllImageUser() {
		return repoImageUser.findAll();
	}

	@Override
	public ImageUser findByIdImageUser(int id) {
		return repoImageUser.findByIdImageUser(id);
	}


}
