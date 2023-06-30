package com.command;

import com.daodto.*;
import java.util.ArrayList;

import com.daodto.BoardDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BReplyCommand implements Bcommand {

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
		// TODO Auto-generated method stub

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

		int originalPostId = Integer.parseInt(request.getParameter("nbMvcBoard"));

		System.out.println(originalPostId);
		
		
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO(request.getParameter("nmName"), request.getParameter("nmTitle"),
				request.getParameter("nmContent"));
		dao.replyBoard(originalPostId, dto);

	}

}
