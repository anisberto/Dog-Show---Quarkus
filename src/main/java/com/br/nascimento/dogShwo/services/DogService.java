package com.br.nascimento.dogShwo.services;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.br.nascimento.dogShwo.repositories.DogRepository;

import lombok.experimental.Delegate;

@ApplicationScoped
public class DogService {

    @Inject
    @Delegate(types = DogRepository.class)
    DogRepository dogRepository;
}
