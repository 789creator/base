package com.base.sys.rpc.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.base.sys.dao.mapper.UpmsLogMapper;
import com.base.sys.dao.model.UpmsLog;
import com.base.sys.rpc.api.service.IUpmsLogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志 服务实现类
 * </p>
 *
 * @author zhj
 * @since 2018-03-11
 */
@Service
public class UpmsLogServiceImpl extends ServiceImpl<UpmsLogMapper, UpmsLog> implements IUpmsLogService {

}
