package com.command;

import java.util.ArrayList;

import com.daodto.BoardDAO;
import com.daodto.BoardDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BAllSelectCommand implements Bcommand {
	@Override
	public ArrayList<BoardDTO> listAllSelect() {
		BoardDAO bDao = new BoardDAO();
		ArrayList<BoardDTO> bDtos = bDao.listAllSelect();
		return bDtos;
	}

	@Override
	public void listInsert(String nmName, String nmTitle, String nmContent) {
		
	}

	@Override
	public void listUpdate(int nbMvcBoard, String nmName, String nmTitle, String nmContent) {
		
	}

	
	@Override
	public void listDelete(int[] nbMvcBoards) {
		
	}

	@Override
	public BoardDTO listSelect(int nbMvcBoard) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void boardDelete(int nbMvcBoards) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void replyBoard(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	
}
