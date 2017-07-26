/**
 * http://thisthread.blogspot.com/2017/06/spitter-registration.html
 * http://thisthread.blogspot.com/2017/07/using-jdbctemplate-in-spitter-web-app.html
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
