package net.gondor.story.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.gondor.constants.Session;
import net.gondor.story.biz.StoryBiz;
import net.gondor.story.biz.StoryBizImpl;
import net.gondor.story.vo.StoryVO;
import net.gondor.support.Param;
import net.gondor.user.vo.UserVO;

public class DoWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Param param;
	private StoryBiz biz; 

	public DoWriteServlet() {
        super();
        param = new Param();
        biz = new StoryBizImpl();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = param.getStringParam(request, "title");
		String content = param.getStringParam(request, "content");
		
		if(title.length()==0){
			response.sendRedirect("./write?error=1");
			return;
		}
		if(content.length()==0){
			response.sendRedirect("./write?error=2");
			return;
		}
		
		content = content.replace("\n", "<br/>");
		
		HttpSession session = request.getSession(); 
		UserVO userInfo = (UserVO)session.getAttribute(Session.SESSION_INFO);
		String userNickname = userInfo.getNick();
				
		StoryVO story = new StoryVO();
		story.setTitle(title);
		story.setContent(content);
		story.setManagerId(userNickname);
		
		boolean isSuccess = biz.writeStory(story, request);
		if(isSuccess){
			response.sendRedirect("./viewStory");
		}	
		else{
			response.sendRedirect("./write");
		}
	}
}
