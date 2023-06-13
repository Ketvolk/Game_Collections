package ru.netology.qa;

import java.util.HashMap;

public class Game {
    HashMap<String, Player> map = new HashMap<>();

    public Player register(Player player) {
        map.put(player.getName(), player);
        return player;
    }

    public boolean findByName(String name) {
        return map.containsKey(name);
    }

    public int round(String playerName1, String playerName2) {
        if (!findByName(playerName1)) {
            throw new NotRegisteredException(playerName1);
        }
        if (!findByName(playerName2)) {
            throw new NotRegisteredException(playerName2);
        }

        Player player1 = map.get(playerName1);
        Player player2 = map.get(playerName2);

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;
    }
}





