package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlRootElement(name = "customerAttributes")
@XmlType(name = "customerAttributes",namespace = PDPServiceConstants.NAMESPACE)
public class CustomerAttributes implements Serializable
{
	/** 
	 * This attribute maps to the column ID in the CUSTOMER_ATTRIBUTES table.
	 */
	private int id;

	/** 
	 * This attribute maps to the column ATTRIBUTE_VALUE in the CUSTOMER_ATTRIBUTES table.
	 */
	private String attributeValue;

	/** 
	 * This attribute maps to the column CUSTOMER_UUID in the CUSTOMER_ATTRIBUTES table.
	 */
	private String customerUuid;

	/** 
	 * This attribute maps to the column ATTRIBUTES_ID in the CUSTOMER_ATTRIBUTES table.
	 */
	private int attributesId;

	/**
	 * Method 'CustomerAttributes'
	 * 
	 */
	public CustomerAttributes()
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
	 * Method 'getAttributeValue'
	 * 
	 * @return String
	 */
    @XmlElement
	public String getAttributeValue()
	{
		return attributeValue;
	}

	/**
	 * Method 'setAttributeValue'
	 * 
	 * @param attributeValue
	 */
	public void setAttributeValue(String attributeValue)
	{
		this.attributeValue = attributeValue;
	}

	/**
	 * Method 'getCustomerUuid'
	 * 
	 * @return String
	 */
    @XmlElement
	public String getCustomerUuid()
	{
		return customerUuid;
	}

	/**
	 * Method 'setCustomerUuid'
	 * 
	 * @param customerUuid
	 */
    @XmlElement
	public void setCustomerUuid(String customerUuid)
	{
		this.customerUuid = customerUuid;
	}

	/**
	 * Method 'getAttributesId'
	 * 
	 * @return int
	 */
    @XmlElement
	public int getAttributesId()
	{
		return attributesId;
	}

	/**
	 * Method 'setAttributesId'
	 * 
	 * @param attributesId
	 */
	public void setAttributesId(int attributesId)
	{
		this.attributesId = attributesId;
	}



	/**
	 * Method 'createPk'
	 *
	 * @return CustomerAttributesPk
	 */
	public CustomerAttributesPk createPk()
	{
		return new CustomerAttributesPk(id);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.codeitek.pdp.model.CustomerAttributes: " );
		ret.append( "id=" + id );
		ret.append( ", attributeValue=" + attributeValue );
		ret.append( ", customerUuid=" + customerUuid );
		ret.append( ", attributesId=" + attributesId );
		return ret.toString();
	}

}
