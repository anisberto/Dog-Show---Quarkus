package com.br.nascimento.dogShwo.repositories;
import javax.enterprise.context.ApplicationScoped;

import com.br.nascimento.dogShwo.entities.Dog;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class DogRepository implements PanacheRepository<Dog> {
    
}
