package net.gondor.user.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.gondor.support.Param;
import net.gondor.user.biz.UserBiz;
import net.gondor.user.biz.UserBizImpl;
import net.gondor.user.vo.UserVO;

/**
 * Servlet implementation class DoLoginServlet
 */
public class DoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Param param;
    private UserBiz biz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoLoginServlet() {
        super();
        param = new Param();
        biz = new UserBizImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = param.getStringParam(request, "id");
		String password = param.getStringParam(request, "password");
		
		if(id.length() == 0) {
			response.sendRedirect("./login?error=2");
			return;
		}
		if(password.length() == 0) {
			response.sendRedirect("./login?error=3");
			return;
		}
		if(biz.isExistsUserId(id)==false){
			response.sendRedirect("./login?error=4");
			return;
		}
		
		UserVO user = new UserVO();
		user.setNick(id);
		user.setPassword(password);
		
		boolean isSuccess = biz.logIn(user, request);
		
		if(isSuccess) {
			response.sendRedirect("/WebToon/story/viewStory");
		}
		//로그인에 실패하였을 경우, 1
		else {
			response.sendRedirect("./login?error=1");
		}
	}
}
