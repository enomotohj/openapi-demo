package com.enomono.openapidemo.controller;

import com.enomono.openapidemo.model.Pokemon;
import com.enomono.openapidemo.service.PokemonService;
import com.enomoso.openapidemo.generated.server.controller.PokemonsApi;
import com.enomoso.openapidemo.generated.server.model.InlineResponse200;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1")
@Slf4j
public class PokemonsApiController implements PokemonsApi {
    
    @Autowired
    PokemonService pokemonService;

    /**
     * GET /pokemons/{id}
     * Get a pokemon by ID
     *
     * @param id Numeric ID of the user to get (required)
     * @return OK (status code 200)
     */
    @Override
    @ApiOperation(value = "", nickname = "getPokemonById", notes = "Get a pokemon by ID", response = InlineResponse200.class, tags={  })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = InlineResponse200.class) })
    @GetMapping(value = "/pokemons/{id}", produces = { "application/json" })
    public ResponseEntity<InlineResponse200> getPokemonById(@ApiParam(value = "Numeric ID of the user to get",required=true) @PathVariable("id") String id) {
        log.info("getPokemonById() execute");
        Pokemon pokemon = pokemonService.getPokemonById(id);
        InlineResponse200 response = new InlineResponse200();
        response.setId(pokemon.getId());
        response.setName(pokemon.getName());
        response.setType(pokemon.getType());
        response.setComment(pokemon.getComment());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    
}
