package org.sot.project.entity.activity;

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
@ApiModel(value = "评论实体", description = "Comment Entity")
@FieldDefaults(level = AccessLevel.PUBLIC)
public class Comment {

    @ApiModelProperty(value = "评论内容", required = true)
    String content;

}