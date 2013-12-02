package tn.esprit.zoomonster.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import tn.esprit.zoomonster.model.MediaItem;
import tn.esprit.zoomonster.model.Student;
import tn.esprit.zoomonster.service.MonsterService;

@Named
@ConversationScoped
public class StudentController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Conversation conversation;

	public void beginConversation() {
		if (conversation.isTransient()) {
			conversation.begin();
		}
	}

	public void endConversation() {
		if (!conversation.isTransient()) {
			conversation.end();
		}
	}

	@Inject
	private MonsterService monsterService;

	private Student student;

	public StudentController() {
	}

	@PostConstruct
	public void init() {
		student = new Student();
	}

	public String doAddStudent() {
		String navigateTo = null;
		monsterService.save(student);
		endConversation();
		return navigateTo;
	}

	public void handleFileUpload(FileUploadEvent event) {
		FacesMessage msg = new FacesMessage("Succesful", event.getFile()
				.getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		UploadedFile file = event.getFile();
		byte[] data = file.getContents();
		MediaItem picture = new MediaItem();
		picture.setData(data);
		student.setPicture(picture);
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
