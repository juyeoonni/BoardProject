package com.daodto;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BoardDAO {

	private String url = "jdbc:oracle:thin:@192.168.119.119:1521/dink18";
	private String uid = "C##scott";
	private String upw = "tiger";

	public BoardDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 전체 글 조회 (All Select)
	public ArrayList<BoardDTO> listAllSelect() {
		ArrayList<BoardDTO> bDtos = new ArrayList<BoardDTO>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(url, uid, upw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from mvc_board");

			while (rs.next()) {
				int nbMvcBoard = rs.getInt("nbMvcBoard");
				String nmName = rs.getString("nmName");
				String nmTitle = rs.getString("nmTitle");
				String nmContent = rs.getString("nmContent");
				Timestamp dwWrite = rs.getTimestamp("dwWrite");
				int cnHit = rs.getInt("cnHit");
				int nbGroup = rs.getInt("nbGroup");
				int nbStep = rs.getInt("nbStep");
				int nbIndent = rs.getInt("nbIndent");

				BoardDTO bDto = new BoardDTO(nbMvcBoard, nmName, nmTitle, nmContent, dwWrite, cnHit, nbGroup, nbStep,
						nbIndent);
				bDtos.add(bDto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 데이터베이스 관련 자원인 ResultSet, Statement, Connection을 해제하는 역할
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return bDtos;
	}
	

	// 특정 글 번호에 대한 게시글 조회 (Select)
	public BoardDTO listSelect(int uNbMvcBoard) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		BoardDTO dto = null;

		try {
			conn = DriverManager.getConnection(url, uid, upw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from users where nbMvcBoard = '" + uNbMvcBoard + "'");

			while (rs.next()) {
				int nbMvcBoard = rs.getInt("nbMvcBoard");
				String nmName = rs.getString("nmName");
				String nmTitle = rs.getString("nmTitle");
				String nmContent = rs.getString("nmContent");
				Timestamp dwWrite = rs.getTimestamp("dwWrite");
				int cnHit = rs.getInt("cnHit");
				int nbGroup = rs.getInt("nbGroup");
				int nbStep = rs.getInt("nbStep");
				int nbIndent = rs.getInt("nbIndent");
				
				dto = new BoardDTO(nbMvcBoard, nmName, nmTitle, nmContent, dwWrite, cnHit, nbGroup, nbStep, nbIndent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
}
