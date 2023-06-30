package com.command;

import java.util.ArrayList;

import com.daodto.BoardDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Bcommand {
	
	// SELECT
	public ArrayList<BoardDTO> listAllSelect();
	public BoardDTO listSelect(int nbMvcBoard);
	
	// INSERT
	public void listInsert(String nmName, String nmTitle, String nmContent);
	public void replyBoard(HttpServletRequest request, HttpServletResponse response);
	
	// UPDATE
	public void listUpdate(int nbMvcBoard, String nmName, String nmTitle, String nmContent );
	
	//DELETE
	public void boardDelete(int nbMvcBoards);
	public void listDelete(int[] nbMvcBoards);
	
	
}
