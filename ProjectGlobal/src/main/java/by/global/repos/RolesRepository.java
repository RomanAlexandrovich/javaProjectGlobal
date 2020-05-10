package by.global.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import by.global.model.Roles;

public interface RolesRepository extends JpaRepository<Roles, Integer>{
	Roles findByIdRole(int idRole);

}
