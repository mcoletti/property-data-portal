package com.codeitek.pdp.model;

import org.springframework.security.core.GrantedAuthority;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/31/13
 * Time: 9:58 AM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "authorityUserView")
@XmlType(name = "authorityUserView",namespace = PDPServiceConstants.NAMESPACE)
public class AuthorityUserView implements Serializable,GrantedAuthority {


    private String userUuid;
    private String userName;
    private String userAuthToken;
    private Date userAuthTokenExpirationDate;
    private String authorityUuid;
    private String authority;
    private String apiAuthToken;

    public AuthorityUserView() {
    }

    /**
     * Full Constructor
     * @param userUuid
     * @param userName
     * @param userAuthToken
     * @param userAuthTokenExpirationDate
     * @param authorityUuid
     * @param apiAuthToken
     */
    public AuthorityUserView(String userUuid, String userName, String userAuthToken, Date userAuthTokenExpirationDate, String authorityUuid, String apiAuthToken) {
        this.userUuid = userUuid;
        this.userName = userName;
        this.userAuthToken = userAuthToken;
        this.userAuthTokenExpirationDate = userAuthTokenExpirationDate;
        this.authorityUuid = authorityUuid;
        this.apiAuthToken = apiAuthToken;
    }

    /**
     *
     * @param user
     * @param authority
     */
    public AuthorityUserView(User user,Authority authority) {
        this.userUuid = user.getUuid();
        this.userName = user.getUserName();
        this.userAuthToken = user.getApiKey();
        this.userAuthTokenExpirationDate = user.getApiKeyExpirationDate();
        this.authorityUuid = authority.getUuid();
        this.apiAuthToken = authority.getApiAuthToken();
        this.authority = authority.getAuthority();
    }

    @XmlElement
    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }
    @XmlElement
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    @XmlElement
    public String getUserAuthToken() {
        return userAuthToken;
    }

    public void setUserAuthToken(String userAuthToken) {
        this.userAuthToken = userAuthToken;
    }
    @XmlElement
    public Date getUserAuthTokenExpirationDate() {
        return userAuthTokenExpirationDate;
    }

    public void setUserAuthTokenExpirationDate(Date userAuthTokenExpirationDate) {
        this.userAuthTokenExpirationDate = userAuthTokenExpirationDate;
    }
    @XmlElement
    public String getAuthorityUuid() {
        return authorityUuid;
    }

    public void setAuthorityUuid(String authorityUuid) {
        this.authorityUuid = authorityUuid;
    }
    @XmlElement
    public String getApiAuthToken() {
        return apiAuthToken;
    }

    public void setApiAuthToken(String apiAuthToken) {
        this.apiAuthToken = apiAuthToken;
    }
    @XmlElement
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
