package fr.etude.tennis.game.app.resources.presentation;

import fr.etude.tennis.game.app.conf.ProfileApp;
import fr.etude.tennis.game.domain.exception.BusinessException;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(ProfileApp.SPRING_PROFILE_TEST)
public class WinnerControllerItTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetWinner() throws Exception {

        mockMvc.perform(get("/tennis/winner/" + "ABABAA")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.winner").value("A"));

    }

    @Test
    void testGetWinner_with_advantage_and_deuce_state() throws Exception {

        mockMvc.perform(get("/tennis/winner/" + "ABABABABAA")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.winner").value("A"));

    }

    @ParameterizedTest
    @ValueSource(strings = {
            "A",
            "AA",
            "AAB",
            "INVALIDE",
            "TESTTES"
    })
    void testGetWinnerWithInvalidInput(String input) throws Exception {

        mockMvc.perform(get("/tennis/winner/" + input)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(result -> Assertions.assertInstanceOf(ConstraintViolationException.class, result.getResolvedException()));
    }


    @ParameterizedTest
    @ValueSource(strings = {
            "AAAB",
            "ABABABABABA"
    })
    void testGetWinnerWithUnfinishedGame(String input) throws Exception {

        mockMvc.perform(get("/tennis/winner/" + input)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity())
                .andExpect(result -> Assertions.assertInstanceOf(BusinessException.class, result.getResolvedException()));
    }
}
