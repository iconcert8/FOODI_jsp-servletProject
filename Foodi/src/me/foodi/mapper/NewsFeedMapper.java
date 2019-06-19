package me.foodi.mapper;

import java.util.List;

import me.foodi.domain.FeedVO;
import me.foodi.domain.ReplyVO;
import me.foodi.domain.UserInfoVO;
 
public interface NewsFeedMapper {
	
	List<FeedVO> listNewsFeed(FeedVO feedVO);
	
	List<ReplyVO> newsfeedReply(int feedNo);
	
	int insertNewsfeedReply(ReplyVO replyVO);
	
}
  