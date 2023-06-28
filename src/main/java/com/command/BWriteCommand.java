package com.command;

import java.util.ArrayList;

import com.daodto.BoardDAO;
import com.daodto.BoardDTO;

public class BWriteCommand implements Bcommand {
	@Override
	public ArrayList<BoardDTO> listAllSelect() {
		BoardDAO bDao = new BoardDAO();
		ArrayList<BoardDTO> bDtos = bDao.listAllSelect();
		return bDtos;
	}

	@Override
	public ArrayList<BoardDTO> listSelect() {
		BoardDAO bDao = new BoardDAO();
		ArrayList<BoardDTO> bDtos = bDao.listAllSelect();
		return bDtos;
	}

	@Override
	public void listInsert() {
		
	}

	@Override
	public void listUpdate() {
		
	}

	@Override
	public void listDelete() {
		
	}

}
