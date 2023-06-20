package com.shardingsphere_101.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 订单实体类
 *
 * @author Jiahai
 */
@Accessors(chain = true)
@Entity
@Table(name = "t_order")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {
    /**
     * 订单ID
     */
    @Id
    private Long orderId;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}