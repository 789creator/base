package com.base.sso.core.service;

import com.baomidou.mybatisplus.service.IService;
import com.base.sso.core.model.UpmsSystem;

/**
 * <p>
 * 系统 服务类
 * </p>
 *
 * @author zhj
 * @since 2018-03-11
 */
public interface IUpmsSystemService extends IService<UpmsSystem> {

    UpmsSystem selectUpmsSystemByName(String name);
}
