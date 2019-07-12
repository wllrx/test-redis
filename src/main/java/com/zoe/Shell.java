package com.zoe;

import cn.gjing.lock.AbstractLock;
import cn.gjing.lock.AbstractLockTimeoutHandler;
import cn.gjing.lock.TimeoutException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @ClassName : Shell
 * @Author : zoe
 * @Date : 2019/6/25 22:55
 */
@Service
@Component
public class Shell {

    @Resource
    private AbstractLock abstractLock;

    private static int num = 20;

    // @Lock(key = "test",timeout = 1000,expire = 12,retry = 500)

    public void test() {
        String lock = abstractLock.lock("test", "1111", 100, 30, 500);
        for (int i = 0; i < 30; i++) {
            if (num == 0) {
                System.out.println("卖完了");
                return;
            }
            num--;
            System.out.println("还剩余: " + num);
            String release = abstractLock.release("test", lock);
            if (release != null) {
                System.out.println("锁释放成功" + release);
                return;
            }
            System.out.println("锁释放失败");
        }
    }

   /* @Override
    public ResponseEntity timeoutAfter(TimeoutException e) {
        return ResponseEntity.badRequest().body("库存不足");
    }*/
}
