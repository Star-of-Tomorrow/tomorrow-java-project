package org.sot.project.service;
import java.util.Date;

import org.sot.project.controller.dto.UserDTO;
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
		UserBaseDO userBaseDO = userRepository.findByUserId(userId);
		return userBaseDO;
	}

	public UserBaseDO getUserByOpenId(String openId){
		UserBaseDO byOpenId = userRepository.findByOpenId(openId);
		return byOpenId;
	}

	public UserBaseDO saveUserBO(UserBaseDO userBaseDO){
		UserBaseDO save = userRepository.save(userBaseDO);
		return save;
	}

	public void deleteUserByUserId(String userId){
		userRepository.deleteByUserId(userId);
	}

	public static UserDTO userBaseDO2UserDTO(UserBaseDO userBaseDO){
		UserDTO userDTO= new UserDTO();
		userDTO.setUserId(userBaseDO.getUserId());
		userDTO.setOpenId(userBaseDO.getOpenId());
		userDTO.setUnionId(userBaseDO.getUnionId());
		userDTO.setUserName(userBaseDO.getUserName());
		userDTO.setUserPicUrl(userBaseDO.getUserPicUrl());
		userDTO.setType(userBaseDO.getType());
		userDTO.setInstitutionsName(userDTO.getInstitutionsName());
		userDTO.setId(userBaseDO.getId());
		userDTO.setCreateTime(userBaseDO.getCreateTime());
		userDTO.setUpdateTime(userBaseDO.getUpdateTime());
		return userDTO;
	}

	public static UserBaseDO userDTO2UserBaseDO(UserDTO userDTO) {
		UserBaseDO userBaseDO = new UserBaseDO();
		userBaseDO.setUserId(userDTO.getUserId());
		userBaseDO.setOpenId(userDTO.getOpenId());
		userBaseDO.setUnionId(userDTO.getUnionId());
		userBaseDO.setUserName(userDTO.getUserName());
		userBaseDO.setUserPicUrl(userDTO.getUserPicUrl());
		userBaseDO.setType(userDTO.getType());
		userBaseDO.setInstitutionsName(userDTO.getInstitutionsName());
		userBaseDO.setId(userDTO.getId());
		userBaseDO.setUpdateTime(new Date());
		return userBaseDO;
	}


}
