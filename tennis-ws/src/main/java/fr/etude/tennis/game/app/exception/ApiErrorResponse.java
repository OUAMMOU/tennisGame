package fr.etude.tennis.game.app.exception;

import fr.entreprise.dei.client.model.ApiErrorDTO;
import fr.etude.tennis.game.domain.exception.BusinessException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

public class ApiErrorResponse implements Serializable {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ApiErrorResponse.class);

    private ApiErrorTypeEnum type;
    private ApiErrorDTO apiErrorDTO;

    public ApiErrorResponse(BusinessException businessException) {
        this.type = ApiErrorTypeEnum.BUSINESS_ERROR;
        buildBusinessErrorDTO(businessException);
    }

    public ApiErrorResponse(Throwable ex, ApiErrorTypeEnum type) {
        this.type = type;
        buildErrorDTO(ex);
    }

    private void buildErrorDTO(Throwable ex) {
        this.apiErrorDTO = new ApiErrorDTO();
        apiErrorDTO.setMessage(ex.getMessage());
        apiErrorDTO.setTypeError(this.type.getMessage());
        apiErrorDTO.setCause(ExceptionUtils.getRootCauseMessage(ex));
    }

    private void buildBusinessErrorDTO(BusinessException ex) {
        {
            this.apiErrorDTO = new ApiErrorDTO();
            apiErrorDTO.setMessage(ex.getBusinessExceptionEnum().getMessage());
            apiErrorDTO.setTypeError(this.type.getMessage());
            apiErrorDTO.setCause(ExceptionUtils.getRootCauseMessage(ex));
        }
    }

    public ResponseEntity<ApiErrorDTO> buildResponse() {

        return ResponseEntity.status(this.type.getStatusCode()).body(this.apiErrorDTO);
    }

    @Override
    public String toString() {
        return "ApiErrorResponse {" +
                "type=" + type +
                ", apiErrorDTO=" + apiErrorDTO +
                '}';

    }
}