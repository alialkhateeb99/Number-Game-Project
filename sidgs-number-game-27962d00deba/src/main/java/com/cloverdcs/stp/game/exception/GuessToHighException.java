package com.cloverdcs.stp.game.exception;


/**
 * This is the Error used to indicate that the Users Guess was much higher than expected
 */

public class GuessToHighException extends Exception {
    public GuessToHighException() {
        super();
    }

    public GuessToHighException(String message) {
        super(message);
    }

    public GuessToHighException(String message, Throwable cause) {
        super(message, cause);
    }

    public GuessToHighException(Throwable cause) {
        super(cause);
    }

    protected GuessToHighException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
