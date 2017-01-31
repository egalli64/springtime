package dd.sia.myapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class CharSeqConfig {
    @Bean
    @Profile("dev")
    public CharSequence myString() {
        return new String("String");
    }

    @Bean
    @Profile("prod")
    public CharSequence myStringBuilder() {
        StringBuilder sb = new StringBuilder();
        sb.append("StringBuilder");
        return sb;
    }
}
