/**
 * http://thisthread.blogspot.com/2017/05/from-model-to-view-through-spring.html
 * http://thisthread.blogspot.com/2017/07/using-jdbctemplate-in-spitter-web-app.html
 */

package spittr.data;

import java.util.List;

import spittr.Spittle;

public interface SpittleRepository {
    long count();

    List<Spittle> findRecent();

    List<Spittle> findRecent(int count);

    Spittle findOne(long id);

    Spittle save(Spittle spittle);

    List<Spittle> findBySpitterId(long spitterId);

    void delete(long id);
}
