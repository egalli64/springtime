/**
 * http://thisthread.blogspot.com/2017/05/from-model-to-view-through-spring.html
 */

package spittr.data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import spittr.Spittle;

@Repository
public class JdbcSpittleRepository implements SpittleRepository {

    @Override
    public List<Spittle> findRecentSpittles() {
        List<Spittle> result = new ArrayList<>();
        for (int i = 10; i < 20; i++) {
            result.add(findOne(i));
        }

        return result;
    }

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> result = new ArrayList<>();
        for (long i = 0; i < count; i++) {
            result.add(new Spittle(i, "Message " + i, LocalDateTime.now(), 1.0 * i, 2.0 * i));
        }

        return result;
    }

    @Override
    public Spittle findOne(long id) {
        return new Spittle(id, "Fake Message", LocalDateTime.now(), 0.0, 0.0);
    }

    @Override
    public void save(Spittle spittle) {
    }
}
