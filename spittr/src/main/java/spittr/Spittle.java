/**
 * http://thisthread.blogspot.com/2017/05/from-model-to-view-through-spring.html
 * http://thisthread.blogspot.com/2017/07/using-jdbctemplate-in-spitter-web-app.html
 */
package spittr;

import java.time.Instant;
import java.util.Objects;

public class Spittle {
    private final Long id;
    private final Spitter spitter;
    private final String message;
    private final Instant time;

    public Spittle(String message, Instant time) {
        this(null, null, message, time);
    }

    public Spittle(Long id, Spitter spitter, String message, Instant time) {
        this.id = id;
        this.spitter = spitter;
        this.message = message;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public Spitter getSpitter() {
        return this.spitter;
    }

    public String getMessage() {
        return message;
    }

    public Instant getTime() {
        return time;
    }

    @Override
    final public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (!(that instanceof Spittle))
            return false;

        Spittle other = (Spittle) that;
        return this.id == other.id && Objects.equals(this.spitter, other.spitter)
                && Objects.equals(this.time, other.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time);
    }
}
