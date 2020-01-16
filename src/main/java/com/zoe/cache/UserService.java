package com.zoe.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zoe
 **/
@Service
@Slf4j
public class UserService {

    @Resource
    private UserRepository userRepository;

    /**
     * 保存用户
     *
     * @param i 数
     */
    public void saveUser(Integer i) {
        User user = User.builder()
                .account("账户"+i)
                .accountPassword("111111")
                .userPhone("123456789")
                .userName("用户" + i)
                .build();
        userRepository.save(user);
    }


    /**
     * 查询用户列表
     *
     * @return 用户列表
     */
    @Cacheable(value = "user",key = "#id")
    public List<User> userList(Long id, String userName) {
        log.info("进入userList方法......................");
        return userRepository.findByUserNameLike(userName);
    }


    @CacheEvict(value = "user",key = "#id")
    public void deleteUser(Long id){
        log.info("清除缓存.........");
    }
}
