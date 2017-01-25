package dd.sia.soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = { CompactDisc.class, MediaPlayer.class })
public class CDPlayerConfig {
}
