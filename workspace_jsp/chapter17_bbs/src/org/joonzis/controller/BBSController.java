package org.joonzis.controller;

import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.reflection.SystemMetaObject;
import org.joonzis.model.Criteria;
import org.joonzis.model.FileDownload;
import org.joonzis.model.PageDTO;
import org.joonzis.service.BService;
import org.joonzis.service.BServiceImpl;
import org.joonzis.vo.BVO;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/BBSController")
public class BBSController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BBSController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		// 파일 업로드
		String realPath = request.getServletContext().getRealPath("/upload");
		// 파일 업로드 시 MultipartRequest 객체로 전달 받음
		MultipartRequest mr = null;

		// 분기판단
		String cmd = request.getParameter("cmd");
		if (cmd == null) {
			// 파일 업로드 시 일반 request에서 받아올 수 없기 때문에
			// mr 객체 생성
			mr = new MultipartRequest(
					request, 
					realPath, 
					1024 * 1024 * 10, 
					"utf-8", 
					new DefaultFileRenamePolicy()
				);
			cmd = mr.getParameter("cmd");
		}

		// 화면 이동 / 서블릿 요청
		// 화면으로 즉 jsp 파일로 이동하는 경우 forward로,
		// 서블릿을 태우고 싶은 경우에는 redirect 사용
		boolean isForward = true;
		// 이동 경로 path
		String path = "";
		// vo 객체 생성
		BVO bvo = null;
		BService bservice = new BServiceImpl();
		// 리턴 객체
		int result = 0;
		List<BVO> list = null;
		// 세션 객체 생성
		HttpSession session = request.getSession();

		// 세션 정보 저장
		String open = null;
		
		//페이징 처리를 위한 객체 선언
		// 다른 영역에서도 사용할 수 있도록 작성
		String pageNum = "";
		String amount = "";
		int parsePageNum = 0;
		int parseAmount = 0;
		
		
		switch (cmd) {
		// 전체 게시글 리스트
		case "allList":
			
			// 1. index.jsp 에서 전달 받은 파라미터로 cri 객체 생성
			pageNum = request.getParameter("pageNum");
			amount = request.getParameter("amount");
			
			if(pageNum != null && amount != null) {
				// pageNum = amount를 잘 전달 받으면
				parsePageNum = Integer.parseInt(pageNum);
				parseAmount = Integer.parseInt(amount);
			}else {
				// 전달 받지 못하면 기본 값으로 초기화
				parsePageNum= 1;
				parseAmount = 5;
			}
			
			Criteria cri = new Criteria(parsePageNum, parseAmount);
			
			path = "bbs/allList.jsp";
			// list = bservice.getList();
			// 2. 페이징 게시글 가져오기
			list = bservice.getListWithPaging(cri);
			
			
			// 3. 전체 게시글 수 만들기
			int total = bservice.getTotalRecordCount();
			System.out.println(total);
			
			// 4. pageDTO 객체 만들기
			PageDTO pdto = new PageDTO(cri, total);
			
			request.setAttribute("list", list);
			request.setAttribute("pageMaker", pdto);
			
			open = (String) session.getAttribute("open");
			if (open != null) {
				session.removeAttribute("open");
			}
			
			break;
		// 게시글 작성 페이지 이동
		case "insertBBSPage":
			path = "bbs/insert_page.jsp";
			break;
		// 게시글 작성
		case "insertBBS":
			bvo = new BVO();
			bvo.setWriter(mr.getParameter("writer"));
			bvo.setPw(mr.getParameter("pw"));
			bvo.setContent(mr.getParameter("content"));
			bvo.setTitle(mr.getParameter("title"));
		 // bvo.setIp(request.getRemoteAddr()); IPv6
			bvo.setIp(Inet4Address.getLocalHost().getHostAddress()); // IPv4
			if(mr.getFile("filename") != null) {
				bvo.setFilename(mr.getFilesystemName("filename"));
			}else {
				bvo.setFilename("");
			}
			
			// result에 따라서 뭔가를 하지 않는다면 필요 x
			result = bservice.InsertBBS(bvo);
			
			isForward = false;
			path = "BBSController?cmd=allList";
			break;
		// 게시글 보기
		case "view":
			bvo = bservice.getViewInfo(Integer.parseInt(request.getParameter("b_idx")));
			
			open = (String) session.getAttribute("open");
			if(open == null) {
				session.setAttribute("open", "yes");
				int hit = bvo.getHit() + 1;
				bvo.setHit(hit);
				bservice.updateHit(bvo);
			}
			
			session.setAttribute("bvo", bvo);
			path = "bbs/view.jsp";
			break;
		// 삭제
		case "remove":
			result = bservice.removeBBS(Integer.parseInt(request.getParameter("b_idx")));
			isForward = false;
			path = "BBSController?cmd=allList";
			break;
		// 파일 다운로드
		case "download":
			FileDownload fd = new FileDownload();
			try {
				fd.doDownload(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		// 수정 페이지
		case "updatePage":
			path = "bbs/update_page.jsp";
			break;
			
		// 수정 실행
		case "update":
			bvo = new BVO();
			bvo.setB_idx(Integer.parseInt(mr.getParameter("b_idx")));
			bvo.setContent(mr.getParameter("content"));
			bvo.setTitle(mr.getParameter("title"));
			
			// 새 첨부 파일
			File newFile = mr.getFile("filename");
			// 기존 첨부 파일 이름
			String oldFile = mr.getParameter("oldfile");
			
			if(newFile != null) {
				// 새 첨부 파일 O
				if(oldFile != null) {
					File removeFile = new File(realPath + "/" + oldFile);
					if(removeFile.exists()) {
						removeFile.delete();
					}
				}
				bvo.setFilename(newFile.getName());
			}else {
				// 새 첨부 파일 X
				if(oldFile != null) {
					// 기존 첨부 파일 O
					bvo.setFilename(oldFile);
				}else {
					// 새 첨부파일, 기존 첨부 파일 X
					bvo.setFilename("");
				}
				
			}
			bservice.updateBBS(bvo);
			isForward = false;
			request.setAttribute("bvo", bvo);
			path = "BBSController?cmd=view&b_idx="+bvo.getB_idx();
			
			break;
		}
	

		if (isForward) {
			request.getRequestDispatcher(path).forward(request, response); // 데이터를 가지고 갈 경우
		} else {
			response.sendRedirect(path);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
