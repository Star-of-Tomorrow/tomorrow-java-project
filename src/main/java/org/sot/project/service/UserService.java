package org.sot.project.service;

import org.sot.project.dao.dataobject.UserBaseDO;
import org.sot.project.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author ShiDu
 * @date 2021/11/1 5:03 下午
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public UserBaseDO getUserByUserId(String userId) {
		Optional<UserBaseDO> byId = userRepository.findById(userId);
		return byId.get();
	}

	public UserBaseDO getUserByOpenId(String openId){
		UserBaseDO byOpenId = userRepository.findByOpenId(openId);
		return byOpenId;
	}

	public UserBaseDO saveUserBO(UserBaseDO userBaseDO){
		UserBaseDO save = userRepository.save(userBaseDO);
		return save;
	}


}
