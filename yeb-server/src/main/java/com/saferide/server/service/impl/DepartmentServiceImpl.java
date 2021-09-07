package com.saferide.server.service.impl;

import com.saferide.server.mapper.DepartmentMapper;
import com.saferide.server.pojo.Department;
import com.saferide.server.service.IDepartmentService;
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
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

}
