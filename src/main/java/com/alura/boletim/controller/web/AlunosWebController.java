package com.alura.boletim.controller.web;

import com.alura.boletim.model.Alunos;
import com.alura.boletim.services.AlunosServices;
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
    public String form(Alunos alunos){
        return "alunos/form";
    }

    @PostMapping
    public String create(Alunos alunos, BindingResult binding, RedirectAttributes redirect){
        if(binding.hasErrors()) return "alunos/form";
        String mensagem = (alunos.getIdAluno() == null) ? "Cadastro Realizado" : "Aluno alterado";
        services.save(alunos);
        redirect.addFlashAttribute("message",mensagem);
        return "redirect:/alunos";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect){
        services.deleteById(id);
        redirect.addFlashAttribute("message","Aluno apagado com sucesso");
        return "redirect:/alunos";
    }
    @GetMapping("{id}")
    public ModelAndView edit(@PathVariable Long id){
        var aluno = services.get(id);
        return new ModelAndView("alunos/form").addObject("alunos", aluno.get());
    }

}
