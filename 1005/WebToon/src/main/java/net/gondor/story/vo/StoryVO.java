package net.gondor.story.vo;
/**
 * STORY_ID, WEBTOON_ID, MANAGER_ID_,
 * STORY_TITLE, STORY_CONT, CRT_DT,
 * HIT_CNT, LIKE_CNT
 * @author Lee
 *
 */
public class StoryVO {
	private int hitCount;
	private int likeCount;
	private String id;
	private String webtoonId;
	private String managerId;
	private String title;
	private String content;
	private String createdDate;
	public int getHitCount() {
		return hitCount;
	}
	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWebtoonId() {
		return webtoonId;
	}
	public void setWebtoonId(String webtoonId) {
		this.webtoonId = webtoonId;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
	
}
