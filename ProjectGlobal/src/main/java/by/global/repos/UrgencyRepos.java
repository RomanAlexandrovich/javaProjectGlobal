package by.global.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import by.global.model.Urgency;

public interface UrgencyRepos extends JpaRepository<Urgency, Integer>{
	Urgency findByNameUrgency(String nameUrgency);

}
