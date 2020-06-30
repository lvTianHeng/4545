package com.bysh.cs.smbms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.bysh.cs.smbms.pojo.SysUser;
import com.bysh.cs.smbms.service.ISysUserService;
import com.bysh.cs.smbms.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ISysUserService sysUserService;


    @RequestMapping(value = "/findAll")
    public String findAll(String queryname, String tel,@RequestParam(required = false, defaultValue = "1") int pageIndex, Model model) {
        // 分页
        PageHelper.startPage(pageIndex, Constant.PAGE_SIZE);
        // 调用业务层的方法
        List<SysUser> userList = sysUserService.find(queryname,tel);
        //List<User> userList = userService.find(queryname, queryUserRole);
        // 返回结果数据creationDate
        model.addAttribute("page", new PageInfo<SysUser>(userList));

        return "user/list";
    }

    /**
     * 根据ID删除
     *
     * @param uid ID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public Map delete(Long uid) {
        // 结果集
        Map<String, String> map = new HashMap<>(1);
        // 调用业务层方法，获得删除后的结果
        String result =sysUserService.delete(uid);
        //String result = userService.delete(uid);
        map.put("delResult", result);
        return map;
    }

    /**
     * 根据ID查询用户
     *
     * @param uid   用户ID
     * @param model
     * @return
     */
    @RequestMapping(value = "/user/{uid}", method = RequestMethod.GET)
    public String view(@PathVariable Long uid, Model model) {
        // 调用业务层方法，根据ID查询相关用户，并返回
        //User user = userService.findById(uid);
        SysUser user = sysUserService.findById(uid);
        // 把查询到的用户相应到页面
        model.addAttribute("user", user);
        return "user/view";
    }

    /**
     * 跳转到添加页面
     *
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return "user/add";
    }

    /**
     * 保存用户
     *
     * @param user 用户信息
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(SysUser user, HttpServletRequest request) {
        // 调用保存业务
        sysUserService.save(user,request);
        //userService.save(user, request);
        //成功后返回到列表页面
        return "redirect:/user/findAll";
    }


    /**
     * 校验用户名是否存在
     *
     * @param userCode
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public Map checkUser(String userCode) {
        // 判断用户是否存在
        String result = sysUserService.checkUser(userCode);
        //String result = userService.checkUser(userCode);
        Map<String, String> map = new HashMap<>();
        // 把判断结果发给页面
        map.put("userCode", result);
        return map;
    }


    /**
     * 跳转编辑页面
     *
     * @param uid 用户ID
     * @return
     */
    @RequestMapping(value = "/edit/{uid}", method = RequestMethod.GET)
    public String edit(@PathVariable Long uid, Model model) {
        // 调用方法，根据ID获取用户信息
        SysUser user = sysUserService.findById(uid);
        //User user = userService.findById(uid);
        // 把用户信息传递给页面
        model.addAttribute("user", user);
        // 跳转到编辑页面
        return "user/edit";
    }

    /**
     * 更新用户
     *
     * @param user    更新用户的信息
     * @param request
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Long uid, SysUser user, HttpServletRequest request) {
        // 调用方法，更新用户
        sysUserService.update(uid,user,request);
        //userService.update(uid, user, request);
        return "redirect:/user/findAll";
    }
}
