package com.example.nota2.service;

import com.example.nota2.entity.statusPokemon;
import org.json.JSONException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

@Service
public class PokemonService {

    private static final String POKE_API_URL = "https://pokeapi.co/api/v2/pokemon/";

    public static statusPokemon getPokemonStats(String name) throws JSONException {
        RestTemplate restTemplate = new RestTemplate();
        String url = POKE_API_URL + name.toLowerCase();
        String response = restTemplate.getForObject(url, String.class);

        JSONObject jsonObject = new JSONObject(response);
        int hp = jsonObject.getJSONArray("stats")
                .getJSONObject(0)
                .getInt("base_stat");
        int attack = jsonObject.getJSONArray("stats")
                .getJSONObject(1)
                .getInt("base_stat");

        return new statusPokemon(name, hp, attack);
    }
}
