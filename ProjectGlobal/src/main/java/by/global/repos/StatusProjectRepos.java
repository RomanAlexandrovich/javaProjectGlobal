package by.global.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import by.global.model.StatusProject;

public interface StatusProjectRepos extends JpaRepository<StatusProject, Integer> {
	StatusProject findByNameStatusProject(String nameStatus);

}
