package ru.netology.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Game game = new Game();

    @Test
    public void ShouldAdd() {
        Player player = new Player(5, "player1", 80);
        game.register(player);

        Assertions.assertEquals(player, game.register(player));
    }

    @Test
    public void ShouldNotRoundOneNotRegistered() {

        Player player1 = new Player(5, "Masha", 80);

        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Masha", "Sasha");
        });
    }

    @Test
    public void ShouldNotRoundTwoNotRegistered() {

        Player player1 = new Player(5, "Masha", 80);
        Player player2 = new Player(167, "Sasha", 38);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Masha", "Sasha");
        });
    }

    @Test
    public void ShouldRoundFirstIsWinner() {

        Player player1 = new Player(5, "Masha", 80);
        Player player2 = new Player(167, "Sasha", 38);

        game.register(player1);
        game.register(player2);

        Assertions.assertEquals(1, game.round("Masha", "Sasha"));
    }

    @Test
    public void ShouldRoundSecondIsWinner() {

        Player player1 = new Player(5, "Masha", 80);
        Player player2 = new Player(167, "Sasha", 138);

        game.register(player1);
        game.register(player2);

        Assertions.assertEquals(2, game.round("Masha", "Sasha"));
    }

    @Test
    public void ShouldRoundTwoWinners() {

        Player player1 = new Player(5, "Masha", 80);
        Player player2 = new Player(167, "Sasha", 80);

        game.register(player1);
        game.register(player2);

        Assertions.assertEquals(0, game.round("Masha", "Sasha"));
    }
}
