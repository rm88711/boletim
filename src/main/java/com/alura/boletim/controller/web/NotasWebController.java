package com.alura.boletim.controller.web;

import com.alura.boletim.services.NotasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/notas")
public class NotasWebController {
    @Autowired
    NotasService services;

    @GetMapping
    public ModelAndView index(){
        ModelAndView mv =  new ModelAndView("/notas/index");
        mv.addObject("notas",services.listAll());
        return mv;
//        System.out.println("ANTES DO ERRO ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ");
//        System.out.println("ANTES DO ERRO AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA ID ");
//        var notas = services.get(id);
//        System.out.println("ANTES DO ERRO CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC");
//        return new ModelAndView("notas/form").addObject("notas", notas.get());
    }


}
