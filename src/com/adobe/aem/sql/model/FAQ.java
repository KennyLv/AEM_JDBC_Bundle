package com.adobe.aem.sql.model;

public class FAQ {

	private int id;
	private int order;
	private int faqShow;
	private String faqQuestion;
	private String faqAnswer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public int getFaqShow() {
		return faqShow;
	}
	public void setFaqShow(int faqShow) {
		this.faqShow = faqShow;
	}
	public String getFaqQuestion() {
		return faqQuestion;
	}
	public void setFaqQuestion(String faqQuestion) {
		this.faqQuestion = faqQuestion;
	}
	public String getFaqAnswer() {
		return faqAnswer;
	}
	public void setFaqAnswer(String faqAnswer) {
		this.faqAnswer = faqAnswer;
	}
}
