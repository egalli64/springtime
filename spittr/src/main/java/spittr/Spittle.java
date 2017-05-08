/**
 * http://thisthread.blogspot.com/2017/05/from-model-to-view-through-spring.html
 */
package spittr;

import java.time.LocalDateTime;
import java.util.Objects;

public class Spittle {
    private final Long id;
    private final String message;
    private final LocalDateTime time;
    private Double latitude;
    private Double longitude;

    public Spittle(String message, LocalDateTime time) {
        this(null, message, time, null, null);
    }

    public Spittle(Long id, String message, LocalDateTime time, Double longitude, Double latitude) {
        this.id = id;
        this.message = message;
        this.time = time;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    @Override
    final public boolean equals(Object that) {
        if(this == that) {
            return true;
        }
        if (!(that instanceof Spittle))
            return false;

        Spittle other = (Spittle) that;
        return this.id == other.id && Objects.equals(this.time, other.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time);
    }
}
