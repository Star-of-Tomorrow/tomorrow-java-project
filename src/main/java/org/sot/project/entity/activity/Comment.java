package org.sot.project.entity.activity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
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
@ApiModel(value = "评论DTO", description = "评论DTO")
@FieldDefaults(level = AccessLevel.PUBLIC)
public class Comment {

    @ApiModelProperty(value = "评论内容", required = true)
    private String content;

    @ApiModelProperty(value = "类型  评论:comment   \t 活动进展:progress", required = true)
    private String type;

    @ApiModelProperty(value = "图片picList", required = true)
    private List<String> urls;

    @ApiModelProperty(value = "评论人", required = true)
    private String userId;

    @ApiModelProperty(value = "被评论的信息Id", required = true)
    private String informationId;

}
