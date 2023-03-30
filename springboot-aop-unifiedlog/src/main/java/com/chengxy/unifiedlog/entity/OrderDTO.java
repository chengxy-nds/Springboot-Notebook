package com.chengxy.unifiedlog.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @Author: xiaofu
 * @Description:
 */
@Data
public class OrderDTO {

    private String OrderNo;

    private Map<String,Object> OrderMap;

    private List<OrderDTO> OrderList;
}
