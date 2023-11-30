package com.projeto.Caua.service;

import com.projeto.Caua.model.Contato;
import com.projeto.Caua.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceContato {

    @Autowired
    private ContatoRepository contatoRepository;

    public String alterarContato(Contato contato, Long id) {
        Contato contatoExistente = contatoRepository.findByEmail(contato.getEmail());

        if ((contatoExistente != null && contatoExistente.getId().equals(id)) || contatoExistente == null) {
            contatoRepository.save(contato);
        } else {
            return "Já existe um contato cadastrado com o mesmo E-mail!";
        }

        return null;
    }
}
