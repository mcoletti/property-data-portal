package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/25/13
 * Time: 7:51 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "groupView")
public class GroupView extends Groups implements Serializable {

    private List<GroupMembers> groupMembers;

    public GroupView(int id, String groupName) {
        super(id, groupName);
    }

    public GroupView(int id, String groupName, List<GroupMembers> groupMembers) {
        super(id, groupName);
        this.groupMembers = groupMembers;
    }

    public List<GroupMembers> getGroupMembers() {
        return groupMembers;
    }

    public void setGroupMembers(List<GroupMembers> groupMembers) {
        this.groupMembers = groupMembers;
    }
}
