package com.saferide.server.controller;

import com.saferide.server.pojo.Admin;
import com.saferide.server.pojo.AdminLoginParam;
import com.saferide.server.pojo.RespBean;
import com.saferide.server.service.IAdminService;
import com.sun.scenario.effect.impl.prism.PrRenderInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * <p>
 *  登录
 * </p>
 *
 * @author saferide
 * @since 2021-09-15
 */
@Api(tags = "LoginController")                      //表明是swagger资源，生成api文档会根据tags分类
@RestController
public class LoginController {

    @Autowired
    private IAdminService adminService;

    @ApiOperation(value = "登录之后返回token")                //添加说明
    @PostMapping("/login")
    public RespBean login(AdminLoginParam adminLoginParam, HttpServletRequest request){
        return adminService.login(adminLoginParam.getUsername(),adminLoginParam.getPassword(),request);
    }

    @ApiOperation(value = "获取当前登录用户信息")
    @GetMapping("admin/info")
    public Admin getAdminInfo(Principal principal){                 //principal参数获取到当前登录对象
        if(principal == null){
            return  null;
        }
        String username = principal.getName();
        Admin admin = adminService.getAdminByUserName(username);    //获取完整用户
        admin.setPassword(null);        //前端不能获取到密码
        return admin;
    }

    @ApiOperation(value = "退出登录")
    @PostMapping("/logout")
    public RespBean logout(){
        return RespBean.success("账户已退出!");
    }
}
