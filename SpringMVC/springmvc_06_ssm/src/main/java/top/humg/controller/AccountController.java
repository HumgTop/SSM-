package top.humg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.humg.domain.Account;
import top.humg.service.AccountService;

import java.util.List;

/**
 * 账户web层
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/test1")
    public String test1(Model model) {
        System.out.println("这是个controller方法");
        List<Account> all = accountService.findAll();
        //将集合存入request域中
        model.addAttribute("list", all);
        return "success";
    }

    @RequestMapping("/save")
    public String save(Account account) {
        accountService.saveAccount(account);
        System.out.println("保存成功");
        return "success";
    }
}
