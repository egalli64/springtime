/**
 * http://thisthread.blogspot.com/2017/07/spring-and-jdbctemplate.html
 */
package spittr;

import java.time.Instant;

public class Spittle {
    private final Long id;
    private final Spitter spitter;
    private final String message;
    private final Instant postedTime;

    public Spittle(Long id, Spitter spitter, String message, Instant postedTime) {
        this.id = id;
        this.spitter = spitter;
        this.message = message;
        this.postedTime = postedTime;
    }

    public Long getId() {
        return this.id;
    }

    public String getMessage() {
        return this.message;
    }

    public Instant getPostedTime() {
        return this.postedTime;
    }

    public Spitter getSpitter() {
        return this.spitter;
    }
}
