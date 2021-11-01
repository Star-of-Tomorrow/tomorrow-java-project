package org.sot.project.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 用户实体
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-11-29 11:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "用户实体", description = "User Entity")
public class User extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 5057954049311281252L;

    @ApiModelProperty(value = "用户账号", required = true)
    String account;

    @ApiModelProperty(value = "用户密码", required = true)
    String password;

    @ApiModelProperty(value = "用户名字", required = true)
    String userName;

    @ApiModelProperty(value = "用户头像", required = true)
    String userPicUrl;

    @ApiModelProperty(value = "用户类型", required = true)
    String type;
}

