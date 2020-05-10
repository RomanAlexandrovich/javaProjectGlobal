package by.global.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import by.global.model.ImageUser;

public interface ImageUserRepository extends JpaRepository<ImageUser, Integer> {
	ImageUser findByIdImageUser(int id);

}
