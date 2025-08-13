package fr.etude.tennis.game.app.exception;

import fr.entreprise.dei.client.model.ApiErrorDTO;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class ApiErrorResponse implements Serializable {

    private HttpStatus httpStatus;
    private ApiErrorDTO apiErrorDTODTO;

    public ApiErrorResponse(HttpStatus httpStatus, Throwable throwable) {
        this.httpStatus = httpStatus;
        buildErrorDTO(throwable.getClass().getSimpleName(), throwable.getMessage());
    }

    private void buildErrorDTO(String typeError, String message) {
        {
            ApiErrorDTO errorDTO = new ApiErrorDTO();
            errorDTO.setMessage(message);
            errorDTO.setTypeError(typeError);
        }
    }
}
