package com.iain.springdemo.service.impl;

import com.iain.springdemo.domain.PdtInfo;
import com.iain.springdemo.mapper.PdtInfoMapper;
import com.iain.springdemo.service.PdtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname pdtServiceImpl
 * @Description TODO
 * @Date 2020/8/26 1:13 下午
 * @Created by wht
 */
@Service
public class PdtServiceImpl implements PdtService {
    @Autowired
    PdtInfoMapper pdtInfoMapper;

    public List<PdtInfo> findAll() {
        List<PdtInfo> pdtInfos = pdtInfoMapper.findAll();
        PdtInfo pdtInfo = pdtInfos.get(0);
        pdtInfo.toString();
        return pdtInfos;
    }

}
