package com.bysh.cs.smbms.controller;

import com.bysh.cs.smbms.service.impl.SchedulingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/duty")
public class DutyController {

    @Autowired
    SchedulingServiceImpl schedulingService;

    @RequestMapping(value = "/findAll")
    public String findAll(String date, String username, Model model){
        //List<DutyList> userLists = schedulingService.findByDateAndName(date,username);
        //model.addAttribute("userlist",userLists);
        return  "duty/dutylist";
    }

    @RequestMapping(value = "/find")
    public  String findlist(String date,String username,Model  model){
        return "duty/dutyfind";
    }

}
