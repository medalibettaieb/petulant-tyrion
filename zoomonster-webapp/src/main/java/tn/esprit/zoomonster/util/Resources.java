package tn.esprit.zoomonster.util;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Resources {
	
	@Produces
    @PersistenceContext
    private EntityManager em;

}
