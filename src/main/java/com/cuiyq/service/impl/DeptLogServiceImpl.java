package com.cuiyq.service.impl;

import com.cuiyq.domain.DeptLog;
import com.cuiyq.mapper.DeptLogMapper;
import com.cuiyq.service.DeptLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @version V1.0
 * @Title:
 * @Description: 操作记录日志
 * @Copyright 2024 Cuiyq
 * @author: Cuiyq
 * @date: 2025/3/18 16:39
 */
@Service
public class DeptLogServiceImpl implements DeptLogService {
    @Resource
    private DeptLogMapper deptLogMapper;
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insert(DeptLog deptLog) {
        deptLogMapper.insert(deptLog);
    }
}
