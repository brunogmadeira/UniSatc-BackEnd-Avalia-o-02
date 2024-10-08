package com.example.nota2.controller;

import com.example.nota2.entity.statusPokemon;
import com.example.nota2.service.BattleService;
import com.example.nota2.service.PokemonService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class controller {

    @Autowired
    PokemonService pokemonService;
    @Autowired
    BattleService battleService;

    @GetMapping("/sobre")
    public String sobre() {
        String nome = "Nome do aluno: Bruno Girardi Madeira";
        String nomeprojeto = " \n Nome do projeto: Luta Pokemon";
        String retorno = nome + nomeprojeto;
        return retorno;
    }

    @GetMapping("/battle")
    public String battle(@RequestParam String pokemon1, @RequestParam String pokemon2) throws JSONException {
        try {
            statusPokemon stats1 = pokemonService.getPokemonStats(pokemon1);
            statusPokemon stats2 = pokemonService.getPokemonStats(pokemon2);
            return battleService.battle(stats1, stats2);
        } catch (JSONException e) {
            return "Error parsing data from PokeAPI: " + e.getMessage();
        } catch (Exception e) {
            return "An error occurred: " + e.getMessage();
        }
    }

}
