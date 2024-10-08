package com.example.nota2.controller;

import com.example.nota2.entity.statusPokemon;
import com.example.nota2.service.BattleService;
import com.example.nota2.service.PokemonService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class controller {

    @Autowired
    PokemonService pokemonService;
    @Autowired
    BattleService battleService;

    //INFO SOBRE ALUNO E PROJETO
    @GetMapping("/sobre")
    public String sobre() {
        String nome = "Nome do aluno: Bruno Girardi Madeira";
        String nomeprojeto = "\nNome do projeto: Luta Pokemon";
        String result = nome + nomeprojeto;
        System.out.println(result);
        return result;
    }

    //LUTA UTILIZANDO A PESQUISA DOS DOIS POKEMONS
    @GetMapping("/battle")
    public String battle(@RequestParam String pokemon1, @RequestParam String pokemon2) throws JSONException {
            statusPokemon stats1 = pokemonService.getPokemonStats(pokemon1);
            statusPokemon stats2 = pokemonService.getPokemonStats(pokemon2);
            String result = battleService.battle(stats1, stats2, "normal");
            System.out.println(result);
            return result;
    }

    //LUTA COM A PESQUISA DE UM POKEMON E OUTRO RECEBIDO NO BODY
    @PostMapping("/boss")
    public String battleboss(@RequestBody statusPokemon boss, @RequestParam String pokemon1) throws JSONException{
        statusPokemon stats1 = pokemonService.getPokemonStats(pokemon1);
        statusPokemon stats2 = boss;
        String result = battleService.battle(stats1, stats2, "boss");
        return result;
    }
}
