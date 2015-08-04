package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlRootElement(name = "authorityUserMap")
@XmlType(name = "authorityUserMap",namespace = PDPServiceConstants.NAMESPACE)
public class AuthorityUserMap implements Serializable
{
	/** 
	 * This attribute maps to the column ID in the AUTHORITY_USER_MAP table.
	 */
	public int id;

	/** 
	 * This attribute maps to the column DELETE_IND in the AUTHORITY_USER_MAP table.
	 */
	public boolean deleteInd;

	/** 
	 * This attribute maps to the column AUTHORITY_UUID in the AUTHORITY_USER_MAP table.
	 */
	public String authorityUuid;

	/** 
	 * This attribute maps to the column USER_UUID in the AUTHORITY_USER_MAP table.
	 */
	public String userUuid;

	/**
	 * Method 'AuthorityUserMap'
	 * 
	 */
	public AuthorityUserMap()
	{
	}

	/**
	 * Method 'getId'
	 * 
	 * @return int
	 */
    @XmlElement
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
	 * Method 'getDeleteInd'
	 * 
	 * @return short
	 */
    @XmlElement
	public boolean getDeleteInd()
	{
		return deleteInd;
	}

	/**
	 * Method 'setDeleteInd'
	 * 
	 * @param deleteInd
	 */
	public void setDeleteInd(boolean deleteInd)
	{
		this.deleteInd = deleteInd;
	}

	/**
	 * Method 'getAuthorityUuid'
	 * 
	 * @return String
	 */
    @XmlElement
	public String getAuthorityUuid()
	{
		return authorityUuid;
	}

	/**
	 * Method 'setAuthorityUuid'
	 * 
	 * @param authorityUuid
	 */
	public void setAuthorityUuid(String authorityUuid)
	{
		this.authorityUuid = authorityUuid;
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
     * Method 'createPk'
     *
     * @return AuthorityUserMapPk
     */
    public AuthorityUserMapPk createPk()
    {
        return new AuthorityUserMapPk(id);
    }

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.codeitek.pdp.dto.AuthorityUserMap: " );
		ret.append( "id=" + id );
		ret.append( ", deleteInd=" + deleteInd );
		ret.append( ", authorityUuid=" + authorityUuid );
		ret.append( ", userUuid=" + userUuid );
		return ret.toString();
	}

}
