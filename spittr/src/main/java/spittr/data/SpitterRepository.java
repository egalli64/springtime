/**
 * http://thisthread.blogspot.com/2017/06/spitter-registration.html
 */
package spittr.data;

import spittr.Spitter;

public interface SpitterRepository {
    Spitter save(Spitter spitter);
    Spitter findByUsername(String username);
}
