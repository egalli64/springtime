/**
 * http://thisthread.blogspot.com/2017/06/spitter-registration.html
 */
package spittr.data;

import org.springframework.stereotype.Repository;

import spittr.Spitter;

@Repository
public class JdbcSpitterRepository implements SpitterRepository {
    @Override
    public Spitter save(Spitter spitter) {
        // TODO: actual implementation
        return spitter;
    }

    @Override
    public Spitter findByUsername(String username) {
        // TODO: actual implementation
        return new Spitter(username, "password", "John", "Doe", "jdoe@somesite.dd");
    }
}
