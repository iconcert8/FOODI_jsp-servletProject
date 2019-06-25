package me.foodi.DAO;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import me.foodi.domain.FeedVO;
import me.foodi.domain.ReplyVO;
import me.foodi.domain.UserAndFeedVO;
import me.foodi.mapper.FeedMapper;

public class FeedDAO {
	private static FeedDAO dao = new FeedDAO();

	public static FeedDAO getInstance() {
		return dao;
	}

	public SqlSessionFactory getSqlsessionFactory() {
		String config = "me/foodi/persistence/mybatis-config.xml";
		InputStream in = null;

		try {
			in = Resources.getResourceAsStream(config);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new SqlSessionFactoryBuilder().build(in);
	}

	public int insertFeed(FeedVO feedVO) {
		SqlSession sqlSession = getSqlsessionFactory().openSession();
		int re = -1;
		int feedNo = 0;
		try {
			re = sqlSession.getMapper(FeedMapper.class).insertFeed(feedVO);
			if (re > 0) {
				sqlSession.commit();
				feedNo = sqlSession.getMapper(FeedMapper.class).getFeedNo(feedVO);
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return feedNo;
	}

	public List<UserAndFeedVO> listTagFeed(String tagName) {
		List<UserAndFeedVO> list = null;
		SqlSession sqlSession = getSqlsessionFactory().openSession();

		try {
			list = sqlSession.getMapper(FeedMapper.class).listTagFeed(tagName);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return list;
	}

	public List<UserAndFeedVO> newsFeedList(FeedVO feedVO) {
		List<UserAndFeedVO> list = null;
		SqlSession session = getSqlsessionFactory().openSession();

		try {
			list = session.getMapper(FeedMapper.class).listNewsFeed(feedVO);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;

	}

	public List<ReplyVO> feedReplyGet(int feedNo) {
		List<ReplyVO> list = null;
		SqlSession session = getSqlsessionFactory().openSession();

		try {
			list = session.getMapper(FeedMapper.class).feedReplyGet(feedNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;
	}

	public int feedReplyInsert(ReplyVO replyVO) {
		int re = -1;
		SqlSession session = getSqlsessionFactory().openSession();

		try {
			re = session.getMapper(FeedMapper.class).feedReplyInsert(replyVO);
			if (re > 0) {
				session.commit();
			} else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return re;
	}

	public UserAndFeedVO detailNewsFeed(FeedVO feedVO) {
		UserAndFeedVO userAndFeedVO = null;
		SqlSession session = getSqlsessionFactory().openSession();

		try {
			userAndFeedVO = session.getMapper(FeedMapper.class).newsfeedDetail(feedVO);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return userAndFeedVO;
	}

	public FeedVO callFeed(int feedNo) {
		FeedVO feedVO = new FeedVO();
		SqlSession sqlSession = getSqlsessionFactory().openSession();

		try {
			feedVO = sqlSession.getMapper(FeedMapper.class).callFeed(feedNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return feedVO;
	}
}