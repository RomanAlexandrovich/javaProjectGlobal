package by.global.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import by.global.model.StatusTask;

public interface StatusTaskRepository extends JpaRepository<StatusTask, Integer> {
	StatusTask findByNameStatusTask(String nameStatus);

}
