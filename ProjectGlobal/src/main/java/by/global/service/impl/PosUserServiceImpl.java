package by.global.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.global.model.PositionUser;
import by.global.repos.PosUserRepos;
import by.global.service.PosUserService;

@Service
public class PosUserServiceImpl implements PosUserService {
	@Autowired
	private PosUserRepos repoPosUser;

	@Override
	public PositionUser findByIdUser(Integer idPositionsUser) {
		return repoPosUser.getOne(idPositionsUser);
	}

	@Override
	public List<PositionUser> AllPositionUser() {
		return repoPosUser.findAll();
	}

}
