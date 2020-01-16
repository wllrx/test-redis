package com.zoe;

import cn.gjing.lock.core.EnableRedisLock;
import com.onesports.framework.wolf.cache.core.EnableOneSportsCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRedisLock
@EnableOneSportsCache
//@EnableCaching
public class TestRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestRedisApplication.class, args);
    }

}
