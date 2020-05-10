package by.global.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.global.model.Urgency;
import by.global.repos.UrgencyRepos;
import by.global.service.UrgencyService;
@Service
public class UrgencyServiceImpl implements UrgencyService{
	@Autowired
	private UrgencyRepos reposUrgency;

	@Override
	public List<Urgency> findAllUrgency() {
		return reposUrgency.findAll();
	}

	@Override
	public Urgency findByNameUrgency(String nameUrgency) {
		return reposUrgency.findByNameUrgency(nameUrgency);
	}

}
