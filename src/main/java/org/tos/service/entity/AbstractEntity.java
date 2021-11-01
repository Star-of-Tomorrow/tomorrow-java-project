package org.tos.service.entity;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @description:
 * @author:maidang
 * @date:2021/10/30
 **/
@Data
@FieldDefaults(level = AccessLevel.PUBLIC)
public class AbstractEntity implements Serializable {

    private static final long serialVersionUID = -7699896288620589279L;

    String id;
}
