package com.example.nota2.service;

import com.example.nota2.entity.statusPokemon;
import org.springframework.stereotype.Service;

@Service
public class BattleService {

    public String battle(statusPokemon pokemon1, statusPokemon pokemon2) {
        StringBuilder logBattle = new StringBuilder();
        logBattle.append("Início da batalha entre " + pokemon1.getName() + " e " + pokemon2.getName() + "!");
        logBattle.append(pokemon1.getName() + ": HP = " + pokemon1.getHp() + ", Ataque = " + pokemon1.getAttack() + "");
        logBattle.append(pokemon2.getName() + ": HP = " + pokemon2.getHp() + ", Ataque = " + pokemon2.getAttack() + "");

        int round = 1;
        while (pokemon1.getHp() > 0 && pokemon2.getHp() > 0) {
            logBattle.append("Rodada " + round + ":");

            pokemon2.setHp(pokemon2.getHp() - pokemon1.getAttack());
            logBattle.append(pokemon1.getName() + " ataca " + pokemon2.getName() + " causando " + pokemon1.getAttack() + " de dano.");
            if (pokemon2.getHp() <= 0) {
                logBattle.append(pokemon2.getName() + " ficou sem vida!");
                logBattle.append(pokemon1.getName() + " é o vencedor!");
                break;
            }
            logBattle.append(pokemon2.getName() + " agora tem " + pokemon2.getHp() + " de HP restante.");

            pokemon1.setHp(pokemon1.getHp() - pokemon2.getAttack());
            logBattle.append(pokemon2.getName() + " ataca " + pokemon1.getName() + " causando " + pokemon2.getAttack() + " de dano.");
            if (pokemon1.getHp() <= 0) {
                logBattle.append(pokemon1.getName() + " ficou sem vida!");
                logBattle.append(pokemon2.getName() + " é o vencedor!");
                break;
            }
            logBattle.append(pokemon1.getName() + " agora tem " + pokemon1.getHp() + " de HP restante.");

            round++;
        }

        if (pokemon1.getHp() <= 0 && pokemon2.getHp() <= 0) {
            logBattle.append("Ambos os Pokémons ficaram sem vida ao mesmo tempo! É um empate!");
        }

        return logBattle.toString();
    }

}
