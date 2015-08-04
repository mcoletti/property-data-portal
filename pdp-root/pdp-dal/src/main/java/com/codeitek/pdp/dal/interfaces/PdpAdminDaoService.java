package com.codeitek.pdp.dal.interfaces;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 6/6/13
 * Time: 1:51 PM
 * To change this template use File | Settings | File Templates.
 */
@Deprecated
public interface PdpAdminDaoService {


    public AttributesDao getAttributesDao();
    public UiPageAttributesDao getUiPageAttributesDao();
    public UiPageLayoutDao getUiPageLayoutDao();
    public UiSectionsDao getUiSectionsDao();
    public UiSectionGroupsDao getUiSectionGroupsDao();
    public UiElementTypeAttributesDao getUiElementTypeAttributesDao();
    public UiElementTypesDao getUiElementTypesDao();
    public CustomerDao getCustomerDao();
    public StateCityDao getStateCityDao();
    public StateCityViewDao getStateCityViewDao();
    public AuthDao getAuthDao();
    public PageLayoutDao getPagelayoutDao();




}
