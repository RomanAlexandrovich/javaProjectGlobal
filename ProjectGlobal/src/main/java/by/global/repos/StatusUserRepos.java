package by.global.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import by.global.model.StatusUser;

public interface StatusUserRepos extends JpaRepository<StatusUser, Integer>{
	StatusUser findByNameStatusUser(String nameStatus);

}
