package com.our.repository.mapper;

import com.our.repository.entity.Sys;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yz
 * @since 2020-08-23
 */
public interface SysMapper extends BaseMapper<Sys> {

    List<Sys> getAllSys();
}
