package net.vg4.tamandua.web;

import lombok.extern.slf4j.Slf4j;
import net.vg4.tamandua.AppConfig;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by amano on 2016/07/28.
 */
@Controller
@Slf4j
public class ImageController {
    @Autowired
    AppConfig config;

    @ModelAttribute
    AppConfig setupConfig() {
        return config;
    }

    @GetMapping(value = "/image")
    String getIndex(HttpServletRequest request) throws RuntimeException {
        String reqestByString = ToStringBuilder.reflectionToString(request);
        log.info("!!!" + reqestByString);
        return "image/index";
    }
}
