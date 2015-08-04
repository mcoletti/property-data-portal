package com.codeitek.pdp.ui.controller;

import com.codeitek.pdp.core.client.TalonClient;
import com.codeitek.pdp.ui.common.IUtil;
import com.codeitek.pdp.ui.common.JsonUtil;
import com.codeitek.pdp.ui.common.PropertyConfigurator;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 4/23/13
 * Time: 9:48 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class BaseController {


    protected TalonClient talonClient;
    protected final IUtil util;
    protected JsonUtil json = new JsonUtil();
    protected PropertyConfigurator configurator;

    protected BaseController(TalonClient talonClient, IUtil util, PropertyConfigurator configurator) {
        this.talonClient = talonClient;
        this.util = util;
        this.configurator = configurator;
    }
}
