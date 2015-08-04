package com.codeitek.pdp.model;


import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
@XmlRootElement(name = "user")
@XmlType(name = "user",namespace = PDPServiceConstants.NAMESPACE)
public class User implements UserDetails, CredentialsContainer
{
    /**
     * This attribute maps to the column UUID in the USER table.
     */
    private String uuid;

    /**
     * This attribute maps to the column USER_NAME in the USER table.
     */
    private String userName;

    /**
     * This attribute maps to the column FIRST_NAME in the USER table.
     */
    private String firstName;

    /**
     * This attribute maps to the column LAST_NAME in the USER table.
     */
    private String lastName;

    /**
     * This attribute maps to the column PRIMARY_EMAIL in the USER table.
     */
    private String primaryEmail;

    /**
     * This attribute maps to the column REFERRED_BY in the USER table.
     */
    private String referredBy;

    /**
     * This attribute maps to the column GENDER in the USER table.
     */
    private String gender;

    /**
     * This attribute maps to the column DELETE_IND in the USER table.
     */
    private boolean deleteInd;

    /**
     * This attribute maps to the column CUSTOMER_UUID in the USER table.
     */
    private String customerUuid;



    /**
     * This attribute maps to the column LAST_LOGIN_DTM in the USER table.
     */
    private Date lastLoginDtm;

    /**
     * This attribute maps to the column LOCK_IND in the USER table.
     */
    private boolean lockInd;

    private int accountLevelId;

    private String apiKey;
    private Date apiKeyExpirationDate;

    private Collection<? extends GrantedAuthority> authorities;

    public User() {
    }

    public User(String userName, String apiKey, Collection<? extends GrantedAuthority> authorities) {
        this.userName = userName;
        this.apiKey = apiKey;
        this.authorities = authorities;
    }

    /**
     * Method 'User'
     *
     */


    /**
     * Full Constructor
     * @param uuid
     * @param userName
     * @param firstName
     * @param lastName
     * @param primaryEmail
     * @param referredBy
     * @param gender
     * @param deleteInd
     * @param customerUuid
     * @param lastLoginDtm
     * @param lockInd
     * @param accountLevelId
     * @param apiKey
     * @param apiKeyExpirationDate
     */
    public User(String uuid, String userName, String firstName, String lastName, String primaryEmail, String referredBy, String gender, boolean deleteInd, String customerUuid, Date lastLoginDtm, boolean lockInd, int accountLevelId, String apiKey, Date apiKeyExpirationDate) {
        this.uuid = uuid;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.primaryEmail = primaryEmail;
        this.referredBy = referredBy;
        this.gender = gender;
        this.deleteInd = deleteInd;
        this.customerUuid = customerUuid;
        this.lastLoginDtm = lastLoginDtm;
        this.lockInd = lockInd;
        this.accountLevelId = accountLevelId;
        this.apiKey = apiKey;
        this.apiKeyExpirationDate = apiKeyExpirationDate;
    }

    /**
     *
     * @param user
     */
    public User(User user) {
        this.uuid = user.getUuid();
        this.userName = user.getUserName();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.primaryEmail = user.getPrimaryEmail();
        this.referredBy = user.getReferredBy();
        this.gender = user.getGender();
        this.deleteInd = user.getDeleteInd();
        this.customerUuid = user.getCustomerUuid();
        this.lastLoginDtm = user.getLastLoginDtm();
        this.lockInd = user.getLockInd();
        this.apiKey = user.getApiKey();
        this.apiKeyExpirationDate = user.getApiKeyExpirationDate();
    }

    /**
     * Method Get Account Level Id
     * @return int
     */
    @XmlElement
    public int getAccountLevelId() {
        return accountLevelId;
    }

    public void setAccountLevelId(int accountLevelId) {
        this.accountLevelId = accountLevelId;
    }

    /**
     * Method 'getCustomerUuid'
     *
     * @return String
     */
    @XmlElement
    public String getUuid()
    {
        return uuid;
    }

