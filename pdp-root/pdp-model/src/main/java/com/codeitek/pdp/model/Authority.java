package com.codeitek.pdp.model;

import org.springframework.security.core.GrantedAuthority;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlRootElement(name = "authority")
@XmlType(name = "authority",namespace = PDPServiceConstants.NAMESPACE)
public class Authority implements Serializable
{
	/** 
	 * This attribute maps to the column ID in the AUTHORITIES table.
	 */
	private String uuid;

	/** 
	 * This attribute maps to the column AUTHORITY in the AUTHORITIES table.
	 */
	private String authority;

	/** 
	 * This attribute maps to the column ENABLED in the AUTHORITIES table.
	 */
	private boolean enabled;

	/** 
	 * This attribute maps to the column API_URL in the AUTHORITIES table.
	 */
	private String apiUrl;

	/** 
	 * This attribute maps to the column API__AUTH_TOKEN in the AUTHORITIES table.
	 */
	private String apiAuthToken;

    private boolean deleteInd;

	/**
	 * Method 'Authorities'
	 * 
	 */
	public Authority()
	{
	}

    @XmlElement
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @XmlElement
    public boolean isEnabled() {
        return enabled;
    }

    @XmlElement
    public boolean isDeleteInd() {
        return deleteInd;
    }

    public void setDeleteInd(boolean deleteInd) {
        this.deleteInd = deleteInd;
    }

    /**
	 * Method 'getAuthority'
	 * 
	 * @return String
	 */
    @XmlElement
	public String getAuthority()
	{
		return authority;
	}

	/**
	 * Method 'setAuthority'
	 * 
	 * @param authority
	 */
	public void setAuthority(String authority)
	{
		this.authority = authority;
	}

	/**
	 * Method 'getEnabled'
	 * 
	 * @return short
	 */
    @XmlElement
	public boolean getEnabled()
	{
		return enabled;
	}

	/**
	 * Method 'setEnabled'
	 * 
	 * @param enabled
	 */
	public void setEnabled(boolean enabled)
	{
		this.enabled = enabled;
	}

	/**
	 * Method 'getApiUrl'
	 * 
	 * @return String
	 */
    @XmlElement
	public String getApiUrl()
	{
		return apiUrl;
	}

	/**
	 * Method 'setApiUrl'
	 * 
	 * @param apiUrl
	 */
	public void setApiUrl(String apiUrl)
	{
		this.apiUrl = apiUrl;
	}

	/**
	 * Method 'getApiAuthToken'
	 * 
	 * @return String
	 */
    @XmlElement
	public String getApiAuthToken()
	{
		return apiAuthToken;
	}

	/**
	 * Method 'setApiAuthToken'
	 * 
	 * @param apiAuthToken
	 */
	public void setApiAuthToken(String apiAuthToken)
	{
		this.apiAuthToken = apiAuthToken;
	}



	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.codeitek.pdp.dto.Authorities: " );
		ret.append( "uuid=" + uuid );
		ret.append( ", authority=" + authority );
		ret.append( ", enabled=" + enabled );
		ret.append( ", apiUrl=" + apiUrl );
		ret.append( ", apiAuthToken=" + apiAuthToken );
		return ret.toString();
	}

}
