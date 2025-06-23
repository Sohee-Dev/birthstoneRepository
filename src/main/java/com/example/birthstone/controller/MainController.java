package com.example.birthstone.controller;

import com.example.birthstone.dto.UserInfo;
import com.example.birthstone.entity.Stone;
import com.example.birthstone.repository.StoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    private StoneRepository stoneRepository;

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @PostMapping("/birth")
    public String birth(@ModelAttribute UserInfo userInfo, Model model) {
        int month = userInfo.getUserBirthday().getMonthValue();
        int idx = month -1;

        Stone birthStone = stoneRepository.findByMonth(month);

        model.addAttribute("username", userInfo.getName());
        model.addAttribute("month", month);
        model.addAttribute("idx", idx);
        model.addAttribute("stone_name", birthStone.getName());
        model.addAttribute("birthstoneDescription", birthStone.getExplan());

        return "result_page";
    }

    @GetMapping("/birthstones")
    public String stoneAll(Model model) {
        model.addAttribute("list", stoneRepository.findAll());
        return "stoneAllinfo";
    }
   
}
