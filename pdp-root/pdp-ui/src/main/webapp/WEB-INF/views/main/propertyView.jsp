<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mcoletti
  Date: 4/24/13
  Time: 7:08 AM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page import="com.codeitek.pdp.model.*" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.List" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="java.util.Locale" %>
<%@ include file="/WEB-INF/views/layouts/taglibs.jsp" %>
<%@ include file="/WEB-INF/views/layouts/includes.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="page">
<%
    PropertyDataDetail feed = (PropertyDataDetail) request.getAttribute("propertyFeed");
    Customer customer = (Customer) request.getAttribute("customer");

%>
    <header class="pageHeader">
        <nav class="pageCrumbs">
            <a class="pageCrumb" href="../main/loadPropertyList?cityId=<%=feed.getStateCity().getCityId()%>">Back</a>
            <span class="pageCrumb">></span>
            <strong class="pageCrumb">Property: <%=feed.getPropName()%>
            </strong>
        </nav>

        <%
            PropertyImageData image = null;
            List<PropertyImageData> images = feed.getImageDataList();

                if (images != null) {
                    image = images.get(0);
        %>

                    <%
                        }
                    %>
        <div>
            <div style="margin-top: 10px">
                <h2 style="color: #ffffff"><%=feed.getPropName()%></h2>
            </div>
            <div style="margin-left: 600px;;top:125px;z-index: 1;position: absolute">
               <%
                   if (image != null) {
               %>
                <div style="box-shadow: 10px 5px 5px #888888;background-color: #fff;width: 100%">
                    <a class="fancybox-effects-c" href="<%=image.getImageUrl()%>"
                       title="<%=feed.getPropName()%>">
                        <img class="img med" src="<%=image.getImageUrl()%>"></a>
                </div>

               <%
               } else {
               %>
                <div class="lstImg ui-corner-all">
                    <a href="#" title="Image Not-Found">
                        <img class="ui-corner-all" style="margin-left: 5px;width: 75px;height: 75px"
                             src="../resources/images/assets/not-found.jpg" alt=""/></a>
                </div>
                <%
                    }
                %>
            </div>
        </div>


        <nav class="pageNav">
            <a href="#">Property Calculator</a>
            <a href="#">Photo Gallery</a>
        </nav>
    </header>
    <section class="con">
        <header class="conHeader">
            <div style="width: 500px;margin-left: 10px;margin-bottom: 10px;margin-top: 20px">
            <p style="text-align: center;font-weight: bold"><%=feed.getDescription()%></p>
            </div>
        </header>
        <div class="conBody" style="width: 500px;margin-left: 10px">

            <table class="table table320">
                <thead>
                <tr>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td class="w40"><label class="textlrg">Address:</label> </td>
                    <td class="w60"><%=feed.getPropName()%></td>
                </tr>
                <tr>
                    <td class="w40"><label class="textlrg">Status:</label> </td>
                    <td class="w60"><%=feed.getStatus()%></td>
                </tr>
                <tr>
                    <td class="w40"><label class="textlrg">City:</label> </td>
                    <td class="w60"><%=feed.getCity()%></td>
                </tr>
                <tr>
                    <td class="w40"><label class="textlrg">Bedrooms:</label> </td>
                    <td class="w60"><%=feed.getNumBeds()%></td>
                </tr>
                <tr>
                    <td class="w40"><label class="textlrg">Baths:</label> </td>
                    <td class="w60"><%=feed.getNumBaths()%></td>
                </tr>
                <tr>
                    <td class="w40"><label class="textlrg">Year Built:</label> </td>
                    <td class="w60">1960</td>
                </tr>
                <tr>
                    <td class="w40"><label class="textlrg">SQFT:</label> </td>
                    <td class="w60"><%=feed.getSqft()%></td>
                </tr>

                </tbody>
            </table>
        </div>
    </section>
    <%
        // Get property Financial Data

        NumberFormat format = NumberFormat.getCurrencyInstance();
        Float wholeSale = feed.getPrice();

        int sqft = Integer.parseInt(feed.getSqft());
        BigDecimal pricePerSqft = new BigDecimal(0);
        NumberFormat fCurrency = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat fPercent = NumberFormat.getPercentInstance(Locale.US);
        BigDecimal estReplacementCost = new BigDecimal(0);
        BigDecimal monthlyCashFlow = new BigDecimal(0);
        BigDecimal monthlyRent = new BigDecimal(0);
        BigDecimal annualRent = new BigDecimal(0);
        BigDecimal monthlyTax = new BigDecimal(0);
        BigDecimal annualTax = new BigDecimal(0);
        BigDecimal estValueMultiplier = new BigDecimal(0);
        BigDecimal estMarketValue = new BigDecimal(0);
        BigDecimal monthlyIns = new BigDecimal(0);
        BigDecimal annualIns = new BigDecimal(0);
        BigDecimal mngtFee = new BigDecimal(0);
        BigDecimal mngtAnnualFee = new BigDecimal(0);
        BigDecimal annualCashFlow = new BigDecimal(0);
        BigDecimal monthlyInPayment = new BigDecimal(0);
        BigDecimal downpay2 = new BigDecimal(0);
        BigDecimal downpay1 = new BigDecimal(0);
        BigDecimal intRate1 = new BigDecimal(0);
        BigDecimal intRate2 = new BigDecimal(0);
        BigDecimal netYeild = new BigDecimal(0);
        BigDecimal annualIntPayment = new BigDecimal(0);
        BigDecimal cashFlowWF1 = new BigDecimal(0);
        BigDecimal annualCashFlowWF = new BigDecimal(0);
        BigDecimal intpaymentWF2 = new BigDecimal(0);
        BigDecimal monthlyCachFlowWF = new BigDecimal(0);
        BigDecimal annualCacshFlowWF = new BigDecimal(0);
        BigDecimal netYeildWF = new BigDecimal(0);
        for (PropertyFinancialView pf : feed.getFinancialList()) {

            if (Constants.EST_REPL_CPSQFT_C.equals(pf.getFinancialKey())) {
                estReplacementCost = pf.getValue();
            }
            if (Constants.MOTHLY_CFWF2_C.equals(pf.getFinancialKey())) {
                monthlyCashFlow = pf.getValue();
            }
            if (Constants.MONTHLY_RENT_C.equals(pf.getFinancialKey())) {
                monthlyRent = pf.getValue();
            }
            if (Constants.ANNUAL_RENT_C.equals(pf.getFinancialKey())) {
                annualRent = pf.getValue();
            }
            if ("monthly_taxes__c".equals(pf.getFinancialKey())) {
                monthlyTax = pf.getValue();
            }
            if ("taxes__c".equals(pf.getFinancialKey())) {
                annualTax = pf.getValue();
            }
            if ("price_per_ft_c".equals(pf.getFinancialKey())) {
                pricePerSqft = pf.getValue();
            }
            if ("est_value_per_rent_multiplier__c".equals(pf.getFinancialKey())) {
                estValueMultiplier = pf.getValue();
            }
            if ("est_of_market_value__c".equals(pf.getFinancialKey())) {
                estMarketValue = pf.getValue().divide(BigDecimal.valueOf(100));
            }
            if ("monthly_insurance__c".equals(pf.getFinancialKey())) {
                monthlyIns = pf.getValue();
            }
            if ("insurance__c".equals(pf.getFinancialKey())) {
                annualIns = pf.getValue();
            }
            if ("monthly_management__c".equals(pf.getFinancialKey())) {
                mngtFee = pf.getValue();
            }
            if ("management__c".equals(pf.getFinancialKey())) {
                mngtAnnualFee = pf.getValue();
            }
            if ("noi__c".equals(pf.getFinancialKey())) {
                annualCashFlow = pf.getValue();
            }
            if ("interest_payment_1__c".equals(pf.getFinancialKey())) {
                monthlyInPayment = pf.getValue();
            }
            if ("yearly_interest_payment_1__c".equals(pf.getFinancialKey())) {
                annualIntPayment = pf.getValue();
            }
            if ("down_payment_1__c".equals(pf.getFinancialKey())) {
                downpay1 = pf.getValue();
            }
            if ("down_payment_2__c".equals(pf.getFinancialKey())) {
                downpay2 = pf.getValue();
            }
            if ("interest_rate_1__c".equals(pf.getFinancialKey())) {
                intRate1 = pf.getValue().divide(BigDecimal.valueOf(100));
            }
            if ("interest_rate_2__c".equals(pf.getFinancialKey())) {
                intRate2 = pf.getValue().divide(BigDecimal.valueOf(100));
            }
            if ("financed_net_yield_1__c".equals(pf.getFinancialKey())) {
                netYeild = pf.getValue().divide(BigDecimal.valueOf(100));
            }
            if ("monthly_cash_flow_with_financing_1__c".equals(pf.getFinancialKey())) {
                cashFlowWF1 = pf.getValue();
            }
            if ("noi_with_financing_1__c".equals(pf.getFinancialKey())) {
                annualCashFlowWF = pf.getValue();
            }
            if ("monthly_interest_payment_2__c".equals(pf.getFinancialKey())) {
                intpaymentWF2 = pf.getValue();
            }
            if ("monthly_cash_flow_with_financing_2__c".equals(pf.getFinancialKey())) {
                monthlyCachFlowWF = pf.getValue();
            }
            if ("noi_with_financing_2__c".equals(pf.getFinancialKey())) {
                annualCacshFlowWF = pf.getValue();
            }
            if ("financed_net_yield_2__c".equals(pf.getFinancialKey())) {
                netYeildWF = pf.getValue().divide(BigDecimal.valueOf(100));
            }


            pf.getFinancialKey();

        }

    %>
    <section class="con">
        <header class="conHeader" style="margin-bottom: 15px;margin-left: 10px">
            <div class="shadowBox ui-corner-all">
                <h2 style="color: #ffffff;padding-left: 5px">Price Information</h2>
            </div>
        </header>
        <div class="conBody" style="width: 700px;margin-left: 20px">
            <table class="table table320">
                <thead>
                <tr>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td class="w40"><label class="textlrg">Wholesale Price</label> </td>
                    <td class="w60"><%=fCurrency.format(wholeSale)%></td>
                </tr>
                <tr>
                    <td class="w50"><label class="textlrg">Est. Replacement</label> </td>
                    <td class="w25">$ 115150.0</td>
                </tr>
                <tr>
                    <td class="w50"><label class="textlrg">Est. Replacement/SQFT</label> </td>
                    <td class="w25"><%=fCurrency.format(pricePerSqft)%></td>
                </tr>
                <tr>
                    <td class="w50"><label class="textlrg">Estimated Value per Rent Value Multiplier</label> </td>
                    <td class="w25"><%=fCurrency.format(estValueMultiplier)%></td>
                </tr>

                <tr>
                    <td class="w50"><label class="textlrg">Estimated Value per Rent Value Multiplier</label> </td>
                    <td class="w25"><%=fCurrency.format(estValueMultiplier)%></td>
                </tr>
                <tr>
                    <td class="w50"><label class="textlrg">Estimated % of Market Value</label> </td>
                    <td class="w25"><%=fPercent.format(estMarketValue)%></td>
                </tr>
                </tbody>
            </table>
        </div>

    </section>
    <section class="con">
        <header class="conHeader" style="margin-bottom: 15px;margin-left: 10px">
            <div  class="shadowBox ui-corner-all">
                <h2 style="color: #ffffff;padding-left: 5px">Cash Flow Analysis</h2>
            </div>
        </header>
        <div class="conBody" style="width: 700px;margin-left: 20px">

            <table class="table table320">
                <thead>
                <tr>
                <th></th>
                    <th>Monthly</th>
                    <th>Annually</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                   <td class="w50"><label class="textlrg">Est rental income</label> </td>
                   <td class="w25"><%=fCurrency.format(monthlyRent)%></td>
                   <td class="w25"><%=fCurrency.format(annualRent)%></td>
                </tr>
                <tr>
                   <td class="w50"><label class="textlrg">Property taxes</label> </td>
                   <td class="w25"><%=fCurrency.format(monthlyTax)%></td>
                   <td class="w25"><%=fCurrency.format(annualTax)%></td>
                </tr>
                <tr>
                   <td class="w50"><label class="textlrg">Hazard insurance</label> </td>
                   <td class="w25"><%=fCurrency.format(monthlyIns)%></td>
                   <td class="w25"><%=fCurrency.format(annualIns)%></td>
                </tr>
                <tr>
                   <td class="w50"><label class="textlrg">Management fee</label> </td>
                   <td class="w25"><%=fCurrency.format(mngtFee)%></td>
                   <td class="w25"><%=fCurrency.format(mngtAnnualFee)%></td>
                </tr>
                <tr>
                   <td class="w50"><label class="textlrg">Cash flow</label> </td>
                   <td class="w25"><%=fCurrency.format(monthlyCashFlow)%></td>
                   <td class="w25"><%=fCurrency.format(annualCashFlow)%></td>
                </tr>
                </tbody>
            </table>

        </div>
    </section>
    <section class="con">
        <header class="conHeader" style="margin-bottom: 15px;margin-left: 10px">
            <div class="shadowBox ui-corner-all">
                <h2 style="color: #ffffff;padding-left: 5px">Financing Options</h2>
            </div>
        </header>
        <div class="conBody" style="width: 700px;margin-left: 20px">
            <h2>Non–Recourse Financing 50%</h2>
            <table class="table table320">
                <thead>
                <tr>
                <th></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                   <td class="w60"><label class="textlrg">Down Payment</label> </td>
                   <td class="w40"><%=fCurrency.format(downpay1)%></td>
                </tr>
                <tr>
                   <td class="w60"><label class="textlrg">Term</label> </td>
                   <td class="w40">Interest Only W 3 Year Balloon</td>
                </tr>
                <tr>
                   <td class="w60"><label class="textlrg">Interest Rate</label> </td>
                   <td class="w40"><%=fPercent.format(intRate1)%></td>
                </tr>

                </tbody>
            </table>
            <iframe src=""></iframe>
            <div>&nbsp;</div>
            <table class="table table320">
                <thead>
                <tr>
                    <th></th>
                    <th>Monthly</th>
                    <th>Annually</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td class="w50"><label class="textlrg">Interest Payment</label> </td>
                    <td class="w25"><%=fCurrency.format(monthlyInPayment)%></td>
                    <td class="w25"><%=fCurrency.format(annualIntPayment)%></td>
                </tr>
                <tr>
                    <td class="w50"><label class="textlrg">Cash flow</label><label class="textlrg bold"> (with financing)</label> </td>
                    <td class="w25"><%=fCurrency.format(cashFlowWF1)%></td>
                    <td class="w25"><%=fCurrency.format(annualCashFlowWF)%></td>
                </tr>
                <tr>
                    <td class="w50"><label class="textlrg bold">Est Net Yield (ROI)</label> </td>
                    <td class="w25">&nbsp;</td>
                    <td class="w25"><%=fPercent.format(netYeild)%></td>
                </tr>


                </tbody>
            </table>
            <div style="margin-top: 10px">&nbsp;</div>
            <h2>Conventional Financing 70%</h2>
            <table class="table table320">
                <thead>
                <tr>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td class="w60"><label class="textlrg">Down Payment</label> </td>
                    <td class="w40"><%=fCurrency.format(downpay2)%></td>
                </tr>
                <tr>
                    <td class="w60"><label class="textlrg">Term</label> </td>
                    <td class="w40">30 Year Amortized</td>
                </tr>
                <tr>
                    <td class="w60"><label class="textlrg">Interest Rate</label> </td>
                    <td class="w40"><%=fPercent.format(intRate2)%></td>
                </tr>

                </tbody>
            </table>
            <div>&nbsp;</div>
            <table class="table table320">
                <thead>
                <tr>
                    <th></th>
                    <th>Monthly</th>
                    <th>Annually</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td class="w50"><label class="textlrg">Interest Payment</label> </td>
                    <td class="w25"><%=fCurrency.format(intpaymentWF2)%></td>
                    <td class="w25"></td>
                </tr>
                <tr>
                    <td class="w50"><label class="textlrg">Cash flow</label><label class="textlrg bold">(with financing)</label> </td>
                    <td class="w25"><%=fCurrency.format(monthlyCachFlowWF)%></td>
                    <td class="w25"><%=fCurrency.format(annualCacshFlowWF)%></td>
                </tr>
                <tr>
                    <td class="w50"><label class="textlrg bold">Est Net Yield (ROI)</label> </td>
                    <td class="w25">&nbsp;</td>
                    <td class="w25"><%=fPercent.format(netYeildWF)%></td>
                </tr>


                </tbody>
            </table>
        </div>

    </section>
<div class="w100" style="margin-top: 10px">
    <div style="background-color: #000;" class="w100">
        <h2 style="color: #fff;margin-left: 5px"><%=customer.getFullName()%></h2>
    </div>

</div>

</div>

