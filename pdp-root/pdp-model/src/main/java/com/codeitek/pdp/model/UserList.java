package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 3/13/13
 * Time: 2:03 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "userList")
public class UserList extends GenericList<User> {

    @XmlElement(name = "users")
    @Override
    public List<User> getList() {
        return this.list;
    }
}
