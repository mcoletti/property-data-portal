package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlRootElement(name = "customer")
@XmlType(name = "customer",namespace = PDPServiceConstants.NAMESPACE)
public class Customer implements Serializable
{
	private String customerUuid;
	private String customerName;
	private boolean customerDeleteInd;
	public Customer()
	{
	}

    public Customer(String customerUuid, String customerName, boolean customerDeleteInd) {
        this.customerUuid = customerUuid;
        this.customerName = customerName;
        this.customerDeleteInd = customerDeleteInd;
    }


    @XmlElement
	public String getCustomerUuid()
	{
		return customerUuid;
	}

	public void setCustomerUuid(String customerUuid)
	{
		this.customerUuid = customerUuid;
	}
    @XmlElement
	public String getCustomerName()
	{
		return customerName;
	}

	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
	}
    @XmlElement
	public boolean getCustomerDeleteInd()
	{
		return customerDeleteInd;
	}

	public void setCustomerDeleteInd(boolean customerDeleteInd)
	{
		this.customerDeleteInd = customerDeleteInd;
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.codeitek.pdp.model.Customer: " );
		ret.append( "customerUuid=" + customerUuid);
		ret.append( ", customerName=" + customerName);
		ret.append( ", customerDeleteInd=" + customerDeleteInd);
		return ret.toString();
	}

}
