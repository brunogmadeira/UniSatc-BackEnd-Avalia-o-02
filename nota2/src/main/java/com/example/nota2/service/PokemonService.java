package com.example.nota2.service;

import com.example.nota2.entity.statusPokemon;
import org.json.JSONException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

@Service
public class PokemonService {

    //ROTA API
    private static final String POKE_API_URL = "https://pokeapi.co/api/v2/pokemon/";

    //BUSCA API POKEMON
    public static statusPokemon consultaPokemon(String name) {
        RestTemplate restTemplate = new RestTemplate();
        String url = POKE_API_URL + name.toLowerCase();
        try {
            String response = restTemplate.getForObject(url, String.class);
            JSONObject jsonObject = new JSONObject(response);
            int hp = jsonObject.getJSONArray("stats")
                    .getJSONObject(0)
                    .getInt("base_stat");
            int attack = jsonObject.getJSONArray("stats")
                    .getJSONObject(1)
                    .getInt("base_stat");
            return new statusPokemon(name, hp, attack);
        } catch (RestClientException e) {
            System.err.println("Erro ao se comunicar com a PokeAPI: " + e.getMessage());
            return new statusPokemon(name, 0, 0);
        } catch (JSONException e) {
            System.err.println("Erro ao processar a resposta da PokeAPI: " + e.getMessage());
            return new statusPokemon(name, 0, 0);
        } catch (Exception e) {
            System.err.println("Erro desconhecido: " + e.getMessage());
            return new statusPokemon(name, 0, 0);
        }
    }

    //FUNCAO CONSULTA POKEMON
    public static statusPokemon getPokemonStats(String name) throws JSONException {
        return consultaPokemon(name);
    }

}
