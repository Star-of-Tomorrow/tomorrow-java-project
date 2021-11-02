package org.sot.project.entity.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户类型，分为个人和机构
 */
@Data
@ApiModel(value = "用户实体", description = "User Entity")
public class User implements Serializable {

    private static final long serialVersionUID = 5057954049311281252L;

    @ApiModelProperty(value = "用户账号", required = true)
    String userId;

    @ApiModelProperty(value = "用户密码", required = true)
    String password;

    @ApiModelProperty(value = "用户名字", required = true)
    String userName;

    @ApiModelProperty(value = "用户头像", required = true)
    String userPicUrl;

    @ApiModelProperty(value = "用户类型", required = true)
    String type;
}

