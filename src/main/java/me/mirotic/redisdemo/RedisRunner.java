package me.mirotic.redisdemo;

import lombok.RequiredArgsConstructor;
import me.mirotic.redisdemo.account.Account;
import me.mirotic.redisdemo.account.AccountRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RedisRunner implements ApplicationRunner {

    final StringRedisTemplate redisTemplate;

    final AccountRepository accountRepository;

    @Override
    public void run(ApplicationArguments args) {
        ValueOperations<String, String> values = redisTemplate.opsForValue();
        values.set("england", "london");
        values.set("spain", "madrid");
        values.set("france", "paris");

        saveAccount();
    }

    private void saveAccount() {
        Account account = new Account();
        account.setUsername("jupark");
        account.setEmail("test@gmail.com");

        Account savedAccount = accountRepository.save(account);

        Optional<Account> findAccount = accountRepository.findById(savedAccount.getId());
        if (findAccount.isPresent()) {
            System.out.println(findAccount.get().getUsername());
            System.out.println(findAccount.get().getEmail());
        }
    }

}
