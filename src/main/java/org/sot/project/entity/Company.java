package org.sot.project.entity;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

/**
 * @description:
 * @author:maidang
 * @date:2021/10/30
 **/
@ApiModel(value = "机构实体", description = "User Entity")
@FieldDefaults(level = AccessLevel.PUBLIC)
public class Company extends User{

}
