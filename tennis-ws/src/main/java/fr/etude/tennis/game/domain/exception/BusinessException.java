package fr.etude.tennis.game.domain.exception;

public class BusinessException extends RuntimeException {

   private final  BusinessExceptionEnum businessExceptionEnum;

    public BusinessException(BusinessExceptionEnum businessExceptionEnum) {
        this.businessExceptionEnum = businessExceptionEnum;
    }
}
