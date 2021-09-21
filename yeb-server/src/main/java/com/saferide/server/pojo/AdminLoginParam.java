package com.saferide.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户登录实体类
 * </p>
 *
 * @author saferide
 * @since 2021-09-15
 */
@Data                                           //生成 get()、 set()、 toString()等方法
@EqualsAndHashCode(callSuper = false)           //生成equals()和hashCode()方法
@Accessors(chain = true)                        //配置getter和setter方法的生成结果
@ApiModel(value = "AdminLogin对象", description = "")
public class AdminLoginParam {

    @ApiModelProperty(value = "用户名",required = true)
    private String username;
    @ApiModelProperty(value = "密码",required = true)
    private String password;
}
