package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/25/13
 * Time: 7:48 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "userDetailView")
@XmlType(name = "userDetailView",namespace = PDPServiceConstants.NAMESPACE)
public class UserDetailView extends User implements Serializable {

    private List<UserAttributes> userAttributes;
    private List<RoleData> roles;
    private List<UserGroups> userGroups;
    private Customer customer;

    public UserDetailView() {
    }

    /**
     *
     * @param user
     */
    public UserDetailView(User user) {
        super(user);
    }

    /**
     *
     * @param user
     * @param userAttributes
     * @param roles
     * @param userGroups
     * @param customer
     */
    public UserDetailView(User user, List<UserAttributes> userAttributes,List<RoleData> roles, List<UserGroups> userGroups, Customer customer) {
        super(user);
        this.userAttributes = userAttributes;
        this.roles = roles;
        this.userGroups = userGroups;
        this.customer = customer;
    }
    @XmlElement
    public List<UserAttributes> getUserAttributes() {
        return userAttributes;
    }

    public void setUserAttributes(List<UserAttributes> userAttributes) {
        this.userAttributes = userAttributes;
    }
    @XmlElement
    public List<RoleData> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleData> roles) {
        this.roles = roles;
    }
    @XmlElement
    public List<UserGroups> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(List<UserGroups> userGroups) {
        this.userGroups = userGroups;
    }
    @XmlElement
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
