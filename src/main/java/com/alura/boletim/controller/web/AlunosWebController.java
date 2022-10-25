package com.alura.boletim.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alunos")
public class AlunosWebController {

    @GetMapping
    public String index(){
        return "/alunos/index";
    }
}
