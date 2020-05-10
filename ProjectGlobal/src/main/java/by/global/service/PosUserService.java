package by.global.service;

import java.util.List;

import by.global.model.PositionUser;

public interface PosUserService {
	PositionUser findByIdUser(Integer idPositionsUser);
	List<PositionUser> AllPositionUser();
	

}
