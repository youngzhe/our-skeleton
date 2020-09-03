package com.our.repository.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author yz
 * @since 2020-08-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Sys extends Model<Sys> {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    /**
     * 是否可用,1：可用，0不可用
     */
    private String available;

    /**
     * 操作的关联外键
     */
    private Integer operateId;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
