package fr.etude.tennis.game.app.resources.presentation;

import fr.entreprise.dei.client.api.WinnerEndpointApi;
import fr.entreprise.dei.client.model.WinnerDTO;
import fr.etude.tennis.game.app.adapter.WinnerApiAdapter;
import fr.etude.tennis.game.app.mapper.PlayerMapper;
import fr.etude.tennis.game.app.mapper.WinnerMapper;
import fr.etude.tennis.game.domain.tennis.model.Player;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WinnerController implements WinnerEndpointApi {

    private final WinnerApiAdapter winnerApiAdapter;
    private final PlayerMapper playerMapper;
    private final WinnerMapper winnerMapper;

    public WinnerController(WinnerApiAdapter winnerApiAdapter, PlayerMapper playerMapper, WinnerMapper winnerMapper) {
        this.winnerApiAdapter = winnerApiAdapter;
        this.playerMapper = playerMapper;
        this.winnerMapper = winnerMapper;
    }

    @Override
    public ResponseEntity<WinnerDTO> getWinner(String palyersDTO) {
        List<Player> players = playerMapper.toPlayers(palyersDTO);
        WinnerDTO winnerDTO = winnerMapper.toWinnerDTO(winnerApiAdapter.getWinner(players));
        return ResponseEntity.ok(winnerDTO);
    }
}
