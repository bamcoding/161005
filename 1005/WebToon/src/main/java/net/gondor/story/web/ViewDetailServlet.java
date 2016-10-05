package net.gondor.story.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.gondor.story.biz.StoryBiz;
import net.gondor.story.biz.StoryBizImpl;
import net.gondor.story.vo.StoryVO;
import net.gondor.support.Param;

/**
 * Servlet implementation class ViewDetailServlet
 */
public class ViewDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Param param = new Param();
	StoryBiz biz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDetailServlet() {
        super();
        biz = new StoryBizImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = param.getStringParam(request, "id");
		StoryVO story = biz.getStory(id, request);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/story/detail.jsp");
		request.setAttribute("story", story);
		rd.forward(request, response);
	}

}
