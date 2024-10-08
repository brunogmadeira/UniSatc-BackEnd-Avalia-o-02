package com.example.nota2.service;

import com.example.nota2.entity.statusPokemon;
import org.springframework.stereotype.Service;

@Service
public class BattleService {

    public String battle(statusPokemon pokemon1, statusPokemon pokemon2, String local) {
        StringBuilder logBattle = new StringBuilder();

        if (local.equals("boss")) {
            logBattle.append("Início da batalha entre " + pokemon1.getName() + " e Boss " + pokemon2.getName() + "!\n");
        } else {
            logBattle.append("Início da batalha entre " + pokemon1.getName() + " e " + pokemon2.getName() + "!\n");
        }

        logBattle.append(pokemon1.getName() + ": HP = " + pokemon1.getHp() + ", Ataque = " + pokemon1.getAttack() + "\n");
        logBattle.append(pokemon2.getName() + ": HP = " + pokemon2.getHp() + ", Ataque = " + pokemon2.getAttack() + "\n");

        int round = 1;
        while (pokemon1.getHp() > 0 && pokemon2.getHp() > 0) {
            logBattle.append("Rodada " + round + ":\n");
            //CAPTURA NA VARIAVEL O DANO
            int danoPko2 = pokemon1.getAttack();
            int danoPko3 = pokemon2.getAttack();
            //REDUZ DANO DA VIDA
            pokemon2.setHp(pokemon2.getHp() - danoPko2);
            pokemon1.setHp(pokemon1.getHp() - danoPko3);
            //TRAS INFORMACOES SOBRE ROUND
            logBattle.append(pokemon1.getName() + " ataca " + pokemon2.getName() + " causando " + danoPko2 + " de dano.\n");
            logBattle.append(pokemon2.getName() + " ataca " + pokemon1.getName() + " causando " + danoPko3 + " de dano.\n");
            //VERIFICA FIM DA LUTA
            if (pokemon1.getHp() <= 0 && pokemon2.getHp() <= 0) {
                logBattle.append("Ambos os Pokémons ficaram sem vida ao mesmo tempo! É um empate!\n");
                break;
            }
            if (pokemon1.getHp() <= 0) {
                logBattle.append(pokemon1.getName() + " ficou sem vida!\n");
                logBattle.append(pokemon2.getName() + " é o vencedor!\n");
                break;
            }
            if (pokemon2.getHp() <= 0) {
                logBattle.append(pokemon2.getName() + " ficou sem vida!\n");
                logBattle.append(pokemon1.getName() + " é o vencedor!\n");
                break;
            }
            //RETORNA OS STATUS ATUAIS
            logBattle.append(pokemon1.getName() + " agora tem " + pokemon1.getHp() + " de HP restante.\n");
            logBattle.append(pokemon2.getName() + " agora tem " + pokemon2.getHp() + " de HP restante.\n");
            round++;
        }
        return logBattle.toString();
    }
}
