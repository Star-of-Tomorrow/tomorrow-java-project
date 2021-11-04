package org.sot.project.dao.mapper;

import java.util.List;
import org.sot.project.dao.dataobject.CommentDO;

/**
 * @author ShiDu
 * @date 2021/11/2 10:25 上午
 */
public interface CommentDAO {

	int insertComment(CommentDO commentDO);

	List<CommentDO> queryCommentSByUserId(String userId);
}
