package net.gondor.user.biz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.gondor.constants.Session;
import net.gondor.user.dao.UserDao;
import net.gondor.user.dao.UserDaoImpl;
import net.gondor.user.vo.UserVO;

public class UserBizImpl implements UserBiz {

	private UserDao dao;

	public UserBizImpl() {
		super();
		dao = new UserDaoImpl();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean joinUser(UserVO userVO) {
		boolean isTrue = dao.joinUser(userVO) > 0;
		if(isTrue){
			dao.updatePoint(userVO.getId(), 100);
		}
		return isTrue;
	}

	@Override
	public boolean logIn(UserVO user, HttpServletRequest request) {
		UserVO userInfo = dao.getUserBy(user);

		// NullPointerException 발생 방지하기 위함 원래는 userInfo.getUserId().length() > 0
		// 만 해주면됨!
		if (userInfo != null && userInfo.getId() != null && userInfo.getId().length() > 0) {
			dao.updatePoint(userInfo.getId(), 20);
			HttpSession session = request.getSession();
			session.setAttribute(Session.SESSION_INFO, userInfo);
			return true;
		}
		return false;
	}

	@Override
	public boolean isExistsUserId(String nick) {
		int count = dao.countUserId(nick);
		return count > 0;
	}

}
