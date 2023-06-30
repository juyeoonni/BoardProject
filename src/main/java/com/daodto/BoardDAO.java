package com.daodto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
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
	// content_view.do 사용
	public BoardDTO listSelect(int uNbMvcBoard) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		BoardDTO dto = null;

		try {
			conn = DriverManager.getConnection(url, uid, upw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from mvc_board where nbMvcBoard = '" + uNbMvcBoard + "'");

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
		System.out.println(dto);
		return dto;

	}

	public void plusHit(int uNbMvcBoard) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDTO dto = null;

		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement("update mvc_board set cnHit =  cnHit+1  where nbMvcBoard = ?");
			pstmt.setInt(1, uNbMvcBoard);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

	// 게시글 추가 하며 그룹 설정 메서드
	public BoardDTO groupCheck(String nmName, String nmTitle, String nmContent) {
		int nbGroup = 0;
		ArrayList<BoardDTO> dtos = listAllSelect();
		for (BoardDTO dto : dtos) {
			System.out.println(dto.getNbGroup());
			if (dto.getNbGroup() > nbGroup) {
				nbGroup = dto.getNbGroup();
			}
		}

		BoardDTO dto = new BoardDTO(nmName, nmTitle, nmContent);
		dto.setNbGroup(nbGroup + 1);
		return dto;
	}

	// 게시글 작성 (insert)
	public void listInsert(String nmName, String nmTitle, String nmContent) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDTO dto = groupCheck(nmName, nmTitle, nmContent);
		dto.setNbGroup(0);

		String query = "INSERT INTO mvc_board (nmName, nmTitle, nmContent, dwWrite, nbGroup)\r\n"
				+ "VALUES (?, ?, ?, sysdate, ?)";

		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getNmName());
			pstmt.setString(2, dto.getNmTitle());
			pstmt.setString(3, dto.getNmContent());
			pstmt.setInt(4, dto.getNbGroup());
			int iResult = pstmt.executeUpdate();

			if (iResult >= 1) {
				System.out.println("insert success");

			} else {
				System.out.println("insert fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// 게시글 수정 (Update)
	public void listUpdate(int nbMvcBoard, String nmName, String nmTitle, String nmContent) {
		System.out.println(nmName);
		System.out.println(nmTitle);
		System.out.println(nmContent);
		System.out.println(nbMvcBoard);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String query = "update mvc_board set nmName = ?, nmTitle = ?, nmContent = ? where nbMvcBoard = ?";
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, nmName);
			pstmt.setString(2, nmTitle);
			pstmt.setString(3, nmContent);
			pstmt.setInt(4, nbMvcBoard);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	// 게시글 아이디 받아 하나 삭제 (Delete) 
	public void boardDelete(int nbMvcBoard) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String query = "DELETE FROM mvc_board WHERE nbMvcBoard = ?";

		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, nbMvcBoard);

			int iResult = pstmt.executeUpdate();

			if (iResult >= 1) {
				System.out.println("delete success");
			} else {
			}
			System.out.println("delete fail");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	// 게시글 삭제 (Delete)
	public void listDelete(int[] nbMvcBoards) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DriverManager.getConnection(url, uid, upw);

			String query = "delete from mvc_board where nbMvcBoards = ?";

			pstmt = conn.prepareStatement(query);

			for (int nbMvcBoard : nbMvcBoards) {
				int convertedId = nbMvcBoard;
				pstmt.setInt(1, convertedId);

				int rowsAffected = pstmt.executeUpdate();

				if (rowsAffected <= 0) {
					// 삭제되지 않은 경우 처리 로직 추가
					System.out.println("delete failed");
				} else {
					System.out.println("delete sucess");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 리소스 해제
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	// 
	public void replyBoard(int originalPostId, BoardDTO replydto) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        conn = DriverManager.getConnection(url, uid, upw);

	        // 원글 조회
	        String originalPostQuery = "SELECT nbGroup, nbStep FROM MVC_BOARD WHERE nbMvcBoard = ?";
	        pstmt = conn.prepareStatement(originalPostQuery);
	        pstmt.setInt(1, originalPostId);
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            int originalCategory = rs.getInt("nbGroup");
	            int originalLevel = rs.getInt("nbStep");
	            originalCategory = originalPostId;
	            // 답글 작성
	            String replyQuery = "INSERT INTO MVC_BOARD (nmName, nmTitle, nmContent, nbGroup, nbStep) VALUES (?, ?, ?, ?, ?)";
	            pstmt = conn.prepareStatement(replyQuery);
	            pstmt.setString(1, replydto.getNmName());

	            // 제목에 레벨만큼 "-" 기호 추가
	            String replyTitle = "-".repeat(originalLevel) + " " + replydto.getNmTitle();
	            pstmt.setString(2, replyTitle);

	            pstmt.setString(3, replydto.getNmContent());
	            pstmt.setInt(4, originalCategory);
	            pstmt.setInt(5, originalLevel + 1);

	            int iResult = pstmt.executeUpdate();

	            if (iResult > 0) {
	                System.out.println("답글이 성공적으로 생성되었습니다.");
	            } else {
	                System.out.println("답글 생성에 실패하였습니다.");
	            }
	        } else {
	            System.out.println("원글을 찾을 수 없습니다.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (pstmt != null) {
	                pstmt.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

}
