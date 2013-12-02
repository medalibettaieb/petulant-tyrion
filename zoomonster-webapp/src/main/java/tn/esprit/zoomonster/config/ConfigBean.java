package tn.esprit.zoomonster.config;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import tn.esprit.zoomonster.model.Announcement;

@Singleton
@Startup
public class ConfigBean {
	
	@Inject
	private EntityManager em;	
	
	public ConfigBean() {
	}
	
	
	@PostConstruct
	public void createData(){
		Announcement anc1 = new Announcement("r u ready?","to be or not to be");
		Announcement anc2 = new Announcement("get set!","now or never");
		em.persist(anc1);
		em.persist(anc2);
	}

}
