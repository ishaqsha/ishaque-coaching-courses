package com.ishaquecoaching.microservices.model;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CourseDetails")
public class CourseDetails {

	@Transient
	public static final String SEQUENCE_NAME = "course_sequence";

	@Id
	private long id;

	private String banner1;
	private String banner2;
	private String courseName;
	private String heading1;
	private String heading2;
	private List<String> headingList;
	private List<String> elegibilityList;
	private Map<Integer, List<String>> skillsCovered;
	private String upComingBatch;
	private List<CarriCulam> carriCulamList;
	private String whyCard1;
	private String whyCard2;
	private String whyCard3;
	private Trainer Trainer;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBanner1() {
		return banner1;
	}

	public void setBanner1(String banner1) {
		this.banner1 = banner1;
	}

	public String getBanner2() {
		return banner2;
	}

	public void setBanner2(String banner2) {
		this.banner2 = banner2;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getHeading1() {
		return heading1;
	}

	public void setHeading1(String heading1) {
		this.heading1 = heading1;
	}

	public String getHeading2() {
		return heading2;
	}

	public void setHeading2(String heading2) {
		this.heading2 = heading2;
	}

	public List<String> getHeadingList() {
		return headingList;
	}

	public void setHeadingList(List<String> headingList) {
		this.headingList = headingList;
	}

	public List<String> getElegibilityList() {
		return elegibilityList;
	}

	public void setElegibilityList(List<String> elegibilityList) {
		this.elegibilityList = elegibilityList;
	}

	public Map<Integer, List<String>> getSkillsCovered() {
		return skillsCovered;
	}

	public void setSkillsCovered(Map<Integer, List<String>> skillsCovered) {
		this.skillsCovered = skillsCovered;
	}

	public String getUpComingBatch() {
		return upComingBatch;
	}

	public void setUpComingBatch(String upComingBatch) {
		this.upComingBatch = upComingBatch;
	}

	public List<CarriCulam> getCarriCulamList() {
		return carriCulamList;
	}

	public void setCarriCulamList(List<CarriCulam> carriCulamList) {
		this.carriCulamList = carriCulamList;
	}

	public String getWhyCard1() {
		return whyCard1;
	}

	public void setWhyCard1(String whyCard1) {
		this.whyCard1 = whyCard1;
	}

	public String getWhyCard2() {
		return whyCard2;
	}

	public void setWhyCard2(String whyCard2) {
		this.whyCard2 = whyCard2;
	}

	public String getWhyCard3() {
		return whyCard3;
	}

	public void setWhyCard3(String whyCard3) {
		this.whyCard3 = whyCard3;
	}

	public Trainer getTrainer() {
		return Trainer;
	}

	public void setTrainer(Trainer trainer) {
		Trainer = trainer;
	}

}
