package com.cloverdcs.stp.game.exception;

public class GuessToLowException extends Exception {

    public GuessToLowException() {
        super();
    }

    public GuessToLowException(String message) {
        super(message);
    }

    public GuessToLowException(String message, Throwable cause) {
        super(message, cause);
    }

    public GuessToLowException(Throwable cause) {
        super(cause);
    }

    protected GuessToLowException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
