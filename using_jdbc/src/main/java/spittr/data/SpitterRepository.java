/**
 * http://thisthread.blogspot.com/2017/07/spring-and-jdbctemplate.html
 */
package spittr.data;

import java.util.List;
import spittr.Spitter;

public interface SpitterRepository {
    long count();

    Spitter save(Spitter spitter);

    Spitter findOne(long id);

    Spitter findByUsername(String username);

    List<Spitter> findAll();
}
