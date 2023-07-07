package com.springboot101;


import com.springboot101.domain.OrderContext;
import com.springboot101.manager.OrderHandleManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class ChainTest {

    @Autowired
    private OrderHandleManager orderHandleManager;

    @Test
    public void test(){
        boolean execute = orderHandleManager.execute(new OrderContext());
        System.out.println(execute);
    }
}