package com.dao;

import com.model.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xugenli on 2017/3/9.
 */
@Repository
public interface AccountDao {
    List<Account> findAllAccount();
    int insertAccount(Account account);
    //如果传递多个参数，要么使用@Param注解，要么在xml中使用{0} {1}
    List<Account> findAccountsById(@Param("beginId") int beginId, @Param("endId") int endId);
    int updateAccount(Account account);
    int deleteAccount(Integer id);
}
