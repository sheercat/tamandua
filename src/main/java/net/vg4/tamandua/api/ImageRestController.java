package net.vg4.tamandua.api;

import lombok.extern.slf4j.Slf4j;
import net.vg4.tamandua.AppConfig;
import net.vg4.tamandua.service.ImageProcessor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by amano on 2016/07/28.
 */
@RestController
@Slf4j
public class ImageRestController {
    @Autowired
    ImageProcessor imageProcessor;

    @Autowired
    AppConfig config;

    @ModelAttribute
    AppConfig setupConfig() {
        return config;
    }

    @PostMapping(value = "/image")
    String postIndex(HttpServletRequest request) throws RuntimeException {
        imageProcessor.process(request);
        String reqestByString = ToStringBuilder.reflectionToString(request);
        log.info("!!!" + reqestByString);
        return "POST OK";
    }
}
