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

/**
 * Servlet implementation class ViewSroryServlet
 */
public class ViewSroryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    StoryBiz biz;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewSroryServlet() {
        super();
        biz = new StoryBizImpl();
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
		List<StoryVO> stories = biz.getStories();
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/story/story.jsp");
		request.setAttribute("stories", stories);
		rd.forward(request, response);
	}

}
