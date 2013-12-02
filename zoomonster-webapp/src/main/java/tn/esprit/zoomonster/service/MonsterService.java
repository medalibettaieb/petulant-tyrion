package tn.esprit.zoomonster.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import tn.esprit.zoomonster.model.Announcement;
import tn.esprit.zoomonster.model.Student;

@Stateless
public class MonsterService {



	@Inject
	private EntityManager em;

	public MonsterService() {
	}

	public List<Announcement> findAllAnnouncements() {
		return em.createQuery("select a from Announcement a ",
				Announcement.class).getResultList();
	}

	public void save(Student student) {
		em.merge(student);
	}

}
