package org.sot.project.entity.activity;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * @description:
 * @author:maidang
 * @date:2021/10/30
 **/
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "信息实体", description = "Information Entity")
@FieldDefaults(level = AccessLevel.PUBLIC)
public class Information{
    @ApiModelProperty(value = "信息类型", required = true)
    String type;
    @ApiModelProperty(value = "信息描述", required = true)
    String description;
    @ApiModelProperty(value = "图片地址", required = true)
    List<String> picUrls;
    @ApiModelProperty(value = "用户Id", required = true)
    String userId;
    @ApiModelProperty(value = "用户名字", required = true)
    String userName;
    @ApiModelProperty(value = "用户头像", required = true)
    String userPicUrl;

}
