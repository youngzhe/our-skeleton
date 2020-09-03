package com.our.repository.service;

import com.our.repository.entity.Sys;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yz
 * @since 2020-08-23
 */
public interface SysService extends IService<Sys> {

    List<Sys> getAllSys();
}
