package com.base.sys.rpc.service.impl;

import com.base.api.rpc.api.PayTypeService;
import com.base.sys.dao.mapper.PayTypeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* PayTypeService实现
* Created by  on 2018/3/4.
*/
@Service
@Transactional
public class PayTypeServiceImpl  implements PayTypeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PayTypeServiceImpl.class);

    @Autowired
    PayTypeMapper payTypeMapper;

}