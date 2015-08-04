package com.codeitek.pdp.ui.controller;

import org.apache.log4j.Logger;
import com.codeitek.pdp.core.client.TalonClient;
import com.codeitek.pdp.core.impl.TalonClientException;
import com.codeitek.pdp.model.Pagelayout;
import com.codeitek.pdp.ui.common.IUtil;
import com.codeitek.pdp.ui.common.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 6/19/13
 * Time: 5:14 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/pageLayout")
public class PageLayoutController extends com.codeitek.pdp.ui.controller.BaseController {

    /**
     * Class logger
     */
    private static final Logger log = Logger.getLogger(PageLayoutController.class);

    @Autowired
    protected PageLayoutController(TalonClient talonClient, IUtil util, PropertyConfigurator configurator) {
        super(talonClient, util, configurator);
    }


    @RequestMapping(value = "/loadPageLayout", method = RequestMethod.GET)
    public String loadPageLayout(HttpServletRequest request){
        log.trace("##### PageLayoutController.loadPageLayout");
        log.debug("##### PageLayoutController.loadPageLayout - request params: " + util.showParams(request));


        String pageName = util.stringParam(request,"page");
        List<Pagelayout> pagelayoutList = null;
        try {
            pagelayoutList = talonClient.getPageLayout(pageName);
        } catch (TalonClientException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return json.toJson("pageLayouts",pagelayoutList);

    }




}
