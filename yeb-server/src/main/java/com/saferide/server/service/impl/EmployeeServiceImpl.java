package com.saferide.server.service.impl;

import com.saferide.server.mapper.EmployeeMapper;
import com.saferide.server.pojo.Employee;
import com.saferide.server.service.IEmployeeService;
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
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
