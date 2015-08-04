package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/27/13
 * Time: 9:41 PM
 * To change this template use File | Settings | File Templates.
 */

@XmlRootElement(name = "userDetail")
@XmlType(name = "userDetail",namespace = PDPServiceConstants.NAMESPACE)
public class UserDetail extends User {


    private List<UserAttributes> userAttributes;
    private AccountLevel accountLevel;
    private List<RoleData> userRoles;



    public UserDetail() {
    }

    public UserDetail(String uuid, String userName, String firstName, String lastName, String primaryEmail, String referredBy, String gender, boolean deleteInd, String customerUuid, Date lastLoginDtm, boolean lockInd, int accountLevelId, List<UserAttributes> userAttributes, AccountLevel accountLevel, List<RoleData> userRoles,String authToken,Date authTokenExpirationDate) {
        super(uuid, userName, firstName, lastName, primaryEmail, referredBy, gender, deleteInd, customerUuid, lastLoginDtm, lockInd, accountLevelId,authToken,authTokenExpirationDate);
        this.userAttributes = userAttributes;
        this.accountLevel = accountLevel;
        this.userRoles = userRoles;
    }

    @XmlElement
    public List<UserAttributes> getUserAttributes() {
        return userAttributes;
    }

    public void setUserAttributes(List<UserAttributes> userAttributes) {
        this.userAttributes = userAttributes;
    }

    @XmlElement
    public AccountLevel getAccountLevel() {
        return accountLevel;
    }

    public void setAccountLevel(AccountLevel accountLevel) {
        this.accountLevel = accountLevel;
    }

    @XmlElement
    public List<RoleData> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<RoleData> userRoles) {
        this.userRoles = userRoles;
    }

}
