package com.coffee.controller;

import com.coffee.entity.Fruit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FruitHtmlController {
    @GetMapping("/fruit01") // http://localhost:9000/fruit01
    public String test(Model model){
        // Model은 데이터 저장소 역할
        Fruit bean = new Fruit(); // bean이 저장될 데이터
        bean.setId("banana");
        bean.setName("바나나");
        bean.setPrice(1000);

        // 저장시 식별할 수 있도록 "fruit"라는 이름으로 저장
        model.addAttribute("fruit", bean);

        // html 문서에서 이를 접근할 수 있음
        return "fruit"; // fruit.html 문서로 이동 (보낼 html파일 이름 적기 - 대소문자 구별함)
    }
}