package org.sot.project.controller;

import javax.annotation.Resource;
import org.sot.project.common.ApiResponse;
import org.sot.project.common.ParamType;
import org.sot.project.entity.user.User;
import org.sot.project.common.DataType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.sot.project.service.UserService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    @ApiOperation(value = "用户登录", notes = "备注")
    @ApiImplicitParams({@ApiImplicitParam(name = "account", value = "用户名", dataType = DataType.STRING, paramType = ParamType.QUERY, defaultValue = "xxx"),@ApiImplicitParam(name = "password", value = "用户密码", dataType = DataType.STRING, paramType = ParamType.QUERY, defaultValue = "xxx")})
    public ApiResponse<User> login(String account,String password) {
        return WebUtils.process(()->userService.LoginService(account,password));
    }

    @GetMapping("/{userId}")
    @ApiOperation(value = "用户信息查询", notes = "用户主键")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "用户编号", dataType = DataType.INT, paramType = ParamType.PATH)})
    public ApiResponse<User> get(@PathVariable String userId) {
        return ApiResponse.<User>builder().code(200).message("操作成功").data(new User()).build();
    }

    @DeleteMapping("/{userId}")
    @ApiOperation(value = "用户注销", notes = "用户主键")
    @ApiImplicitParam(name = "id", value = "用户编号", dataType = DataType.INT, paramType = ParamType.PATH)
    public boolean delete(@PathVariable String userId) {
        log.info("单个参数用 ApiImplicitParam");
        return true;
    }



//    @PostMapping
//    @ApiOperation(value = "用户登录")
//    public User post(@RequestBody User user) {
//        log.info("如果是 POST PUT 这种带 @RequestBody 的可以不用写 @ApiImplicitParam");
//        return user;
//    }
//
//    @PostMapping("/multipar")
//    @ApiOperation(value = "添加用户（DONE）")
//    public List<User> multipar(@RequestBody List<User> user) {
//        log.info("如果是 POST PUT 这种带 @RequestBody 的可以不用写 @ApiImplicitParam");
//
//        return user;
//    }
//
//    @PostMapping("/array")
//    @ApiOperation(value = "添加用户（DONE）")
//    public User[] array(@RequestBody User[] user) {
//        log.info("如果是 POST PUT 这种带 @RequestBody 的可以不用写 @ApiImplicitParam");
//        return user;
//    }
//
//    @PutMapping("/{id}")
//    @ApiOperation(value = "修改用户（DONE）")
//    public void put(@PathVariable Long id, @RequestBody User user) {
//        log.info("如果你不想写 @ApiImplicitParam 那么 swagger 也会使用默认的参数名作为描述信息 ");
//    }
//
//    @PostMapping("/{id}/file")
//    @ApiOperation(value = "文件上传（DONE）")
//    public String file(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
//        log.info(file.getContentType());
//        log.info(file.getName());
//        log.info(file.getOriginalFilename());
//        return file.getOriginalFilename();
//    }
//
//    @PostMapping
//    @ApiOperation(value = "用户登录")
//    public void 登录(){
//
//    }
}
