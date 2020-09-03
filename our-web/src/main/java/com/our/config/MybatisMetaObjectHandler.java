/**
 * Copyright (C), 2015-2020
 * FileName: MybatisMetaObjectHandler
 * Author:   yangz
 * Date:     2020/8/23 15:04
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.our.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import java.util.Date;

/**
 * mybatis-plus的create_time update_time的填充设置
 */
@Component
public class  MybatisMetaObjectHandler implements MetaObjectHandler  {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.setInsertFieldValByName("createTime", new Date(),metaObject);
        // 或者
        this.setInsertFieldValByName("updateTime", new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setUpdateFieldValByName( "updateTime", new Date(),metaObject);

    }
}
