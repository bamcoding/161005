package net.gondor.story.dao;

import java.util.List;

import net.gondor.story.vo.StoryVO;


public interface StoryDao {
	public List<StoryVO> getStories();
	public StoryVO getStory(String id);
	public int writeStory(StoryVO story);
	public void deleteStory(String id);
	public void updateHitCount(String id);
	public int updateLikeCount(String id);
	
}
