package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlRootElement(name = "roleData")
@XmlType(name = "roleData",namespace = PDPServiceConstants.NAMESPACE)
public class RoleData implements Serializable
{
	/** 
	 * This attribute maps to the column ID in the ROLE_DATA table.
	 */
	private int id;

	/** 
	 * This attribute maps to the column ROLE_NAME in the ROLE_DATA table.
	 */
	private String roleName;

	/** 
	 * This attribute maps to the column DELETE_IND in the ROLE_DATA table.
	 */
	private boolean deleteInd;

	/**
	 * Method 'RoleData'
	 * 
	 */
	public RoleData()
	{
	}

    public RoleData(int id, String roleName, boolean deleteInd) {
        this.id = id;
        this.roleName = roleName;
        this.deleteInd = deleteInd;
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
	 * Method 'getCustomerDeleteInd'
	 * 
	 * @return short
	 */
    @XmlElement
	public boolean getDeleteInd()
	{
		return deleteInd;
	}

	/**
	 * Method 'setCustomerDeleteInd'
	 * 
	 * @param deleteInd
	 */
	public void setDeleteInd(boolean deleteInd)
	{
		this.deleteInd = deleteInd;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return RoleDataPk
	 */
	public RoleDataPk createPk()
	{
		return new RoleDataPk(id);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.codeitek.pdp.model.RoleData: " );
		ret.append( "id=" + id );
		ret.append( ", roleName=" + roleName );
		ret.append( ", customerDeleteInd=" + deleteInd );
		return ret.toString();
	}

}
