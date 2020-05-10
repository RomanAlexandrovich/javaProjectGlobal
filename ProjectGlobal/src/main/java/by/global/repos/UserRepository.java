package by.global.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import by.global.model.UserMY;

public interface UserRepository extends JpaRepository<UserMY, Integer> {
	UserMY findByNameUser(String nameUser);
}
