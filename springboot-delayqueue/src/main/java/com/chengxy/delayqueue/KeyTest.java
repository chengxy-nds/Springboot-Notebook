package com.chengxy.delayqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author: xiaofu
 * @Description:
 */
public class KeyTest {
    
    // .var
    
    // .notnull


    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();

        strings.add("牛比快捷键");
        
        strings.add("程序员内点事");

        String s = strings.get(0);

        if (s != null) {

        }
        Optional<String> s1 = Optional.ofNullable(s);

        if (s1.isPresent()) {

        }
    }
}
