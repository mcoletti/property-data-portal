package com.codeitek.pdp.core.impl;

import com.codeitek.pdp.core.client.HttpClient;
import com.codeitek.pdp.core.client.TalonClient;
import com.codeitek.pdp.model.*;

import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 4/22/13
 * Time: 10:21 AM
 * Descvription
 * Mock pdp API Service
 * To change this template use File | Settings | File Templates.
 */
public class MockTalonClientImpl extends BaseClient implements TalonClient {


    public MockTalonClientImpl(HttpClient httpClient) {
        super(httpClient);
    }

    @Override
    public PropertyDataDetailList getPropertyFeed(String customUId) {
        return getTempFeed();
    }

    @Override
    public PropertyDataDetail getPropertyFeedByProperty(String customerUUid, String propertyUId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

//    @Override
//    public PropertyFeed getPropertyFeedByProperty(String customUId, String propertyUId) {
//
//
//        PropertyDataFeedList list = new PropertyDataFeedList();
//        PropertyData pd;
//        PropertyFeedBuilder builder;
//        if(propertyUId.equals("a1b48900-5944-4c7d-b877-04a7332ceb7d")){
//            pd = new PropertyData();
//            pd.setId(36);
//            pd.setCustomerUuid("a1b48900-5944-4c7d-b877-04a7332ceb7d");
//            pd.setPrice(55900);
//            pd.setDataSourceId(1);
//            pd.setZip(35211);
//            pd.setDescription("Great home by the college. Quiet neighborhood. New roof. New flooring throughout. New paint throughout. Brand new Furnace and A/C.  Priced well under market at $34 Sqft.");
//            pd.setNumBaths(2);
//            pd.setNumBeds(3);
//            pd.setPropName("1405 17th Way SW");
//            pd.setSqft("1645");
//            pd.setStatus("Active");
//            pd.setType("SFR");
//
//            builder = new PropertyFeedBuilder(pd);
//            builder.setDataSource("Cool Source").setStateName("AL").setCityName("BIRMINGHAM");
//            builder.setImageData(getImageData(36));
//            builder.setFinancialView(getPropertyFinancial());
//            return builder.build();
//        }
//
//
//        if (propertyUId.equals("eb4e2198-6224-4ca9-86d3-0461aa5f6d5c")) {
//            pd = new PropertyData();
//            pd.setId(53);
//            pd.setCustomerUuid("eb4e2198-6224-4ca9-86d3-0461aa5f6d5c");
//            pd.setPrice(46500);
//            pd.setDataSourceId(1);
//            pd.setZip(35208);
//            pd.setDescription("Great home in a Great market!");
//            pd.setNumBaths(1);
//            pd.setNumBeds(3);
//            pd.setPropName("1328 43rd St Ensley");
//            pd.setSqft("1600");
//            pd.setStatus("Active");
//            pd.setType("SFR");
//
//            builder = new PropertyFeedBuilder(pd);
//            builder.setDataSource("Cool Source").setStateName("AL").setCityName("BIRMINGHAM");
//            builder.setImageData(getImageData(53));
//            builder.setFinancialView(getPropertyFinancial());
//            return builder.build();
//        }
//
//        if (propertyUId.equals("1f99dee2-d892-439a-a9ce-2570fce95a94")) {
//            pd = new PropertyData();
//            pd.setId(60);
//            pd.setPropName("2672 20th Street");
//            pd.setCustomerUuid("1f99dee2-d892-439a-a9ce-2570fce95a94");
//            pd.setPrice(39000);
//            pd.setDataSourceId(1);
//            pd.setZip(35208);
//            pd.setDescription("Great Section 8 tenant! Full rehab. No carpet means less maintenance!");
//            pd.setNumBaths(1);
//            pd.setNumBeds(2);
//            pd.setSqft("1200");
//            pd.setStatus("Active");
//            pd.setType("SFR");
//
//            builder = new PropertyFeedBuilder(pd);
//            builder.setDataSource("Cool Source").setStateName("AL").setCityName("BIRMINGHAM");
//            builder.setImageData(getImageData(60));
//            builder.setFinancialView(getPropertyFinancial());
//            return builder.build();
//        }
//        return null;
//    }

    @Override
    public PropertyDataDetailList getPropertyFeedByCity(String customerUUid, int cityId) {
        return getTempFeed();
    }

    @Override
    public PropertyDataDetailList getPropertyFeedByCity(String customerUUid, String city) {

        String url = String.format(ApiConstants.PROPERTY_FEED + "/customer/%s/property/%s", customerUUid, city);
        response = httpClient.get(MediaType.APPLICATION_XML, url, null);
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public CustomerList getCustomerList() {
        response = httpClient.get(MediaType.APPLICATION_XML, ApiConstants.ADMIN_MP + "/customer/list", null);
        CustomerList list = response.getEntity(CustomerList.class);
        return list;
    }

    @Override
    public Customer getCustomer(String customerName) {


        return new Customer("a4e62a00-c217-11e2-8b8b-0800200c9a66", "slvrstream", false);
    }

    @Override
    public Customer getCustomerByUUId(String customerUUId) {

        return new Customer("a4e62a00-c217-11e2-8b8b-0800200c9a66", "slvrstream", false);
    }

    @Override
    public List<StateCity> getStateCityList(String customerUUId) {

        // Create test object
//        StateCity scv;
        StateCity scv;
        List<StateCity> scvl  = new ArrayList<StateCity>();
        
//        StateCityList scvl = new StateCityList();
        int id = 1;

        // Kansas
        scv = new StateCityView();
        City city = new City();
        State state = new State();
        state.setId(1);
        state.setStateName("OH");
        city.setId(id);
        city.setCityName("COLUMBUS");
        city.setStateId(state.getId());
        city.setSummary("Columbus, Ohio has a generally strong and diverse economy based on education, " +
                "insurance, banking, fashion, defense, aviation, food, logistics, steel, energy, medical research, health care, " +
                "hospitality, retail, and technology. Overall, it was ranked as one of the top 10 best big cities in the country in 2010, " +
                "according to Relocate America, a real estate research firm.  MarketWatch ranked Columbus and its metro area as the No. 7 best place in the country to operate a business in 2008.  In 2007, the cityId was ranked No. 3 in the United States by fDi magazine for “Cities of the Future”, and No. 4 for most business-friendly in the country. Columbus was ranked as the seventh strongest economy in the United States in 2006, and the best in Ohio, according to Policom Corp. In 2011, the Columbus metropolitan area’s GDP was $94.7 billion, " +
                "up from $90 billion in 2009, up from $85.5 billion in 2006, $75.43 billion in 2005, and $69.98 billion in 2001.");
        city.setImageUrl("columbus.jpg");
        scv.setCity(city);
        scvl.add(scv);

        scv = new StateCityView();
        state = new State();
        state.setId(2);
        state.setStateName("MO");
        city = new City();
        city.setId(id);
        city.setCityName(String.format("KANSAS CITY"));
        city.setStateId(state.getId());
        city.setSummary("Kansas City, Missouri may seem to be well deserving of its “cow-town” reputation.  " +
                "After all, historically speaking, Kansas City grew up out of the prosperity created by the local " +
                "cattle markets strategically located at the crossroads of key national rail lines.  However, any local will tell you that it would be a mistake to reduce Kansas City to a stagnant creature of its historical origins.");
        city.setImageUrl("kansascvity.png");
        scv.setCity(city);
        scvl.add(scv);

        scv = new StateCityView();
        state = new State();
        state.setId(2);
        state.setStateName("IN");
        city = new City();
        city.setId(id);
        city.setCityName(String.format("INDIANAPOLIS"));
        city.setStateId(state.getId());
        city.setSummary("Indianapolis, Indiana is the eleventh largest cityId in the United States, and it is by-far one of our country’s most livable big cities.  Indianapolis is a cityId located in the Great Lakes region of the United States. " +
                "Indianapolis is the capital of the US stateName of Indiana, and one of the fastest growing metropolitan areas in the United States.");
        city.setImageUrl("indy.png");
        scvl.add(scv);

//        scv = new StateCityView();
//        scv.setCityId(id);
//        scv.setCity(String.format("INDIANAPOLIS"));
//        scv.setState("IN");
//        scv.setSummary("Indianapolis, Indiana is the eleventh largest cityId in the United States, and it is by-far one of our country’s most livable big cities.  Indianapolis is a cityId located in the Great Lakes region of the United States. " +
//                "Indianapolis is the capital of the US stateName of Indiana, and one of the fastest growing metropolitan areas in the United States.");
//        scv.setImageUrl("kansascvity.png");
//        scvl.add(scv);
//
//        scv = new StateCityView();
//        scv.setCityId(id);
//        scv.setCity(String.format("TOLEDO"));
//        scv.setState("OH");
//
//        scv.setImageUrl("toledo.jpg");
//        scv.setSummary("Toledo, Ohio  is the fourth most populous cityId in the U.S. stateName of Ohio and is the county seat of Lucas County. Toledo is in northwest Ohio, located on the Maumee River on the western end of Lake Erie, and borders the State of Michigan.  It is one of the most productive Ports on the Great Lakes/St. Lawrence Seaway, and is a designated Foreign Trade Zone area. The Port of Toledo handles coal, ore, general cargo, and ship repairs, as well as having storage for over 22 million bushels of grain for export. The diverse architecture of Toledo rivals larger cities like Chicago. " +
//                "It is also home to Libby Glass, the founders of which had a tremendously positive influence on the amenities of the City.");
//        scvl.add(scv);
//
//        scv = new StateCityView();
//        scv.setCityId(id);
//        scv.setCity(String.format("BIRMINGHAM"));
//        scv.setState("AL");
//        scv.setImageUrl("birmingham.png");
//        scv.setSummary("Birmingham, Alabama is a municipal corporation under the laws of the State of Alabama. " +
//                "Birmingham is the largest cityId in the stateName with a population currently estimated at 242,820, and a metro population of 1,079,089.");
//        scvl.add(scv);


        return scvl;
    }

    @Override
    public City getCity(int cityId) {


        City city = new City(1, "COLUMBUS", "Columbus, Ohio has a generally strong and diverse economy based on education, " +
                "insurance, banking, fashion, defense, aviation, food, logistics, steel, energy, medical research, health care, hospitality, retail, and technology. Overall, it was ranked as one of the top 10 best big cities in the country in 2010, according to Relocate America, a real estate research firm.  MarketWatch ranked Columbus and its metro area as the No. 7 best place in the country to operate a business in 2008.  In 2007, the cityId was ranked No. 3 in the United States by fDi magazine for “Cities of the Future”, and No. 4 for most business-friendly in the country. Columbus was ranked as the seventh strongest economy in the United States in 2006, and the best in Ohio, according to Policom Corp. In 2011, the Columbus metropolitan area’s GDP was $94.7 billion, up from $90 billion in 2009, up from $85.5 billion in 2006, $75.43 billion in 2005, and $69.98 billion in 2001.", "columbus.jpg",1);

        return city;

    }

    @Override
    public List<StateCity> getStateCity(String city) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<StateCityView> getStateCity(int zipCode) {

        List<StateCityView> list = new ArrayList<StateCityView>();
        StateCityView scv = new StateCityView();
        scv.setId(1);
//        scv.setCity("COLUMBUS");
//        scv.setSummary("Columbus, Ohio has a generally strong and diverse economy based on education, insurance, banking, fashion, defense, aviation, food, logistics, steel, energy, medical research, health care, hospitality, retail, and technology. Overall, it was ranked as one of the top 10 best big cities in the country in 2010, according to Relocate America, a real estate research firm.  MarketWatch ranked Columbus and its metro area as the No. 7 best place in the country to operate a business in 2008.  In 2007, the cityId was ranked No. 3 in the United States by fDi magazine for “Cities of the Future”, and No. 4 for most business-friendly in the country. Columbus was ranked as the seventh strongest economy in the United States in 2006, and the best in Ohio, according to Policom Corp. In 2011, " +
//                "the Columbus metropolitan area’s GDP was $94.7 billion, up from $90 billion in 2009, up from $85.5 billion in 2006, $75.43 billion in 2005, and $69.98 billion in 2001.");
//        scv.setState("OH");
        scv.setZip(zipCode);
        list.add(scv);

        return list;
    }

    @Override
    public List<Pagelayout> getPageLayout(String pageName) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private PropertyDataDetailList getTempFeed() {
        PropertyDataDetailList list = new PropertyDataDetailList();
        PropertyData pd;
        PropertyDataDetailBuilder builder;
//
//        pd = new PropertyData();
//        pd.setId(36);
//        pd.setCustomerUuid("a1b48900-5944-4c7d-b877-04a7332ceb7d");
//        pd.setPrice(55900);
//        pd.setDataSourceId(1);
//        pd.setZip(35211);
//        pd.setDescription("Great home by the college. Quiet neighborhood. New roof. New flooring throughout. New paint throughout. Brand new Furnace and A/C.  Priced well under market at $34 Sqft.");
//        pd.setNumBaths(2);
//        pd.setNumBeds(3);
//        pd.setPropName("1405 17th Way SW");
//        pd.setSqft("1645");
//        pd.setStatus("Active");
//        pd.setType("SFR");
//
//        builder = new PropertyFeedBuilder(pd);
//        builder.setDataSource("Cool Source").setStateName("AL").setCityName("BIRMINGHAM");
//        builder.setImageData(getImageData(36));
//        builder.setFinancialView(getPropertyFinancial());
//        list.addToList(builder.build());
//
//        pd = new PropertyData();
//        pd.setId(53);
//        pd.setCustomerUuid("eb4e2198-6224-4ca9-86d3-0461aa5f6d5c");
//        pd.setPrice(46500);
//        pd.setDataSourceId(1);
//        pd.setZip(35208);
//        pd.setDescription("Great home in a Great market!");
//        pd.setNumBaths(1);
//        pd.setNumBeds(3);
//        pd.setPropName("1328 43rd St Ensley");
//        pd.setSqft("1600");
//        pd.setStatus("Active");
//        pd.setType("SFR");
//
//        builder = new PropertyFeedBuilder(pd);
//        builder.setDataSource("Cool Source").setStateName("AL").setCityName("BIRMINGHAM");
//        builder.setImageData(getImageData(53));
//        builder.setFinancialView(getPropertyFinancial());
//        list.addToList(builder.build());
//
//        pd = new PropertyData();
//        pd.setId(60);
//        pd.setPropName("2672 20th Street");
//        pd.setCustomerUuid("1f99dee2-d892-439a-a9ce-2570fce95a94");
//        pd.setPrice(39000);
//        pd.setDataSourceId(1);
//        pd.setZip(35208);
//        pd.setDescription("Great Section 8 tenant! Full rehab. No carpet means less maintenance!");
//        pd.setNumBaths(1);
//        pd.setNumBeds(2);
//        pd.setSqft("1200");
//        pd.setStatus("Active");
//        pd.setType("SFR");
//
//        builder = new PropertyFeedBuilder(pd);
//        builder.setDataSource("Cool Source").setStateName("AL").setCityName("BIRMINGHAM");
//        builder.setImageData(getImageData(60));
//        builder.setFinancialView(getPropertyFinancial());
//        list.addToList(builder.build());

        return list;
    }

    private List<PropertyImageData> getImageData(int propId) {


        List<PropertyImageData> idl = new ArrayList<PropertyImageData>();
        PropertyImageData id;

        if(propId==36){
           id = new PropertyImageData(1, "1405 17th front.jpeg", "https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000003SaoY/50f4a2b41a44b/1405+17th+front.jpeg", "header", 1);
            idl.add(id);
        }else if(propId==53){
            id = new PropertyImageData(2, "1328_Ensley_1.jpeg", "https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSZ/5061faa621237/1328_Ensley_1.jpeg", "header", 1);
            idl.add(id);
        }else if(propId==60){
            id = new PropertyImageData(1, "Main.jpeg", "https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000001PQSb/5061f296c8215/Main.jpeg", "header", 1);
            idl.add(id);
        }


//        idl.add(id);
//        id = new PropertyImageData(2, "1_curbnew_roof.jpeg", "https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9wy/51251d8b2b918/1_curbnew_roof.jpeg", "header", 1);
//        idl.add(id);
//        id = new PropertyImageData(2, "1_Curb_Holmes.jpeg", "https://s3.amazonaws.com/propertybase-clients/00DE0000000bG9UMAU/a0CE0000004M9x3/512510867ae19/1_Curb_Holmes.jpeg", "header", 1);
//        idl.add(id);
        return idl;
    }

    private List<PropertyFinancialView> getPropertyFinancial() {
        List<PropertyFinancialView> pfl = new ArrayList<PropertyFinancialView>();
        PropertyFinancialView pf = new PropertyFinancialView(1, "a4e62a00-c217-11e2-8b8b-0800200c9a6", new BigDecimal(287.46), "monthly_cash_flow_with_financing_2__c", "Cash flow (with financing)", 2);
        pfl.add(pf);
        pf = new PropertyFinancialView(1, "a4e62a00-c217-11e2-8b8b-0800200c9a6", new BigDecimal(15.24), "financed_net_yield_1__c", "Net Yield w/Financing (ROI)", 3);
        pfl.add(pf);

        pf = new PropertyFinancialView(1, "a4e62a00-c217-11e2-8b8b-0800200c9a6", new BigDecimal(22.55), "financed_net_yield_2__c", "Est Net Yield (ROI)", 3);
        pfl.add(pf);


        pf = new PropertyFinancialView(1, "a4e62a00-c217-11e2-8b8b-0800200c9a6", new BigDecimal(33.98), "price_per_ft_c", "Price /SQFT", 3);
        pfl.add(pf);

        pf = new PropertyFinancialView(1, "a4e62a00-c217-11e2-8b8b-0800200c9a6", new BigDecimal(70.00), "est_replacement_cost_per_sq_ft__c", "Est. Replacement /SQFT", 3);
        pfl.add(pf);


        pf = new PropertyFinancialView(1, "a4e62a00-c217-11e2-8b8b-0800200c9a6", new BigDecimal(302.79), "interest_payment_1__c", "Monthly Interest", 3);
        pfl.add(pf);

        pf = new PropertyFinancialView(1, "a4e62a00-c217-11e2-8b8b-0800200c9a6", new BigDecimal(0.729), "est_of_market_value__c", "Estimated % of Market Value", 3);
        pfl.add(pf);

        pf = new PropertyFinancialView(1, "a4e62a00-c217-11e2-8b8b-0800200c9a6", new BigDecimal(76800.0), "est_value_per_rent_multiplier__c", "", 3);
        pfl.add(pf);

        pf = new PropertyFinancialView(1, "a4e62a00-c217-11e2-8b8b-0800200c9a6", new BigDecimal(9600.0), "annual_rents__c", "Estimated Value per Rent Value Multiplier", 3);
        pfl.add(pf);

        pf = new PropertyFinancialView(1, "a4e62a00-c217-11e2-8b8b-0800200c9a6", new BigDecimal(800.0), "monthlyrent__c", "Monthly Rent", 3);
        pfl.add(pf);

        pf = new PropertyFinancialView(1, "a4e62a00-c217-11e2-8b8b-0800200c9a6", new BigDecimal(105.58), "monthly_taxes__c", "Monthly Taxes", 3);
        pfl.add(pf);
        pf = new PropertyFinancialView(1, "a4e62a00-c217-11e2-8b8b-0800200c9a6", new BigDecimal(1267.0), "taxes__c", "Annual Taxes", 3);
        pfl.add(pf);

        pf = new PropertyFinancialView(1, "a4e62a00-c217-11e2-8b8b-0800200c9a6", new BigDecimal(41.67), "monthly_insurance__c", "Monthly Hazard Insurance", 3);
        pfl.add(pf);

        pf = new PropertyFinancialView(1, "a4e62a00-c217-11e2-8b8b-0800200c9a6", new BigDecimal(500.0), "insurance__c", "Annual Insurance", 3);
        pfl.add(pf);

        pf = new PropertyFinancialView(1, "a4e62a00-c217-11e2-8b8b-0800200c9a6", new BigDecimal(80.0), "monthly_management__c", "Monthly Management Fee", 3);
        pfl.add(pf);

        pf = new PropertyFinancialView(1, "a4e62a00-c217-11e2-8b8b-0800200c9a6", new BigDecimal(960.0), "management__c", "Annual Management Fee", 3);
        pfl.add(pf);

         pf = new PropertyFinancialView(1, "a4e62a00-c217-11e2-8b8b-0800200c9a6", new BigDecimal(572.75), "monthly_cash_flow__c", "Monthly Cash Flow", 3);
        pfl.add(pf);

        pf = new PropertyFinancialView(1, "a4e62a00-c217-11e2-8b8b-0800200c9a6", new BigDecimal(6873.0), "noi__c", "Annual Cash Flow", 3);
        pfl.add(pf);
        pf = new PropertyFinancialView(1, "a4e62a00-c217-11e2-8b8b-0800200c9a6", new BigDecimal(12.3), "cash_net_yield__c", "Cash Net Yield", 3);
        pfl.add(pf);


        return pfl;
    }
}
