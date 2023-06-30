// 클라이언트로부터의 요청을 받아서 해당 요청에 대한 처리를 담당하는 중앙 집중형 컨트롤러
package com.frontcontroller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.command.BAllSelectCommand;
import com.command.BBoardDeleteCommand;
import com.command.BDeleteCommand;
import com.command.BInsertCommand;
import com.command.BReplyCommand;
import com.command.BSelectCommand;
import com.command.BUpdateCommand;
import com.command.Bcommand;
import com.daodto.BoardDTO;

// 1. 클라이언트로부터 GET 또는 POST 요청을 받으면 doGet() or doPOST() 메서드 호출
// 2. 위 두개의 메서드에서는 actionDo() 메서드를 호출하여 요청을 처리
// 3. actionDo() 메서드에서는 
//		요청된 URI 얻어오기
//		context path 얻어오기
// 		URI에서 context path를 제외한 부분을 얻어오기, 이 부분이 실제 요청을 구분하는 명령 (command)
//		명령어에 따라 분기하여 요청을 처리
// 4. 분기처리
//		만약 명령어가 "insert.do"인 경우, "/View/insert.do"와 관련된 처리를 수행
// 		만약 명령어가 "update.do"인 경우, "/update.do"와 관련된 처리를 수행
//		만약 명령어가 "/View/select.do"인 경우, "/View/select.do"와 관련된 처리를 수행

/**
 * Servlet implementation class BfrontController
 */
@WebServlet("*.do") // "*.do"로 끝나는 URL에 매핑하면 해당 서블릿이 ".do"로 끝나는 요청을 처리할 수 있게함
public class BfrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BfrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet 메소드 시작");
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost 메소드 시작");
		doAction(request, response);
	}

	private void doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("actionDo 메소드 시작");

		String uri = request.getRequestURI();
		System.out.println("uri: " + uri);

		String conPath = request.getContextPath();
		System.out.println("conPath: " + conPath);

		String command = uri.substring(conPath.length());
		System.out.println("command: " + command);

		if (command.equals("/View/insert.do")) {
			System.out.println("/View/insert.do");
			Bcommand bcommand = new BInsertCommand();
			String nmName = request.getParameter("nmName");
			String nmTitle = request.getParameter("nmTitle");
			String nmContent = request.getParameter("nmContent");
			bcommand.listInsert(nmName, nmTitle, nmContent);
			response.sendRedirect("/JSP_BoardProject/View/list.jsp");
			System.out.println("-------------------------");

		} else if (command.equals("/View/update.do")) {
			System.out.println("/View/update.do");
			Bcommand bcommand = new BUpdateCommand();
			int nbMvcBoard = Integer.parseInt(request.getParameter("nbMvcBoard"));
			String nmName = request.getParameter("nmName");
			String nmTitle = request.getParameter("nmTitle");
			String nmContent = request.getParameter("nmContent");
			bcommand.listUpdate(nbMvcBoard, nmName, nmTitle, nmContent);
			response.sendRedirect("/JSP_BoardProject/View/list.do");
			System.out.println("-------------------------");

		} else if (command.equals("/View/list.do")) {
			System.out.println("/View/list.do");
			Bcommand bcommand = new BAllSelectCommand();
			ArrayList<BoardDTO> dtos = bcommand.listAllSelect();

			// setAttribute(): HttpServletRequest 객체에 속성을 설정하는 역할, 해당 이름을 사용하여 속성값 가져오기
			// "list"라는 이름으로 dtos라는 ArrayList를 요청에 속성(attribute)로 추가
			request.setAttribute("list", dtos);

			// => 목표: list라는 이름으로 dtos의 데이터를 "/View/list.jsp"로 전달하여 동적인 HTML 콘텐츠를 생성하고
			// 클라이언트에게 반환
			// 디스패쳐 포워드를 사용하여 "/View/list.jsp" JSP 페이지로 요청을 전달하고, 데이터를 전달
			// 객체 생성하여 "/View/list.jsp"를 포워드 대상으로 지정
			RequestDispatcher dispatcher = request.getRequestDispatcher("/View/list.jsp");

			// 아래의 코드를 호출하여 현재의 요청과 응답을
			// "/View/list.jsp"으로 포워딩
			dispatcher.forward(request, response);

			// for문을 통해 dtos의 각 요소에 접근하여 출력
			for (BoardDTO dto : dtos) {
				System.out.println("dto");
			}
			System.out.println("-------------------------");
		} else if (command.equals("/View/content_view.do")) {
			int nbMvcBoard = Integer.parseInt(request.getParameter("nbMvcBoard"));
			Bcommand bcommand = new BSelectCommand();
			BoardDTO dto = bcommand.listSelect(nbMvcBoard);

			request.setAttribute("idContent", dto);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/View/content_view.jsp");
			dispatcher.forward(request, response);

		} else if (command.equals("/View/delete.do")) {
			int nbMvcBoard = Integer.parseInt(request.getParameter("nbMvcBoard"));
			System.out.println("/delete.do");
			Bcommand bcommand = new BBoardDeleteCommand();
			bcommand.boardDelete(nbMvcBoard);
			response.sendRedirect("content_view.jsp");
			System.out.println("-------------------------");
			
		} else if (command.equals("/View/reply.do")) {
			System.out.println("답글 등록 메소드 실행");

			Bcommand bcommand = new BReplyCommand();
			bcommand.replyBoard(request, response);
			response.sendRedirect("list.do");

		}
	}
}
