package me.mirotic.redisdemo.account;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("accounts")
@Getter
@Setter
public class Account {

    @Id
    private Long id;

    private String username;

    private String email;

}