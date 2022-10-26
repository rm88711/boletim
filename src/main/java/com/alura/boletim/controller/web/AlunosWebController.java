package com.alura.boletim.controller.web;

import com.alura.boletim.model.Alunos;
import com.alura.boletim.services.AlunosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/alunos")
public class AlunosWebController {

    @Autowired
    AlunosServices services;

    @GetMapping
    public ModelAndView index(){
        ModelAndView mv =  new ModelAndView("/alunos/index");
        mv.addObject("alunos",services.listAll());
        return mv;
    }
    @GetMapping("new")
    public String form(){
        return "alunos/form";
    }

    @PostMapping
    public String create(Alunos alunos){
        services.save(alunos);
        return "redirect:/alunos";
    }

}
