package org.sot.project.dao.mapper;

import java.util.List;
import org.sot.project.dao.dataobject.UserLikeDO;

/**
 * @author Timing
 * @date 2021/11/3 2:29 下午
 */
public interface UserLikeMapper {

	int saveUserLike(UserLikeDO userLikeDO);

	int deleteUserLike(UserLikeDO userLikeDO);

	List<UserLikeDO> queryUserLikeByUserId(String userId);
}
