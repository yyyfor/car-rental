package com.siming.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;

import lombok.Data;

/**
 * <p>
 * user table
 * </p>
 *
 * @author siming
 * @since 2023-02-24
 */
@Data
public class User {

    /**
     * primary key id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * user name
     */
    private String name;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
