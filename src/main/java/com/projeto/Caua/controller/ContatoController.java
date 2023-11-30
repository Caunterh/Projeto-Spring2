package com.projeto.Caua.controller;

import com.projeto.Caua.model.Contato;
import com.projeto.Caua.repository.ContatoRepository;
import com.projeto.Caua.service.ServiceContato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ContatoController {

    @Autowired
    private ServiceContato serviceContato;

    @Autowired
    private ContatoRepository contatoRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("cadastrarContato")
    public ModelAndView agenda() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("contato", new Contato());
        mv.setViewName("cadastrarContato");
        return mv;
    }

    @PostMapping("/salvarContato")
    public ModelAndView cadastro(@ModelAttribute("contato") Contato user) {
        ModelAndView mv = new ModelAndView();
        contatoRepository.save(user);
        mv.setViewName("redirect:/listarContatos");
        return mv;
    }

    @GetMapping("/listarContatos")
    public ModelAndView listarContatos() {
        ModelAndView mv = new ModelAndView();
        List<Contato> contatos = contatoRepository.findAllOrderedById();
        mv.addObject("contatos", contatos);
        mv.setViewName("listarContatos");
        return mv;
    }

    @GetMapping("/alterarContato/{id}")
    public ModelAndView alterarContato(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView();
        Contato contato = contatoRepository.findById(id).orElse(new Contato());
        mv.addObject("contato", contato);
        mv.setViewName("alterarContato");
        return mv;
    }

    @PostMapping("/alterarContato")
    public ModelAndView alterarContato(@ModelAttribute("contato") Contato contato) {
        ModelAndView mv = new ModelAndView();
        String out = serviceContato.alterarContato(contato, contato.getId());

        if (out != null) {
            mv.addObject("msg", out);
            mv.addObject("contato", contato);
            mv.setViewName("alterarContato");
        } else {
            mv.setViewName("redirect:/listarContatos");
        }

        return mv;
    }


    @GetMapping("/deletar/{id}")
    public String deletarContato(@PathVariable("id") Long id) {
        contatoRepository.deleteById(id);
        return "redirect:/listarContatos";
    }
}
