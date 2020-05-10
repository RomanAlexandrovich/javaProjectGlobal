package by.global.service.impl;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import by.global.model.Roles;
import by.global.model.UserMY;
import by.global.repos.ImageUserRepository;
import by.global.repos.RolesRepository;
import by.global.repos.UserRepository;
import by.global.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RolesRepository roleRepository;
	@Autowired(required = true)
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private ImageUserRepository repoImage;

	@Override
	public void save(UserMY user, boolean level) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
		ZonedDateTime zdt = ZonedDateTime.now();
		user.setPasswordUser(bCryptPasswordEncoder.encode(user.getPasswordUser()));
		if (level) {
			user.setRolesUser(new HashSet<>(roleRepository.findAll()));
		} else {
			HashSet<Roles> rolesSet = new HashSet<>();
			rolesSet.add(roleRepository.findByIdRole(2));
			user.setRolesUser(rolesSet);
		}
		user.setAvatarImageUser(repoImage.findByIdImageUser(1));
		user.setLastUserdUser(dtf.format(zdt));
		userRepository.save(user);
	}

	@Override
	public UserMY findByUsername(String username) {
		return userRepository.findByNameUser(username);
	}

	@Override
	public List<UserMY> findAllUser() {
		return userRepository.findAll();
	}

}
