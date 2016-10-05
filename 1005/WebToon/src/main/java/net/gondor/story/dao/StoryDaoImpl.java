package net.gondor.story.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.gondor.story.vo.StoryVO;
import net.gondor.support.DaoSupport;
import net.gondor.support.Query;
import net.gondor.support.QueryResult;

public class StoryDaoImpl extends DaoSupport implements StoryDao {

	@Override
	public List<StoryVO> getStories() {
		return (List<StoryVO>) getTable(new QueryResult() {
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append("	SELECT	STORY_ID, WEBTOON_ID, MANAGER_ID_,    ");
				query.append("			STORY_TITLE, STORY_CONT, TO_CHAR(CRT_DT, 'YYYY-DD-MM HH24:MI') CRT_DT,   ");
				query.append("			HIT_CNT, LIKE_CNT                  ");
				query.append("	FROM	WEBTOON.STORY                   ");
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				return pstmt;
			}

			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				List<StoryVO> stories = new ArrayList<StoryVO>();
				StoryVO story = null;
				while (rs.next()) {
					story = new StoryVO();
					story.setId(rs.getString("STORY_ID"));
					story.setWebtoonId(rs.getString("WEBTOON_ID"));
					story.setManagerId(rs.getString("MANAGER_ID_"));
					story.setTitle(rs.getString("STORY_TITLE"));
					story.setContent(rs.getString("STORY_CONT"));
					story.setCreatedDate(rs.getString("CRT_DT"));
					story.setHitCount(rs.getInt("HIT_CNT"));
					story.setLikeCount(rs.getInt("LIKE_CNT"));

					stories.add(story);
				}

				return stories;
			}

		});
	}

	@Override
	public StoryVO getStory(String id) {
		return (StoryVO) getTable(new QueryResult() {

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append("	SELECT	STORY_ID, WEBTOON_ID, MANAGER_ID_,    ");
				query.append("			STORY_TITLE, STORY_CONT, TO_CHAR(CRT_DT, 'YYYY-DD-MM HH24:MI') CRT_DT,   ");
				query.append("			HIT_CNT, LIKE_CNT                  ");
				query.append("	FROM	WEBTOON.STORY                   ");
				query.append("	WHERE	STORY_ID=? ");
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, id);
				return pstmt;
			}

			@Override
			public Object makeObject(ResultSet rs) throws SQLException {
				StoryVO story = null;
				if (rs.next()) {
					story = new StoryVO();
					story.setId(rs.getString("STORY_ID"));
					story.setWebtoonId(rs.getString("WEBTOON_ID"));
					story.setManagerId(rs.getString("MANAGER_ID_"));
					story.setTitle(rs.getString("STORY_TITLE"));
					story.setContent(rs.getString("STORY_CONT"));
					story.setCreatedDate(rs.getString("CRT_DT"));
					story.setHitCount(rs.getInt("HIT_CNT"));
					story.setLikeCount(rs.getInt("LIKE_CNT"));
				}
				return story;
			}
		});
	}

	@Override
	public void deleteStory(String id) {
		updateTable(new Query() {
			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" DELETE ");
				query.append(" FROM 	WEBTOON.STORY ");
				query.append(" WHERE	STORY_ID=? ");
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, id);
				return pstmt;
			}
		});
	}

	@Override
	public int writeStory(StoryVO story) {
		return updateTable(new Query() {
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" INSERT INTO WEBTOON.STORY ( ");
				query.append("							STORY_ID, WEBTOON_ID, MANAGER_ID_,    ");
				query.append("							STORY_TITLE, STORY_CONT, CRT_DT,   ");
				query.append("							HIT_CNT, LIKE_CNT) ");
				query.append("					VALUES ( ");
				query.append("							'ST-'||TO_CHAR(SYSDATE,'YYYYDDMM')||'-'||LPAD(STORY_ID_SEQ.NEXTVAL,6,0) ");
				query.append("							,'신의탑' ");
				query.append("							,? ");
				query.append("							,? ");
				query.append("							,? ");
				query.append("							,SYSDATE ");
				query.append("							,0 ");
				query.append("							,0) ");
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, story.getManagerId());
				pstmt.setString(2, story.getTitle());
				pstmt.setString(3, story.getContent());
				return pstmt;
			}
		});
	}

	@Override
	public void updateHitCount(String id) {
		// TODO Auto-generated method stub
		updateTable(new Query(){

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" UPDATE	WEBTOON.STORY ");
				query.append(" SET		HIT_CNT = HIT_CNT + 1");
				query.append(" WHERE	STORY_ID=? ");
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, id);
				
				return pstmt;
			}
		});
	}
	public int updateLikeCount(String id) {
		// TODO Auto-generated method stub
		return updateTable(new Query(){

			@Override
			public PreparedStatement query(Connection conn) throws SQLException {
				StringBuffer query = new StringBuffer();
				query.append(" UPDATE	WEBTOON.STORY ");
				query.append(" SET		LIKE_CNT = LIKE_CNT + 1");
				query.append(" WHERE	STORY_ID=? ");
				PreparedStatement pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, id);
				
				return pstmt;
			}
		});
	}
}
