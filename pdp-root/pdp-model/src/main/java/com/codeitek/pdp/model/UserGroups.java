package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/25/13
 * Time: 7:50 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "userGroups")
@XmlType(name = "userGroups",namespace = PDPServiceConstants.NAMESPACE)
public class UserGroups implements Serializable {


    private List<GroupView> groups;
    private List<SystemGroupView> systemGroups;

    public UserGroups() {
    }

    /**
     * Full Constructor
     * @param groups
     * @param systemGroups
     */
    public UserGroups(List<GroupView> groups, List<SystemGroupView> systemGroups) {
        this.groups = groups;
        this.systemGroups = systemGroups;
    }
    @XmlElement
    public List<GroupView> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupView> groups) {
        this.groups = groups;
    }
    @XmlElement
    public List<SystemGroupView> getSystemGroups() {
        return systemGroups;
    }

    public void setSystemGroups(List<SystemGroupView> systemGroups) {
        this.systemGroups = systemGroups;
    }
}
