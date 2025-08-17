package fr.etude.tennis.game.app.exception;

import fr.etude.tennis.game.domain.exception.BusinessException;
import fr.etude.tennis.game.presentation.model.ApiErrorDTO;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ApiExceptionHandlerAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiExceptionHandlerAdvice.class);

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiErrorDTO> handleBusinessException(BusinessException ex) {
        LOGGER.info(ApiErrorTypeEnum.BUSINESS_ERROR + " : {}", ex.getBusinessExceptionEnum().getMessage());
        return new ApiErrorResponse(ex).buildResponse();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiErrorDTO> handleConstraintViolationException(ConstraintViolationException ex) {

        return new ApiErrorResponse(ex, ApiErrorTypeEnum.BAD_REQUEST).buildResponse();
    }

    //TODO : Add more exception handlers as needed for other types of exceptions
}
