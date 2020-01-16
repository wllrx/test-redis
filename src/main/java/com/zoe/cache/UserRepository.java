package com.zoe.cache;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zoe
 **/
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    /**
     * 根据用户名查询
     * @param userName 用户名
     * @return 用户列表
     */
    List<User> findByUserNameLike(String userName);
}
