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
        String[] src = {"0.jpg", "1.png", "2.png", "3.png", "4.jpg", "5.jpg", "6.jpg", "7.jpg", "8.png", "9.jpg", "10.png", "11.jpg"};
        
        

        Stone birthStone = stoneRepository.findByMonth(month);

        model.addAttribute("username", userInfo.getName());
        model.addAttribute("month", month);
        model.addAttribute("src", src[month]);
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
