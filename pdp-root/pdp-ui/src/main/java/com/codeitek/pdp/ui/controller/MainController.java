package com.codeitek.pdp.ui.controller;

import org.apache.commons.lang.WordUtils;
import org.apache.log4j.Logger;
import com.codeitek.pdp.core.client.TalonClient;
import com.codeitek.pdp.model.*;
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
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 4/16/13
 * Time: 5:36 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/main")
public class MainController extends BaseController {

    /**
     * Class logger
     */
    private static final Logger log = Logger.getLogger(MainController.class);

    @Autowired
    protected MainController(TalonClient talonClient, IUtil util, PropertyConfigurator configurator) {
        super(talonClient, util, configurator);
    }


    @SuppressWarnings({"SpringMVCViewInspection"})
    @RequestMapping(method = RequestMethod.GET)
    public String base(Model model) {
        return "redirect:main/index";
    }

    @RequestMapping(value="/index", method= RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {
        log.trace("##### MainController.index");
        log.debug("request params: " + util.showParams(request));



        log.debug("index returning: /feeds/index");
        return "/main/index";
    }



    @RequestMapping(value = "/listings", method = RequestMethod.GET)
    public String listings(HttpServletRequest request) {
        log.trace("##### MainController.loadProperties");
        log.debug("##### MainController.loadProperties - request params: " + util.showParams(request));

        Cookie cookie = util.getCookie("pdp-custId",request,configurator);
        String customerUid = cookie.getValue();
        Integer offSet = util.intParam(request, "offSet");
        Integer currentPage = util.intParam(request, "currentPage");
        Integer numToGet = 10;
        PropertyDataDetailList dataFeedList = talonClient.getPropertyFeed(customerUid);
        request.setAttribute("propertyDataFeed", dataFeedList);
        log.debug("loadProperties returning: propertyDataFeed");
        return "main/listings";
    }

    @RequestMapping(value = "/loadMap", method = RequestMethod.GET)
    public String loadMap(HttpServletRequest request) {
        log.trace("##### MainController.loadMap");
        log.debug("##### MainController.loadMap - request params: " + util.showParams(request));


        return "main/loadMap";
    }

    @RequestMapping(value = "/loadProperty", method = RequestMethod.GET)
    public String loadProperty(HttpServletRequest request) {
        log.trace("##### MainController.loadProperty");
        log.debug("##### MainController.loadProperty - request params: " + util.showParams(request));


        Cookie cookie = util.getCookie("pdp-custId",request,configurator);
        String customerUid = cookie.getValue();
        String propertyUId = util.stringParam(request,"propUId");
        Customer customer = talonClient.getCustomerByUUId(customerUid);
        PropertyDataDetail feed = talonClient.getPropertyFeedByProperty(customerUid, propertyUId);

        request.setAttribute("propertyFeed", feed);
        request.setAttribute("customer", customer);
        log.debug("loadProperty returning: propertyFeed");
        return "main/propertyView";
    }
    @RequestMapping(value = "/loadPropertyList", method = RequestMethod.GET)
    public String loadPropertyList(HttpServletRequest request) {
        log.trace("##### MainController.loadPropertyList");
        log.debug("##### MainController.loadPropertyList - request params: " + util.showParams(request));


        Cookie cookie = util.getCookie("pdp-custId",request,configurator);
        int cityId = util.intParam(request, "cityId");
        String customerUid = cookie.getValue();
        PropertyDataDetailList listings = talonClient.getPropertyFeedByCity(customerUid, cityId);
        Customer customer = talonClient.getCustomerByUUId(customerUid);
        List<StateCityView> scv = null;
        if (listings.getList() != null) {
            scv = talonClient.getStateCity(listings.getList().get(0).getZipCode());
        }
        request.setAttribute("listings", listings);
        request.setAttribute("customer", customer);
        request.setAttribute("stateCity", scv);
        log.debug("loadPropertyList returning: propertyListings");
        return "main/propertyListings";
    }

    @RequestMapping(value = "/propertyVault", method = RequestMethod.GET)
    public String propertyVault(HttpServletRequest request) {
        log.trace("##### MainController.propertyVault");
        log.debug("##### MainController.propertyVault - request params: " + util.showParams(request));

        Cookie cookie = util.getCookie("pdp-custId",request,configurator);
        String customerUid = cookie.getValue();
        List<StateCity> stateCityList = talonClient.getStateCityList(customerUid);

        request.setAttribute("stateCityList", stateCityList);
        request.setAttribute("customer",talonClient.getCustomerByUUId(customerUid));
        log.debug("propertyVault returning: stateCityList");
        return "main/propertyVault";
    }

    /**
     * This Method loads the Floating Menu with Buttons linking to the Property Vault, All Properties and each cityName defined in the DB
     * @param request
     * @return
     */
    @RequestMapping(value = "/loadMenu", method = RequestMethod.GET)
    @ResponseBody
    public String loadMenu(HttpServletRequest request) {
        log.trace("##### MainController.loadMenu");
        log.debug("##### MainController.loadMenu - request params: " + util.showParams(request));

        Cookie cookie = util.getCookie("pdp-custId",request,configurator);
        String customerUid = cookie.getValue();
        List<StateCity> stateCityList = talonClient.getStateCityList(customerUid);

        HashMap<String,String> menuHash = new HashMap<String, String>();
        for(StateCity sc: stateCityList){
            menuHash.put(WordUtils.capitalizeFully(sc.getCity().getCityName()),String.format("loadPropertyList?cityId=%s",sc.getCity().getId()));
        }
        menuHash.put("Property Vault",configurator.getResolvedProps().get("menu.link.propertyVault"));
        menuHash.put("All Properties",configurator.getResolvedProps().get("menu.link.allProperties"));

        log.debug("propertyVault returning: stateCityList");
        return json.toJson("menuList",menuHash);
    }





}
