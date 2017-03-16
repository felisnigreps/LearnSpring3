package com.dao;

import com.model.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xugenli on 2017/3/9.
 */
@Repository
public interface AccountDao {
    List<Account> findAllAccount();
    int insertAccount(Account account);
    List<Account> findAccountsById(int beginId,int endId);


}
