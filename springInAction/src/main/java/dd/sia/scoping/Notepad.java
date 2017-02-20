/**
 * Info: http://thisthread.blogspot.com/2017/02/spring-prototype-bean.html
 * 
 * @author manny egalli64@gmail.com
 */
package dd.sia.scoping;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Notepad implements Scoping {
}
