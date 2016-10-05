package net.gondor.user.biz;

import javax.servlet.http.HttpServletRequest;

import net.gondor.user.vo.UserVO;

public interface UserBiz {
	public boolean joinUser(UserVO userVO);

	public boolean logIn(UserVO user, HttpServletRequest request);

	public boolean isExistsUserId(String id); 
}
