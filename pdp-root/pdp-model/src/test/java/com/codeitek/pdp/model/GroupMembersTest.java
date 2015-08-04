package com.codeitek.pdp.model;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/25/13
 * Time: 1:37 AM
 * To change this template use File | Settings | File Templates.
 */
public class GroupMembersTest {

    private GroupMembers groupMembers;

    @BeforeClass
    public void init(){
          groupMembers = new GroupMembers(1,"1234",1);
    }

    @BeforeMethod
    public void setUp() throws Exception {

    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetId() throws Exception {
          int actual = groupMembers.getId();
        Assert.assertEquals(actual,1);
    }

    @Test
    public void testSetId() throws Exception {

    }

    @Test
    public void testGetUserUuid() throws Exception {

    }

    @Test
    public void testSetUserUuid() throws Exception {

    }

    @Test
    public void testGetGroupsId() throws Exception {

    }

    @Test
    public void testSetGroupsId() throws Exception {

    }

    @Test
    public void testEquals() throws Exception {

    }

    @Test
    public void testHashCode() throws Exception {

    }

    @Test
    public void testCreatePk() throws Exception {

    }

    @Test
    public void testToString() throws Exception {

    }
}
