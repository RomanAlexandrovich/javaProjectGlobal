package by.global.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import by.global.model.ProjectGlobal;

public interface ProjectRepository extends JpaRepository<ProjectGlobal, Integer> {
ProjectGlobal getByIdProject(int idProject);
}
