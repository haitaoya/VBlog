package com.iain.blog.service.impl;

import com.iain.blog.mapper.PdtInfoMapper;
import com.iain.blog.domain.PdtInfo;
import com.iain.blog.service.PdtService;
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
