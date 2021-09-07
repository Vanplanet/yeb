package com.saferide.server.service.impl;

import com.saferide.server.mapper.RoleMapper;
import com.saferide.server.pojo.Role;
import com.saferide.server.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author saferide
 * @since 2021-09-07
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
