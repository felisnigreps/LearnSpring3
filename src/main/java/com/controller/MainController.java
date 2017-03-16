package com.controller;

import com.model.Account;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by xugenli on 2017/3/8.
 */
@Controller
public class MainController {

    @Autowired
    private UserService userService;

    // 首页
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    //查询所有用户的信息
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAllUserMoney(ModelMap ModelMap) {
        List<Account> allAccount = userService.findAllAccount();
        ModelMap.addAttribute("allAccount", allAccount);
        return "userAccount";
    }


    // 根据id查询账户
    @RequestMapping(value = "/findAccounts", method = RequestMethod.POST)
    @ResponseBody
    public String findAccounts(int beginId, int endId) {
        System.out.println(beginId+endId);
        ModelMap modelMap = new ModelMap();
        List<Account> accounts = userService.findAccounts(beginId, endId);
        modelMap.addAttribute("accounts");
        return "userAccount";
    }

    // 新增账户
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    //前台传入json字符串，这边可以直接接收，不需要对参数进行获取
    //数据库来进行id的自增长
    @ResponseBody
    public int insert(@RequestBody Account account) {
        userService.insertAccount(account);
        //取得插入的主键
        return account.getId();
    }

}
