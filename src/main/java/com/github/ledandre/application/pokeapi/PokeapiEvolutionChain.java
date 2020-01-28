package com.github.ledandre.application.pokeapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokeapiEvolutionChain {

    private Species species;

}
