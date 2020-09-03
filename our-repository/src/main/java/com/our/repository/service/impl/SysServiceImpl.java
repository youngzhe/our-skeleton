package com.our.repository.service.impl;

import com.our.repository.entity.Sys;
import com.our.repository.mapper.SysMapper;
import com.our.repository.service.SysService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yz
 * @since 2020-08-23
 */
@Service
public class SysServiceImpl extends ServiceImpl<SysMapper, Sys> implements SysService {

    @Resource
    private SysMapper sysMapper;


    @Override
    public List<Sys> getAllSys() {
//        throw new BusinessException();

//        int a=10;
//        int b= 10/0;
    return sysMapper.getAllSys();
    }
}
