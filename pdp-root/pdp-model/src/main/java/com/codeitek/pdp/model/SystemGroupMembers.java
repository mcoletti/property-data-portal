package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlRootElement(name = "systemGroupMembers")
@XmlType(name = "systemGroupMembers",namespace = PDPServiceConstants.NAMESPACE)
public class SystemGroupMembers implements Serializable
{
	/** 
	 * This attribute maps to the column SYSTEM_ROLES_ID in the SYSTEM_GROUP_MEMBERS table.
	 */
	private int systemRolesId;

	/** 
	 * This attribute maps to the column GROUPS_ID in the SYSTEM_GROUP_MEMBERS table.
	 */
	private int groupsId;

	/** 
	 * This attribute maps to the column USER_UUID in the SYSTEM_GROUP_MEMBERS table.
	 */
	private String userUuid;

	/**
	 * Method 'SystemGroupMembers'
	 * 
	 */
	public SystemGroupMembers()
	{
	}

    /**
     * Full Constructor
     * @param systemRolesId
     * @param groupsId
     * @param userUuid
     */
    public SystemGroupMembers(int systemRolesId, int groupsId, String userUuid) {
        this.systemRolesId = systemRolesId;
        this.groupsId = groupsId;
        this.userUuid = userUuid;
    }

    /**
	 * Method 'getSystemRolesId'
	 * 
	 * @return int
	 */
    @XmlElement
	public int getSystemRolesId()
	{
		return systemRolesId;
	}

	/**
	 * Method 'setSystemRolesId'
	 * 
	 * @param systemRolesId
	 */
	public void setSystemRolesId(int systemRolesId)
	{
		this.systemRolesId = systemRolesId;
	}

	/**
	 * Method 'getGroupsId'
	 * 
	 * @return int
	 */
    @XmlElement
	public int getGroupsId()
	{
		return groupsId;
	}

	/**
	 * Method 'setGroupsId'
	 * 
	 * @param groupsId
	 */
	public void setGroupsId(int groupsId)
	{
		this.groupsId = groupsId;
	}

	/**
	 * Method 'getUserUuid'
	 * 
	 * @return String
	 */
    @XmlElement
	public String getUserUuid()
	{
		return userUuid;
	}

	/**
	 * Method 'setUserUuid'
	 * 
	 * @param userUuid
	 */
	public void setUserUuid(String userUuid)
	{
		this.userUuid = userUuid;
	}
	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.codeitek.pdp.model.SystemGroupMembers: " );
		ret.append( "systemRolesId=" + systemRolesId );
		ret.append( ", groupsId=" + groupsId );
		ret.append( ", userUuid=" + userUuid );
		return ret.toString();
	}

}
