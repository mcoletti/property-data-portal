package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Date;

@XmlRootElement(name = "systemRoles")
@XmlType(name = "systemRoles",namespace = PDPServiceConstants.NAMESPACE)
public class SystemRoles implements Serializable
{
	/** 
	 * This attribute maps to the column ID in the SYSTEM_ROLES table.
	 */
	private int id;

	/** 
	 * This attribute maps to the column ROLE_NAME in the SYSTEM_ROLES table.
	 */
	private String roleName;

	/** 
	 * This attribute maps to the column ACTIVE_IND in the SYSTEM_ROLES table.
	 */
	private boolean deleteInd;

	/** 
	 * This attribute maps to the column CRE_USER_ID in the SYSTEM_ROLES table.
	 */
	private int creUserId;

	/** 
	 * This attribute maps to the column CRE_DTM in the SYSTEM_ROLES table.
	 */
	private Date creDtm;

	/**
	 * Method 'SystemRoles'
	 * 
	 */
	public SystemRoles()
	{
	}

    /**
     * Full Constructor
     * @param id
     * @param roleName
     * @param deleteInd
     * @param creUserId
     * @param creDtm
     */
    public SystemRoles(int id, String roleName, boolean deleteInd, int creUserId, Date creDtm) {
        this.id = id;
        this.roleName = roleName;
        this.deleteInd = deleteInd;
        this.creUserId = creUserId;
        this.creDtm = creDtm;
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
	 * Method 'getRoleName'
	 * 
	 * @return String
	 */
    @XmlElement
	public String getRoleName()
	{
		return roleName;
	}

	/**
	 * Method 'setRoleName'
	 * 
	 * @param roleName
	 */
	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
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
	 * Method 'getCreUserId'
	 * 
	 * @return int
	 */
    @XmlElement
	public int getCreUserId()
	{
		return creUserId;
	}

	/**
	 * Method 'setCreUserId'
	 * 
	 * @param creUserId
	 */
	public void setCreUserId(int creUserId)
	{
		this.creUserId = creUserId;
	}

	/**
	 * Method 'getCreDtm'
	 * 
	 * @return Date
	 */
    @XmlElement
	public Date getCreDtm()
	{
		return creDtm;
	}

	/**
	 * Method 'setCreDtm'
	 * 
	 * @param creDtm
	 */
	public void setCreDtm(Date creDtm)
	{
		this.creDtm = creDtm;
	}



	/**
	 * Method 'createPk'
	 * 
	 * @return SystemRolesPk
	 */
	public SystemRolesPk createPk()
	{
		return new SystemRolesPk(id);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.codeitek.pdp.model.SystemRoles: " );
		ret.append( "id=" + id );
		ret.append( ", roleName=" + roleName );
		ret.append( ", deleteInd=" + deleteInd);
		ret.append( ", creUserId=" + creUserId );
		ret.append( ", creDtm=" + creDtm );
		return ret.toString();
	}

}
