package by.global.service;

import java.util.List;

import by.global.model.Urgency;

public interface UrgencyService {
	List<Urgency> findAllUrgency();
	Urgency findByNameUrgency(String nameUrgency);

}
