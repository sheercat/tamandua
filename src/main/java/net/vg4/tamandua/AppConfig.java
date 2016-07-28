package net.vg4.tamandua;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by amano on 2016/07/28.
 */
@Configuration
@Data
public class AppConfig {
    @Value("${spring.profiles.active}")
    private String activeProfile;

    public boolean isDevel() {
        return activeProfile.equals("dev");
    }

    public boolean isProduction() {
        return !activeProfile.equals("dev");
    }

}

