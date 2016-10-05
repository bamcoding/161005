package net.gondor.user.dao;

import net.gondor.user.vo.UserVO;

public interface UserDao {
	public int joinUser(UserVO userVO);

	public UserVO getUserBy(UserVO user);

	public int countUserId(String id); 
	public int updatePoint(String id, int value);
}
