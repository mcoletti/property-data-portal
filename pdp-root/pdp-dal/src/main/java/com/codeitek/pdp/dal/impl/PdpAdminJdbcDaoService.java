package com.codeitek.pdp.dal.impl;

import com.codeitek.pdp.dal.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 6/6/13
 * Time: 2:09 PM
 * To change this template use File | Settings | File Templates.
 */
@Deprecated
public class PdpAdminJdbcDaoService implements PdpAdminDaoService {


    private final AttributesDao attributeDao;
    private final UiPageAttributesDao uiPageAttributeDao;
    private final UiPageLayoutDao uiPageLayoutDao;
    private final UiSectionsDao uiSectionDao;
    private final UiSectionGroupsDao uiSectionGroupData;
    private final UiElementTypeAttributesDao uiElementTypeAttributeDao;
    private final UiElementTypesDao uiElementTypesDao;
    private final CustomerDao customerDao;
    private final StateCityDao stateCityDao;
    private final StateCityViewDao stateCityViewDao;
    private final AuthDao authDao;
    private final UiElementTypesDao uiElementTypeDao;
    private final PageLayoutDao pageLayoutDao;

    @Autowired
    public PdpAdminJdbcDaoService(AttributesDao attributeDao, UiPageAttributesDao uiPageAttributeDao, UiPageLayoutDao uiPageLayoutDao, UiSectionsDao uiSectionDao, UiSectionGroupsDao uiSectionGroupData, UiElementTypeAttributesDao uiElementTypeAttributeDao, UiElementTypesDao uiElementTypesDao, CustomerDao customerDao, StateCityDao stateCityDao, StateCityViewDao stateCityViewDao, AuthDao authDao, UiElementTypesDao uiElementTypeDao, PageLayoutDao pageLayoutDao) {
        this.attributeDao = attributeDao;
        this.uiPageAttributeDao = uiPageAttributeDao;
        this.uiPageLayoutDao = uiPageLayoutDao;
        this.uiSectionDao = uiSectionDao;
        this.uiSectionGroupData = uiSectionGroupData;
        this.uiElementTypeAttributeDao = uiElementTypeAttributeDao;
        this.uiElementTypesDao = uiElementTypesDao;
        this.customerDao = customerDao;
        this.stateCityDao = stateCityDao;
        this.stateCityViewDao = stateCityViewDao;
        this.authDao = authDao;
        this.uiElementTypeDao = uiElementTypeDao;
        this.pageLayoutDao = pageLayoutDao;
    }

    @Override
    public AttributesDao getAttributesDao() {

        return attributeDao;
    }

    @Override
    public UiPageAttributesDao getUiPageAttributesDao() {
        return uiPageAttributeDao;
    }

    @Override
    public UiPageLayoutDao getUiPageLayoutDao() {
        return uiPageLayoutDao;
    }

    @Override
    public UiSectionsDao getUiSectionsDao() {
        return uiSectionDao;
    }

    @Override
    public UiSectionGroupsDao getUiSectionGroupsDao() {
        return uiSectionGroupData;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public UiElementTypeAttributesDao getUiElementTypeAttributesDao() {
        return uiElementTypeAttributeDao;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public UiElementTypesDao getUiElementTypesDao() {
        return uiElementTypeDao;  //To change body of implemented methods use File | Settings | File Templates.
    }


    @Override
    public CustomerDao getCustomerDao() {
        return customerDao;
    }
    @Override
    public StateCityDao getStateCityDao() {
        return stateCityDao;
    }
    @Override
    public StateCityViewDao getStateCityViewDao() {
        return stateCityViewDao;
    }

    @Override
    public AuthDao getAuthDao() {
        return authDao;
    }

    @Override
    public PageLayoutDao getPagelayoutDao() {
        return pageLayoutDao;
    }

}
