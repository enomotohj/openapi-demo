package com.enomoso.openapidemo.service;

import com.enomoso.openapidemo.model.Pokemon;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PokemonServiceImpl implements PokemonService {

    @Override
    public Pokemon getPokemonById(String id) {
        log.info("id: " + id);  
        Pokemon pokemon = new Pokemon(id,"pikachew","denki","xxxxxxxxxx");
        return pokemon;
    }
    
}
