package com.service.impl;

import com.dao.AccountDao;
import com.model.Account;
import com.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xugenli on 2017/3/9.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private AccountDao accountDao;

    public List<Account> findAllAccount() {

        return accountDao.findAllAccount();
    }

    public int insertAccount(Account account) {
         return accountDao.insertAccount(account);
    }

    public List<Account> findAccounts(int beginId, int endId) {
        return accountDao.findAccountsById(beginId,endId);
    }

    @Override
    public int updateAccount(Account account) {
        return accountDao.updateAccount(account);
    }

    @Override
    public int deleteAccount(Integer id) {
        return accountDao.deleteAccount(id);
    }
}
