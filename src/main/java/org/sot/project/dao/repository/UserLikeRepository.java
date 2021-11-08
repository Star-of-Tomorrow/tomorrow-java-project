package org.sot.project.dao.repository;

import java.util.List;
import org.sot.project.dao.dataobject.UserLikeDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Timing
 * @since 2021/11/8 11:20 上午
 */
public interface UserLikeRepository extends JpaRepository<UserLikeDO,String> {

	UserLikeDO save(UserLikeDO userLikeDO);

	int deleteByUserIdAndInformationId(String userId,String informationId);

	List<UserLikeDO> findAllByUserId(String userId);
}
