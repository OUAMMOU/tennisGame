package fr.etude.tennis.game.app.mapper;


import fr.etude.tennis.game.domain.tennis.model.Game;
import fr.etude.tennis.game.presentation.model.PalyerScoreDTO;
import fr.etude.tennis.game.presentation.model.WinnerDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WinnerMapper {

    public WinnerDTO toWinnerDTO(Game game) {
        WinnerDTO winnerDTO = new WinnerDTO();
        winnerDTO.setWinner(String.valueOf(game.getWinner().getName()));

        winnerDTO.setPlayerA(mapPlayerScores(game.getPlayerA().getScores()));
        winnerDTO.setPlayerB(mapPlayerScores(game.getPlayerB().getScores()));

        return winnerDTO;
    }

    private List<PalyerScoreDTO> mapPlayerScores(List<Integer> scores) {
        return scores.stream()
                .map(score -> {
                    PalyerScoreDTO playerScoreDTO = new PalyerScoreDTO();
                    playerScoreDTO.setScore(String.valueOf(score));
                    return playerScoreDTO;
                })
                .toList();
    }
}
