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


public class DoJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Param param = new Param();
	private UserBiz userBiz;
    public DoJoinServlet() {
        super();
        userBiz = new UserBizImpl();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = param.getStringParam(request, "id");
		String password1 = param.getStringParam(request, "password1");
		String password2 = param.getStringParam(request, "password2");
		String name = param.getStringParam(request, "name");

		//아이디 입력하지 않음
		if(id.length() == 0) {
			response.sendRedirect("./join?error=2");
			return;
		}
		
		//비밀번호를 입력하지 않음3
		if(password1.length() == 0 ||password2.length() == 0) {
			response.sendRedirect("./join?error=3");
			return;
		}
		
		//중복된 아이디임4
		if(userBiz.isExistsUserId(id)) {
			response.sendRedirect("./join?error=4");
			return;
		}
		
		//비밀번호 재확인이 틀림5
		boolean samePassword = (password1.equals(password2));  
		if(samePassword==false) {
			response.sendRedirect("./join?error=5");
			return;
		}
		
		UserVO user = new UserVO();
		//입력받은 id는 db에서 닉네임이다.
		user.setNick(id);;
		user.setPassword(password1);
		
		//서버에 문제가 생김1
		boolean isSuccess = userBiz.joinUser(user);
		if(isSuccess) {
			response.sendRedirect("./login");
		}
		else {
			response.sendRedirect("./join?errorCode=1");
		}
	}
}
