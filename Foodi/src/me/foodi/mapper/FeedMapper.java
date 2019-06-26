package me.foodi.mapper;

import java.util.List;

import me.foodi.domain.FeedVO;
import me.foodi.domain.ReplyVO;
import me.foodi.domain.UserAndFeedVO;

public interface FeedMapper {
	int insertFeed(FeedVO feedVO);
	int getFeedNo(FeedVO feedVO);
	List<UserAndFeedVO> listTagFeed(String tagName);

	List<UserAndFeedVO> listNewsFeed(FeedVO feedVO);
	List<ReplyVO> feedReplyGet(int feedNo);
	int feedReplyInsert(ReplyVO replyVO);
	UserAndFeedVO newsfeedDetail(FeedVO feeVO);
	FeedVO callFeed(int feedNo);
	int modifyFeed(FeedVO feedVO);
}
