package pl.codewise.internships;

import java.time.LocalDateTime;

public class Message {

    private final String userAgent;
    private final int errorCode;
    private final LocalDateTime time;

    public Message(String userAgent, int errorCode) {
        this.userAgent = userAgent;
        this.errorCode = errorCode;
        this.time = LocalDateTime.now();
    }

    public String getUserAgent() {
        return userAgent;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public enum ErrorCodes {
        GOOD (0),
        BAD (-1);

        private final int error;

        ErrorCodes(int error) {
            this.error = error;
        }
    }
}
