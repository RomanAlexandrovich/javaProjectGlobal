package by.global.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.global.model.Roles;
import by.global.repos.RolesRepository;
import by.global.service.RolesService;
@Service
public class RolesServiceImpl implements RolesService{

	@Autowired
	private RolesRepository repoRoles;
	@Override
	public Roles findByIdRole(int idRole) {
		return repoRoles.findByIdRole(idRole);
	}

}
