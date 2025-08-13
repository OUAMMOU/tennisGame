package fr.etude.tennis.game.app.mapper;

import fr.entreprise.dei.client.model.PalyerScoreDTO;
import fr.entreprise.dei.client.model.WinnerDTO;
import fr.etude.tennis.game.domain.tennis.model.TennisGame;
import org.springframework.stereotype.Component;

@Component
public class WinnerMapper {

   public WinnerDTO toWinnerDTO(TennisGame game) {
        WinnerDTO winnerDTO = new WinnerDTO();
        winnerDTO.setWinner(String.valueOf(game.getWinner().getName()));

        game.getPlayerA().getScores().forEach(score -> {
            PalyerScoreDTO playerScoreDTO = new PalyerScoreDTO();
            playerScoreDTO.setScore(String.valueOf(score));
            winnerDTO.addPlayerAItem(playerScoreDTO);
        });
        game.getPlayerB().getScores().forEach(score -> {
            PalyerScoreDTO playerScoreDTO = new PalyerScoreDTO();
            playerScoreDTO.setScore(String.valueOf(score));
            winnerDTO.addPlayerBItem(playerScoreDTO);
        });
        return winnerDTO;
    }
}
