package net.gondor.story.biz;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.gondor.story.vo.StoryVO;


public interface StoryBiz {
	public List<StoryVO> getStories();
	public StoryVO getStory(String id, HttpServletRequest request);
	public boolean writeStory(StoryVO story, HttpServletRequest request);
	public void deleteStory(String id);
	public boolean updateLikeCount(String id);
	
}
