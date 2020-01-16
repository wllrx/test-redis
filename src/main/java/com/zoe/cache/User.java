package com.zoe.cache;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author zoe
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "test_user")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "account",columnDefinition = "varchar(20)")
    private String account;
    
    @Column(name = "account_password",columnDefinition = "varchar(50)")
    private String accountPassword;

    @Column(name = "user_name",columnDefinition = "varchar(20)")
    private String userName;

    @Column(name = "user_phone",columnDefinition = "varchar(11)")
    private String userPhone;
    
    @CreatedDate
    @Column(name = "create_time", columnDefinition = "timestamp")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @LastModifiedDate
    @Column(name = "update_time", columnDefinition = "timestamp")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;
    
}
