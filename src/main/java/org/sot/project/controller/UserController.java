package org.sot.project.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.annotation.Resource;

import org.sot.project.Utils.WxUtil;
import org.sot.project.Vo.UserVo;
import org.sot.project.common.ApiResponse;
import org.sot.project.common.ParamType;
import org.sot.project.controller.dto.UserDTO;
import org.sot.project.dao.dataobject.InstitutionsDO;
import org.sot.project.dao.dataobject.UserBaseDO;
import org.sot.project.dao.repository.InstitutionRepository;
import org.sot.project.dao.repository.UserRepository;
import org.sot.project.entity.UserTypeEnum;
import org.sot.project.entity.user.User;
import org.sot.project.common.DataType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.sot.project.service.UserService;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * User Controller
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-11-29 11:30
 */
@RestController
@RequestMapping("/user")
@Api(tags = "1.0.0-SNAPSHOT", description = "用户管理", value = "用户管理")
@Slf4j
public class UserController {

    @Resource
    UserService userService;

    @Resource
    InstitutionRepository institutionRepository;

    @Resource
    UserRepository userRepository;

    @GetMapping
    @ApiOperation(value = "用户登录", notes = "备注")
    @ApiImplicitParams({@ApiImplicitParam(name = "account", value = "用户名", dataType = DataType.STRING, paramType = ParamType.QUERY, defaultValue = "xxx"),@ApiImplicitParam(name = "password", value = "用户密码", dataType = DataType.STRING, paramType = ParamType.QUERY, defaultValue = "xxx")})
    public ApiResponse<User> login(String account,String password) {
        return ApiResponse.<User>builder().code(200).message("操作成功").data(null).build();
    }

    @GetMapping("/{userId}")
    @ApiOperation(value = "用户信息查询", notes = "用户主键")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "用户编号", dataType = DataType.INT, paramType = ParamType.PATH)})
    public ApiResponse<UserDTO> get(@PathVariable String userId) {
        UserBaseDO userBaseDO = userService.getUserByUserId(userId);
        if(Objects.isNull(userBaseDO)){
            return ApiResponse.<UserDTO>builder().code(400).message("查询用户信息失败").data(null).build();
        }
        UserDTO result = userService.userBaseDO2UserDTO(userBaseDO);
        return ApiResponse.<UserDTO>builder().code(200).message("操作成功").data(result).build();
    }

    @DeleteMapping("/{userId}")
    @ApiOperation(value = "用户注销", notes = "用户主键")
    @ApiImplicitParam(name = "id", value = "用户编号", dataType = DataType.INT, paramType = ParamType.PATH)
    public boolean delete(@PathVariable String userId) {
        log.info("userId is {}",userId);
        userService.deleteUserByUserId(userId);
        return true;
    }

    @PostMapping("/wx/login")
    @ResponseBody
    @ApiImplicitParam(name = "", value = "用户编号", dataType = DataType.INT, paramType = ParamType.PATH)
    public ApiResponse<UserDTO> userLogin(@RequestParam String code) {
        JSONObject SessionKeyOpenId = WxUtil.getSessionKeyOrOpenId(code);
        log.info("登录用户user信息:{},",SessionKeyOpenId);
        String openid = SessionKeyOpenId.getString("openid");
        String sessionKey = SessionKeyOpenId.getString("session_key");
        String unionId = SessionKeyOpenId.getString("unionId");
        UserBaseDO result;
        UserDTO userDTOResult;
        UserBaseDO userBaseDO = userService.getUserByOpenId(openid);
        if (userBaseDO == null) {
            // 用户信息入库
            UserBaseDO newBaseDo = new UserBaseDO();
            newBaseDo.init();
            newBaseDo.setOpenId(openid);
            newBaseDo.setUnionId(unionId);
            newBaseDo.setType(UserTypeEnum.ACTIVITY.getTypeCode());
            result = userService.saveUserBO(newBaseDo);
        } else {
            result= userBaseDO;
        }
        userDTOResult = userService.userBaseDO2UserDTO(result);
        //6. 把新的skey返回给小程序
        log.info("登录用户user信息:{},",userDTOResult);
        return ApiResponse.<UserDTO>builder().code(200).message("操作成功").data(userDTOResult).build();
    }


    @PostMapping("/userInformation")
    @ResponseBody
    @ApiOperation(value = "用户信息补全", notes = "")
    public ApiResponse<UserDTO> userInfomation(@RequestBody UserDTO userDTO) {
        log.info("登录用户user信息:{},",JSON.toJSONString(userDTO));
        UserBaseDO userBaseDO = userService.userDTO2UserBaseDO(userDTO);
        UserBaseDO userBaseDO1 = userService.saveUserBO(userBaseDO);
        UserDTO userDTO1 = userService.userBaseDO2UserDTO(userBaseDO1);
        log.info("登录用户user信息:{},",userDTO1);
        if (userDTO1 == null) {
            return ApiResponse.<UserDTO>builder().code(400).message("操作失败").data(userDTO1).build();
        }
        return ApiResponse.<UserDTO>builder().code(200).message("操作成功").data(userDTO1).build();
    }

    @GetMapping("/getUserInstitutions")
    @ResponseBody
    @ApiOperation(value = "获取用户机构信息", notes = "返回机构Code")
    public ApiResponse<String> getUserInstitutions(@RequestParam String userId) {
        return WebUtils.process(()->userRepository.findByUserId(userId).getType());
    }

    @GetMapping("/getInstitutions")
    @ResponseBody
    @ApiOperation(value = "获取机构信息", notes = "")
    public ApiResponse<InstitutionsDO> getInstitutions(@RequestParam String institutionId) {
        return WebUtils.process(()->institutionRepository.findByInstitutionsId(institutionId));
    }
}
