package tn.esprit.zoomonster.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import tn.esprit.zoomonster.model.Announcement;
import tn.esprit.zoomonster.service.MonsterService;


@Named("actr")
@RequestScoped
public class AnnouncementController {
	
	@Inject
	private MonsterService monsterService;
	
	
	private List<Announcement> announcements;	
	
	public AnnouncementController() {
	}
	
	
	@PostConstruct
	public void init(){
		announcements = monsterService.findAllAnnouncements();
	}


	public List<Announcement> getAnnouncements() {
		return announcements;
	}
	public void setAnnouncements(List<Announcement> announcements) {
		this.announcements = announcements;
	}

}
