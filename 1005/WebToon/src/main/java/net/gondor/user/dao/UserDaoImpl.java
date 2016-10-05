package net.gondor.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.gondor.support.DaoSupport;
import net.gondor.support.Query;
import net.gondor.support.QueryResult;
import net.gondor.user.vo.UserVO;

public class UserDaoImpl extends DaoSupport implements UserDao{

	@Override
	public int joinUser(final UserVO userVO) {
		return updateTable(new Query(){

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" INSERT INTO WEBTOON.STORY_USRS (                                                 ");
				query.append("         USR_ID                                                                   ");
				query.append("         , USR_NICK                                                               ");
				query.append("         , USR_PWD                                                                ");
				query.append("         , CRT_DT ,USR_POINT                                                                ");
				query.append("         )                                                                        ");
				query.append(" VALUES (                                                                         ");
				query.append("         'US-'||TO_CHAR(SYSDATE,'YYYYMMDD')||'-'||LPAD(STORY_USRS_ID_SEQ.NEXTVAL,6,0)   ");
				query.append("         ,?                                                                       ");
				query.append("         ,?                                                                       ");
				query.append("         ,SYSDATE , 0                                                              ");
				query.append(" )                                                                                ");
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, userVO.getNick());
				pstmt.setString(2, userVO.getPassword());
				
				return pstmt;
			}
			
		});
	}

	@Override
	public UserVO getUserBy(final UserVO user) {
		return (UserVO) getTable(new QueryResult(){

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT                                                ");
				query.append("         USR_ID                                                                   ");
				query.append("         , USR_NICK                                                               ");
				query.append("         , USR_PWD                                                                ");
				query.append("         , TO_CHAR(CRT_DT, 'YYYY-MM-DD HH24:MI:SS') CRT_DT, USR_POINT           ");
				query.append(" FROM WEBTOON.STORY_USRS ");
				query.append(" WHERE USR_NICK=? AND USR_PWD=? ");
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, user.getNick());
				pstmt.setString(2, user.getPassword());
				
				return pstmt;
			}

			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				UserVO user=null;
				if(rs.next()){
					user=new UserVO();
					user.setId(rs.getString("USR_ID"));
					user.setNick(rs.getString("USR_NICK"));
					user.setPassword(rs.getString("USR_PWD"));
					user.setCreatedDate(rs.getString("CRT_DT"));
					user.setPoint(rs.getInt("USR_POINT"));
				}
				return user;
			}
			
		});
	}

	@Override
	public int countUserId(final String nick) {
		return (int) getTable(new QueryResult(){

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" SELECT COUNT(1) CNT ");
				query.append(" FROM WEBTOON.STORY_USRS ");
				query.append(" WHERE USR_NICK=? ");
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, nick);
				
				return pstmt;
			}

			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				int count = 0;
				if(rs.next()){
				 count = Integer.parseInt(rs.getString("CNT"));
				}
				return count;
			}
			
		});
	}

	@Override
	public int updatePoint(String id, int value) {
		return updateTable(new Query(){
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" UPDATE	STORY_USRS ");
				query.append(" SET		USR_POINT = USR_POINT + ? ");
				query.append(" WHERE	USR_ID=? ");
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setInt(1, value);
				pstmt.setString(2, id);
				
				return pstmt;
			}
		});
	}
}
