package by.global.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import by.global.model.ImageProject;

public interface ImageProjectRepos extends JpaRepository<ImageProject, Integer>{
	ImageProject findByIdImageProject(int id);
	

}
