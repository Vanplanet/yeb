package com.saferide.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.saferide.server.config.security.JwtTokenUtil;
import com.saferide.server.mapper.AdminMapper;
import com.saferide.server.pojo.Admin;
import com.saferide.server.pojo.RespBean;
import com.saferide.server.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author saferide
 * @since 2021-09-07
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;                  //加密密码工具
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private AdminMapper adminMapper;
    /**
     * 登录之后返回token
     * @param username
     * @param password
     * @param request
     * @return
     */
    @Override
    public RespBean login(String username, String password, HttpServletRequest request) {
        /**
         * 登录
         */
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if(userDetails == null || !passwordEncoder.matches(password,userDetails.getPassword())){
            return RespBean.error("用户名或密码不正确");
        }
        if(!userDetails.isEnabled()){           //账号是否禁用
            return RespBean.error("账号被禁用");
        }

        /**
         * 更新security登录用户对象
         */
        UsernamePasswordAuthenticationToken authenticationToken = new
                UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());         //获取token

        /**
         * 生成token
         */
        String token = jwtTokenUtil.generateToken(userDetails);     //用户正确，生成token
        Map<String,String> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenHead);        //放入头部信息
        return RespBean.success("登录成功",tokenMap);
    }

    /**
     * 获取当前登录用户
     * @param username
     * @return
     */
    @Override
    public Admin getAdminByUserName(String username) {
        return adminMapper.selectOne            //查询一条
                (new QueryWrapper<Admin>()      //新建一个类型为Admin的QueryWrapper实体对象
                .eq("username",username)
                .eq("enabled",true));
    }
}

