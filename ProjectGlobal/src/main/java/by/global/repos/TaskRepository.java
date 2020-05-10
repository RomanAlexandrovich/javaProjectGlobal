package by.global.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import by.global.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
	Task findByIdTask(int idTask); 

}
