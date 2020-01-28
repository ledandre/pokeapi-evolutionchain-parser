package com.github.ledandre.domain;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EvolutionChainParser {
    private static final String NAME = "name";
    private static final String SPECIES = "species";
    private static final String EVOLVES_TO = "evolves_to";

    private static ObjectMapper mapper = new ObjectMapper();

    @SuppressWarnings("unchecked")
    public static EvolutionChain parse(String json) throws IOException {
        EvolutionChain evolutionChain = new EvolutionChain();
        Map<String, Object> jsonAsMap = mapper.readValue(json, new TypeReference<Map<String, Object>>() {});
        Map<String, Object> chain = (Map<String, Object>) jsonAsMap.get("chain");
        Map<String, Object> species = (Map<String, Object>) chain.get(SPECIES);
        evolutionChain.addPokemon((String) species.get(NAME));

        extractEvolutions((List<Object>) chain.get(EVOLVES_TO), evolutionChain);

        return evolutionChain;
    }

    @SuppressWarnings("unchecked")
    private static void extractEvolutions(List<Object> chain, EvolutionChain evolutionChain) {
        if (chain.isEmpty()) return;

        Map<String, Object> evolvesTo = (Map<String,Object>) chain.get(0);
        Map<String, Object> evolution = (Map<String, Object>) evolvesTo.get(SPECIES);

        evolutionChain.addPokemon((String) evolution.get(NAME));
        extractEvolutions((List<Object>) evolvesTo.get(EVOLVES_TO), evolutionChain);
    }
}
