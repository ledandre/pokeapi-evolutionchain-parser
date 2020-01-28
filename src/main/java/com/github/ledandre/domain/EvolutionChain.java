package com.github.ledandre.domain;

import java.util.ArrayList;
import java.util.List;

public class EvolutionChain {

    private List<String> evolutionChain = new ArrayList<>();

    public void addPokemon(String pokemon) {
        this.evolutionChain.add(pokemon);
    }

    public List<String> getEvolutionChain() {
        return evolutionChain;
    }
}
