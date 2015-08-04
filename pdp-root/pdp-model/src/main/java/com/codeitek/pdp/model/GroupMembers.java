package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "groupMembers")
public class GroupMembers implements Serializable
{
	/** 
	 * This attribute maps to the column ID in the GROUP_MEMBERS table.
	 */
	public int id;

	/** 
	 * This attribute maps to the column USER_UUID in the GROUP_MEMBERS table.
	 */
	public String userUuid;

	/** 
	 * This attribute maps to the column GROUPS_ID in the GROUP_MEMBERS table.
	 */
	public int groupsId;

	/**
	 * Method 'GroupMembers'
	 * 
	 */
	public GroupMembers()
	{
	}

    /**
     * Full Constructor
     * @param id
     * @param userUuid
     * @param groupsId
     */
    public GroupMembers(int id, String userUuid, int groupsId) {
        this.id = id;
        this.userUuid = userUuid;
        this.groupsId = groupsId;
    }

    /**
	 * Method 'getId'
	 * 
	 * @return int
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * Method 'setId'
	 * 
	 * @param id
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/**
	 * Method 'getUserUuid'
	 * 
	 * @return String
	 */
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
	 * Method 'getGroupsId'
	 * 
	 * @return int
	 */
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
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 */
	public boolean equals(Object _other)
	{
		if (_other == null) {
			return false;
		}
		
		if (_other == this) {
			return true;
		}
		
		if (!(_other instanceof GroupMembers)) {
			return false;
		}
		
		final GroupMembers _cast = (GroupMembers) _other;
		if (id != _cast.id) {
			return false;
		}
		
		if (userUuid == null ? _cast.userUuid != userUuid : !userUuid.equals( _cast.userUuid )) {
			return false;
		}
		
		if (groupsId != _cast.groupsId) {
			return false;
		}
		
		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	public int hashCode()
	{
		int _hashCode = 0;
		_hashCode = 29 * _hashCode + id;
		if (userUuid != null) {
			_hashCode = 29 * _hashCode + userUuid.hashCode();
		}
		
		_hashCode = 29 * _hashCode + groupsId;
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return GroupMembersPk
	 */
	public GroupMembersPk createPk()
	{
		return new GroupMembersPk(id);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.codeitek.pdp.model.GroupMembers: " );
		ret.append( "id=" + id );
		ret.append( ", userUuid=" + userUuid );
		ret.append( ", groupsId=" + groupsId );
		return ret.toString();
	}

}
