package fr.etude.tennis.game.app.mapper;

import fr.etude.tennis.game.domain.tennis.model.Player;
import fr.etude.tennis.game.domain.tennis.model.PlayerEnum;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlayerMapper {

    public List<Player> toPlayers(String players) {
        if (players == null || players.isEmpty()) {
            return List.of();
        }
        return players.chars()
                .mapToObj(c -> new Player(PlayerEnum.valueOf(String.valueOf((char) c))))
                .toList();
    }
}
