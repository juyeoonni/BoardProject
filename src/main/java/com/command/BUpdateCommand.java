package com.command;

import java.util.ArrayList;

import com.daodto.BoardDAO;
import com.daodto.BoardDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BUpdateCommand implements Bcommand {
	
	@Override
	public ArrayList<BoardDTO> listAllSelect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardDTO listSelect(int nbMvcBoard) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void listInsert(String nmName, String nmTitle, String nmContent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void listUpdate(int nbMvcBoard, String nmName, String nmTitle, String nmContent) {
		BoardDAO dao = new BoardDAO();
        dao.listUpdate(nbMvcBoard, nmName, nmTitle, nmContent);
	}
	
	@Override
	public void boardDelete(int nbMvcBoards) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listDelete(int[] nbMvcBoards) {
		// TODO Auto-generated method stub

	}

	@Override
	public void replyBoard(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	

}
