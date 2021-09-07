package com.saferide.server.service.impl;

import com.saferide.server.mapper.AdminMapper;
import com.saferide.server.pojo.Admin;
import com.saferide.server.service.IAdminService;
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
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

}
