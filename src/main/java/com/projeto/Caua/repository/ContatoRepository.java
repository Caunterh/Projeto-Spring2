package com.projeto.Caua.repository;

import com.projeto.Caua.model.Contato;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContatoRepository extends CrudRepository<Contato, Long> {

    @Query("SELECT c FROM Contato c ORDER BY c.id")
    List<Contato> findAllOrderedById();

    Contato findByEmail(String email);
}
