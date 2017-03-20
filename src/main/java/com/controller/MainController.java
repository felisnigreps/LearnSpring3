package com.controller;

import com.model.Account;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by xugenli on 2017/3/8.
 */
@Controller
@Service
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
    public String findAllAccount(ModelMap modelMap) {
        List<Account> allAccount = userService.findAllAccount();
        modelMap.addAttribute("allAccount", allAccount);
        return "userAccount";
    }


    // 根据id查询账户
    //@PathVariable为空的先不深究,判断为空前台先传参代替
    @RequestMapping(value = {"/findAccounts/{beginId}/{endId}"})
    public String findAccounts(@PathVariable("beginId") Integer beginId, @PathVariable("endId") Integer endId, ModelMap ModelMap) {
        List<Account> allAccount = userService.findAccounts(beginId, endId);
        System.out.println("------find account------");
        for (Account a : allAccount) {
            System.out.println(a.getId() + a.getName() + a.getMoney());
        }
        ModelMap.addAttribute("allAccount", allAccount);
        return "userAccount";
    }

    // 新增账户
    @RequestMapping(value = "/insert")
    //前台传入json字符串，这边可以直接接收，不需要对参数进行获取
    //数据库来进行id的自增长
    //ResponseBody返回字符串，RequestBody来进行对象的转型
    @ResponseBody
    public String insert(@RequestBody Account account, ModelMap modelMap) {
        System.out.println("------insert account------");
        System.out.println(account.getId() + account.getName() + account.getMoney());
        userService.insertAccount(account);
        List<Account> allAccount = userService.findAllAccount();
        modelMap.addAttribute("allAccount", allAccount);
        return "userAccount";
    }

    //更改账户
    @RequestMapping("/update")
    public String update(@RequestBody Account account, ModelMap modelMap) {
        System.out.println("------update account------");
        System.out.println(account.getId() + account.getName() + account.getMoney());
        userService.updateAccount(account);
        List<Account> allAccount = userService.findAllAccount();
        modelMap.addAttribute("allAccount", allAccount);
        return "userAccount";
    }


    //删除账户
    @RequestMapping(value = {"/delete/{id}"})
    public String findAccounts(@PathVariable("id") Integer id, ModelMap ModelMap) {
        System.out.println("------delete account begin------");
        userService.deleteAccount(id);
        List<Account> allAccount = userService.findAllAccount();
        ModelMap.addAttribute("allAccount", allAccount);
        return "userAccount";
    }

}