    /**
     * Method 'setCustomerUuid'
     *
     * @param uuid
     */
    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }

    /**
     * Method 'getUserName'
     *
     * @return String
     */
    @XmlElement
    public String getUserName()
    {
        return userName;
    }

    /**
     * Method 'setUserName'
     *
     * @param userName
     */
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    /**
     * Method 'getFirstName'
     *
     * @return String
     */
    @XmlElement
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Method 'setFirstName'
     *
     * @param firstName
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * Method 'getLastName'
     *
     * @return String
     */
    @XmlElement
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Method 'setLastName'
     *
     * @param lastName
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Method 'getPrimaryEmail'
     *
     * @return String
     */
    @XmlElement
    public String getPrimaryEmail()
    {
        return primaryEmail;
    }

    /**
     * Method 'setPrimaryEmail'
     *
     * @param primaryEmail
     */
    public void setPrimaryEmail(String primaryEmail)
    {
        this.primaryEmail = primaryEmail;
    }

    /**
     * Method 'getReferredBy'
     *
     * @return String
     */
    @XmlElement
    public String getReferredBy()
    {
        return referredBy;
    }

    /**
     * Method 'setReferredBy'
     *
     * @param referredBy
     */
    public void setReferredBy(String referredBy)
    {
        this.referredBy = referredBy;
    }

    /**
     * Method 'getGender'
     *
     * @return String
     */
    @XmlElement
    public String getGender()
    {
        return gender;
    }

    /**
     * Method 'setGender'
     *
     * @param gender
     */
    public void setGender(String gender)
    {
        this.gender = gender;
    }

    /**
     * Method 'getCustomerDeleteInd'
     *
     * @return short
     */
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
    public void setCustomerUuid(String customerUuid)
    {
        this.customerUuid = customerUuid;
    }



    /**
     * Method 'getLastLoginDtm'
     *
     * @return Date
     */
    @XmlElement
    public Date getLastLoginDtm()
    {
        return lastLoginDtm;
    }

    /**
     * Method 'setLastLoginDtm'
     *
     * @param lastLoginDtm
     */
    public void setLastLoginDtm(Date lastLoginDtm)
    {
        this.lastLoginDtm = lastLoginDtm;
    }

    /**
     * Method 'getLockInd'
     *
     * @return short
     */
    @XmlElement
    public boolean getLockInd()
    {
        return lockInd;
    }

    /**
     * Method 'setLockInd'
     *
     * @param lockInd
     */
    public void setLockInd(boolean lockInd)
    {
        this.lockInd = lockInd;
    }

    @XmlElement
    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    @XmlElement
    public Date getApiKeyExpirationDate() {
        return apiKeyExpirationDate;
    }

    public void setApiKeyExpirationDate(Date apiKeyExpirationDate) {
        this.apiKeyExpirationDate = apiKeyExpirationDate;
    }

    /**
     * Method 'toString'
     *
     * @return String
     */
    public String toString()
    {
        StringBuffer ret = new StringBuffer();
        ret.append( "com.codeitek.pdp.dto.User: " );
        ret.append( "customerUuid=" + uuid );
        ret.append( ", userName=" + userName );
        ret.append( ", firstName=" + firstName );
        ret.append( ", lastName=" + lastName );
        ret.append( ", primaryEmail=" + primaryEmail );
        ret.append( ", referredBy=" + referredBy );
        ret.append( ", gender=" + gender );
        ret.append( ", customerDeleteInd=" + deleteInd );
        ret.append( ", customerUuid=" + customerUuid );
        ret.append( ", lastLoginDtm=" + lastLoginDtm );
        ret.append( ", lockInd=" + lockInd );
        ret.append( ", apiKey=" + apiKey);
        ret.append( ", apiKeyExpirationDate=" + apiKeyExpirationDate);
        return ret.toString();
    }

    @Override
    public void eraseCredentials() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isEnabled() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
