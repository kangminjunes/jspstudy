package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import service.BoardService;
import service.BoardServiceImpl;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      // BoardFilter 실행 후 Controller 실행
      
      // 요청 인코딩(BoardFilter가 수행함) + 응답 타입과 인코딩
      // request.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=UTF-8");
      
      // 요청 주소 확인
      String requestURI = request.getRequestURI();
      String contextPath = request.getContextPath();
      String urlMapping = requestURI.substring(contextPath.length());
      
      // 어디로 어떻게 이동할 것인지 알고 있는 ActionForward 객체
      ActionForward af = null;
      
      // BoardService 객체 생성
      BoardService boardService = new BoardServiceImpl();

      // 요청에 따른 처리
      switch(urlMapping) {
      // 단순 이동 (forward 처리)
      
      // 기사 등록화면으로 가기
      case "/board/writeArticle.do":
        af = new ActionForward("/board/write.jsp", false);
        break;
      // 웰컴 화면으로 이동하기
      case "/index.do":
        af = new ActionForward("/index.jsp", false);
        break;
      // 서비스 처리
       
      // 기사 등록하기
      case "/board/addArticle.do":
        af = boardService.addArticle(request);
        break;
      // 기사 수정화면으로 가기
      case "/board/editArticle.do":
        af = boardService.editArticle(request);
        break;
      // 기사 수정하기
      case "/board/modifyArticle.do":
        af = boardService.modifyArticle(request);
        break;
      // 기사 삭제하기
      case "/board/deleteArticle.do":
        af = boardService.deleteArticle(request);
        break;
      // 전체기사 목록 가져오기
      case "/board/getArticleList.do":
        af = boardService.getArticleList(request);
        break;
        // 상세 기사 내용 가져오기
      case "/board/getArticleDetail.do":
        af = boardService.getArticleDetail(request);
        break;
        // 기사 조회수 늘리기
      case "/board/plusHit.do":
        af = boardService.plusHit(request);
        break;
      }
      
      // 이동
      if(af != null) {
        if(af.isRedirect()) {
          response.sendRedirect(af.getPath());
        } else {
          request.getRequestDispatcher(af.getPath()).forward(request, response);
        }
      }
      
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
    }

  }
