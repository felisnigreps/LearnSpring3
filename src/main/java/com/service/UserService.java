package com.service;

import com.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xugenli on 2017/3/9.
 */
@Service
public interface UserService {
    List<Account> findAllAccount();
    int insertAccount(Account account);
    List<Account> findAccounts(int beginId, int endId);
}
