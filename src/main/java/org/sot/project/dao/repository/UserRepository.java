package org.sot.project.dao.repository;

import org.sot.project.dao.dataobject.UserBaseDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author:maidang
 * @date:2021/11/04
 **/
@Repository
public interface UserRepository extends JpaRepository<UserBaseDO, String> {

	UserBaseDO findByOpenId(String openId);

	UserBaseDO findByUserId(String userId);

	void deleteByUserId(String userId);
}
