package com.xiaofu.process;

import com.ulisesbocchio.jasyptspringboot.EncryptablePropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @Auther: 公众号：程序员小富
 * @Date: 2021/7/30 18:35
 * @Description:
 */
public class EnvCopy1 {

    StandardEnvironment copy1;

    public EnvCopy1(final ConfigurableEnvironment environment) {
        copy1 = new StandardEnvironment();
        Optional.ofNullable(environment.getPropertySources()).ifPresent(sources -> sources.forEach(ps -> {
            final PropertySource<?> original = ps instanceof EncryptablePropertySource
                    ? ((EncryptablePropertySource) ps).getDelegate()
                    : ps;
            copy1.getPropertySources().addLast(original);
        }));
    }

    public ConfigurableEnvironment get() {
        return copy1;
    }
}
