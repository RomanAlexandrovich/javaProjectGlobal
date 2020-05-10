package by.global.service;

import java.util.List;

import by.global.model.ImageUser;

public interface ImageUserService {
	List<ImageUser> AllImageUser();
	ImageUser findByIdImageUser(int id);

}
