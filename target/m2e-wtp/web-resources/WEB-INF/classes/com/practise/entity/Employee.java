package com.practise.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	private int ID;
	private String NAME;
	private String DEPT;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getDEPT() {
		return DEPT;
	}
	public void setDEPT(String dEPT) {
		DEPT = dEPT;
	}
	@Override
	public String toString() {
		return "Employee [ID=" + ID + ", NAME=" + NAME + ", DEPT=" + DEPT + "]";
	}
}
