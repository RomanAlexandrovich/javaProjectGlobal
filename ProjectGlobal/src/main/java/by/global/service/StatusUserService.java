package by.global.service;

import java.util.List;

import by.global.model.StatusUser;

public interface StatusUserService {
	StatusUser findByNameStatusUser(String nameStatus);
	List<StatusUser> AllStatusUser();

}
