package net.gondor.story.biz;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.gondor.constants.Session;
import net.gondor.story.dao.StoryDao;
import net.gondor.story.dao.StoryDaoImpl;
import net.gondor.story.vo.StoryVO;
import net.gondor.user.dao.UserDao;
import net.gondor.user.dao.UserDaoImpl;
import net.gondor.user.vo.UserVO;

public class StoryBizImpl implements StoryBiz {

	StoryDao dao;
	UserDao userdao;

	public StoryBizImpl() {
		super();
		dao = new StoryDaoImpl();
		userdao = new UserDaoImpl();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<StoryVO> getStories() {
		return dao.getStories();
	}

	@Override
	public StoryVO getStory(String id, HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute(Session.SESSION_INFO);
		userdao.updatePoint(user.getId(), -1);
		dao.updateHitCount(id);
		return dao.getStory(id);
	}

	@Override
	public void deleteStory(String id) {
		// TODO Auto-generated method stub
		dao.deleteStory(id);
	}

	@Override
	public boolean writeStory(StoryVO article, HttpServletRequest request) {
		// TODO Auto-generated method stub
		boolean isTrue = dao.writeStory(article) > 0;
		if (isTrue) {
			HttpSession session = request.getSession();
			UserVO user = (UserVO) session.getAttribute(Session.SESSION_INFO);
			userdao.updatePoint(user.getId(), -1);
		}
		return isTrue;
	}

	@Override
	public boolean updateLikeCount(String id) {
		return dao.updateLikeCount(id) > 0;

	}

}
