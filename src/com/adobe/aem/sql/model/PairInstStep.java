package com.adobe.aem.sql.model;

public class PairInstStep {
    private int stepOrder;
    private int stepGroup;
    private String instruction;
	public int getStepOrder() {
		return stepOrder;
	}
	public void setStepOrder(int stepOrder) {
		this.stepOrder = stepOrder;
	}
	public int getStepGroup() {
		return stepGroup;
	}
	public void setStepGroup(int stepGroup) {
		this.stepGroup = stepGroup;
	}
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
}
