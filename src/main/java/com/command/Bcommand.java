package com.command;

import java.util.ArrayList;

import com.daodto.BoardDTO;

public interface Bcommand {
	
	// SELECT
	public ArrayList<BoardDTO> listAllSelect();
	public ArrayList<BoardDTO> listSelect();
	
	// INSERT
	public void listInsert();
	
	// UPDATE
	public void listUpdate();
	
	//DELETE
	public void listDelete();
	
}
