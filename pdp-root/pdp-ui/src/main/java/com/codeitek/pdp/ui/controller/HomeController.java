package com.codeitek.pdp.ui.controller;

import org.apache.log4j.Logger;
import com.codeitek.pdp.core.client.TalonClient;
import com.codeitek.pdp.ui.common.IUtil;
import com.codeitek.pdp.ui.common.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 4/16/13
 * Time: 11:20 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/home")
public class HomeController extends BaseController {

    /**
     * Class logger
     */
    private static final Logger log = Logger.getLogger(HomeController.class);

    @Autowired
    protected HomeController(TalonClient talonClient, IUtil util, PropertyConfigurator configurator) {
        super(talonClient, util, configurator);
    }


    @SuppressWarnings({"SpringMVCViewInspection"})
    @RequestMapping(method = RequestMethod.GET)
    public String base(Model model) {
        return "redirect:home/index";
    }

    @RequestMapping(value="/index", method= RequestMethod.GET)
    public String index(Model model, HttpServletRequest request,HttpServletResponse response) {
        log.trace("##### HomeController.index");
        log.debug("request params: " + util.showParams(request));

        model.addAttribute("displayName", "Micah Coletti");
        UUID uuid = UUID.randomUUID();
        Cookie cookie = null;
        // TODO Add real logic for Logging in and out off app and setting up Cookie and session
//        cookie = new Cookie("CRSESSIONID",customerUuid.toString());
//        cookie.setPath("/cr-webui");
//        response.addCookie(cookie);
        cookie = new Cookie("pdp-sessionId",uuid.toString());
        cookie.setPath("/pdp-portal");
        cookie = new Cookie("pdp-custId",configurator.getResolvedProps().get("customerUUid"));
        cookie.setPath("/pdp-portal");
        response.addCookie(cookie);
        log.debug("index returning: /home/index");
        return "/index";
    }

    @RequestMapping(value = "/login")
    public @ResponseBody String login(HttpServletRequest request, HttpServletResponse response, Locale loc) {
        UUID uuid = UUID.randomUUID();
        Cookie cookie = null;
        // TODO Add real logic for Logging in and out off app and setting up Cookie and session
//        cookie = new Cookie("CRSESSIONID",customerUuid.toString());
//        cookie.setPath("/cr-webui");
//        response.addCookie(cookie);
        cookie = new Cookie("pdp-sessionId",uuid.toString());
        cookie.setPath("/pdp-portal");
        cookie = new Cookie("pdp-custId",configurator.getResolvedProps().get("customerUUid"));
        cookie.setPath("/pdp-portal");
        response.addCookie(cookie);

        return "LOGGED_IN";
    }

}
