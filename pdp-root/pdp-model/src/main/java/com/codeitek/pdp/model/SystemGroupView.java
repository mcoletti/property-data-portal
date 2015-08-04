package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/25/13
 * Time: 7:55 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "systemGroupView")
public class SystemGroupView extends SystemRoles implements Serializable {


    private List<SystemGroupMembers> groupMembers;

    public SystemGroupView(int id, String roleName, boolean activeInd, int creUserId, Date creDtm) {
        super(id, roleName, activeInd, creUserId, creDtm);
    }

    public List<SystemGroupMembers> getGroupMembers() {
        return groupMembers;
    }

    public void setGroupMembers(List<SystemGroupMembers> groupMembers) {
        this.groupMembers = groupMembers;
    }
}
