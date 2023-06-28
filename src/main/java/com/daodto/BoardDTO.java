package com.daodto;

import java.sql.Timestamp;

public class BoardDTO {
	private int nbMvcBoard;
	private String nmName;
	private String nmTitle;
	private String nmContent;
	private Timestamp dwWrite;
	private int cnHit;
	private int nbGroup;
	private int nbStep;
	private int nbIndent;
	
	public BoardDTO(int nbMvcBoard, String nmName, String nmTitle, String nmContent, Timestamp dwWrite, int cnHit,
			int nbGroup, int nbStep, int nbIndent) {
		super();
		this.nbMvcBoard = nbMvcBoard;
		this.nmName = nmName;
		this.nmTitle = nmTitle;
		this.nmContent = nmContent;
		this.dwWrite = dwWrite;
		this.cnHit = cnHit;
		this.nbGroup = nbGroup;
		this.nbStep = nbStep;
		this.nbIndent = nbIndent;
	}

	public int getNbMvcBoard() {
		return nbMvcBoard;
	}

	public void setNbMvcBoard(int nbMvcBoard) {
		this.nbMvcBoard = nbMvcBoard;
	}

	public String getNmName() {
		return nmName;
	}

	public void setNmName(String nmName) {
		this.nmName = nmName;
	}

	public String getNmTitle() {
		return nmTitle;
	}

	public void setNmTitle(String nmTitle) {
		this.nmTitle = nmTitle;
	}

	public String getNmContent() {
		return nmContent;
	}

	public void setNmContent(String nmContent) {
		this.nmContent = nmContent;
	}

	public Timestamp getDwWrite() {
		return dwWrite;
	}

	public void setDwWrite(Timestamp dwWrite) {
		this.dwWrite = dwWrite;
	}

	public int getCnHit() {
		return cnHit;
	}

	public void setCnHit(int cnHit) {
		this.cnHit = cnHit;
	}

	public int getNbGroup() {
		return nbGroup;
	}

	public void setNbGroup(int nbGroup) {
		this.nbGroup = nbGroup;
	}

	public int getNbStep() {
		return nbStep;
	}

	public void setNbStep(int nbStep) {
		this.nbStep = nbStep;
	}

	public int getNbIndent() {
		return nbIndent;
	}

	public void setNbIndent(int nbIndent) {
		this.nbIndent = nbIndent;
	}
	
	
	
}

