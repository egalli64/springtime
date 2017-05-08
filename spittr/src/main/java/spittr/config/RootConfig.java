/**
 * http://thisthread.blogspot.com/2017/04/spittr-spring-web-application.html
 * http://thisthread.blogspot.com/2017/05/from-model-to-view-through-spring.html
 */

package spittr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DataConfig.class)
public class RootConfig {
}
