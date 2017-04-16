package club.iwalker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Map;

/**
 * Created by wangchen on 2017/3/3.
 */
@Controller
@SessionAttributes("authorizationRequest")
public class OauthController {

    private static final Logger log = LoggerFactory.getLogger(OauthController.class);



    @RequestMapping("/oauth/error")
    public String error(@RequestParam Map<String, String> parameters) {
        String uri = parameters.get("redirect_uri");
        log.info("重定向: {}", uri);

        return "redirect:" + uri + "?error=1";
    }
}
