package com.codeitek.pdp.model;

import java.io.Serializable;
import java.util.Date;

public class VwUserSystemRoles implements Serializable
{
	/** 
	 * This attribute maps to the column UUID in the vw_UserSystemRoles table.
	 */
	public String uuid;

	/** 
	 * This attribute maps to the column USER_NAME in the vw_UserSystemRoles table.
	 */
	public String userName;

	/** 
	 * This attribute maps to the column FIRST_NAME in the vw_UserSystemRoles table.
	 */
	public String firstName;

	/** 
	 * This attribute maps to the column LAST_NAME in the vw_UserSystemRoles table.
	 */
	public String lastName;

	/** 
	 * This attribute maps to the column PRIMARY_EMAIL in the vw_UserSystemRoles table.
	 */
	public String primaryEmail;

	/** 
	 * This attribute maps to the column REFERRED_BY in the vw_UserSystemRoles table.
	 */
	public String referredBy;

	/** 
	 * This attribute maps to the column GENDER in the vw_UserSystemRoles table.
	 */
	public String gender;

	/** 
	 * This attribute maps to the column DELETE_IND in the vw_UserSystemRoles table.
	 */
	public short deleteInd;

	/** 
	 * This attribute maps to the column CUSTOMER_UUID in the vw_UserSystemRoles table.
	 */
	public String customerUuid;

	/** 
	 * This attribute maps to the column LAST_LOGIN_DTM in the vw_UserSystemRoles table.
	 */
	public Date lastLoginDtm;

	/** 
	 * This attribute maps to the column LOCK_IND in the vw_UserSystemRoles table.
	 */
	public short lockInd;

	/** 
	 * This attribute maps to the column ACCOUNT_LEVEL_ID in the vw_UserSystemRoles table.
	 */
	public int accountLevelId;

	/** 
	 * This attribute maps to the column SYSTEM_GROUP_MEMBER_ID in the vw_UserSystemRoles table.
	 */
	public int systemGroupMemberId;

	/** 
	 * This attribute maps to the column SYSTEM_ROLE_ID in the vw_UserSystemRoles table.
	 */
	public int systemRoleId;

	/** 
	 * This attribute maps to the column ROLE_NAME in the vw_UserSystemRoles table.
	 */
	public String roleName;

	/** 
	 * This attribute maps to the column ACTIVE_IND in the vw_UserSystemRoles table.
	 */
	public short activeInd;

	/** 
	 * This attribute maps to the column CRE_USER_ID in the vw_UserSystemRoles table.
	 */
	public int creUserId;

	/** 
	 * This attribute maps to the column CRE_DTM in the vw_UserSystemRoles table.
	 */
	public Date creDtm;

	/**
	 * Method 'VwUsersystemroles'
	 * 
	 */
	public VwUserSystemRoles()
	{
	}

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
     * @param systemGroupMemberId
     * @param systemRoleId
     * @param roleName
     * @param activeInd
     * @param creUserId
     * @param creDtm
     */
    public VwUserSystemRoles(String uuid, String userName, String firstName, String lastName, String primaryEmail, String referredBy, String gender, short deleteInd, String customerUuid, Date lastLoginDtm, short lockInd, int accountLevelId, int systemGroupMemberId, int systemRoleId, String roleName, short activeInd, int creUserId, Date creDtm) {
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
        this.systemGroupMemberId = systemGroupMemberId;
        this.systemRoleId = systemRoleId;
        this.roleName = roleName;
        this.activeInd = activeInd;
        this.creUserId = creUserId;
        this.creDtm = creDtm;
    }

    /**
	 * Method 'getCustomerUuid'
	 * 
	 * @return String
	 */
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
	public short getDeleteInd()
	{
		return deleteInd;
	}

	/**
	 * Method 'setCustomerDeleteInd'
	 * 
	 * @param deleteInd
	 */
	public void setDeleteInd(short deleteInd)
	{
		this.deleteInd = deleteInd;
	}

	/**
	 * Method 'getCustomerUuid'
	 * 
	 * @return String
	 */
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
	public short getLockInd()
	{
		return lockInd;
	}

	/**
	 * Method 'setLockInd'
	 * 
	 * @param lockInd
	 */
	public void setLockInd(short lockInd)
	{
		this.lockInd = lockInd;
	}

	/**
	 * Method 'getAccountLevelId'
	 * 
	 * @return int
	 */
	public int getAccountLevelId()
	{
		return accountLevelId;
	}

	/**
	 * Method 'setAccountLevelId'
	 * 
	 * @param accountLevelId
	 */
	public void setAccountLevelId(int accountLevelId)
	{
		this.accountLevelId = accountLevelId;
	}

	/**
	 * Method 'getSystemGroupMemberId'
	 * 
	 * @return int
	 */
	public int getSystemGroupMemberId()
	{
		return systemGroupMemberId;
	}

	/**
	 * Method 'setSystemGroupMemberId'
	 * 
	 * @param systemGroupMemberId
	 */
	public void setSystemGroupMemberId(int systemGroupMemberId)
	{
		this.systemGroupMemberId = systemGroupMemberId;
	}

	/**
	 * Method 'getSystemRoleId'
	 * 
	 * @return int
	 */
	public int getSystemRoleId()
	{
		return systemRoleId;
	}

	/**
	 * Method 'setSystemRoleId'
	 * 
	 * @param systemRoleId
	 */
	public void setSystemRoleId(int systemRoleId)
	{
		this.systemRoleId = systemRoleId;
	}

	/**
	 * Method 'getRoleName'
	 * 
	 * @return String
	 */
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
	public short getActiveInd()
	{
		return activeInd;
	}

	/**
	 * Method 'setDeleteInd'
	 * 
	 * @param activeInd
	 */
	public void setActiveInd(short activeInd)
	{
		this.activeInd = activeInd;
	}

	/**
	 * Method 'getCreUserId'
	 * 
	 * @return int
	 */
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
		
		if (!(_other instanceof VwUserSystemRoles)) {
			return false;
		}
		
		final VwUserSystemRoles _cast = (VwUserSystemRoles) _other;
		if (uuid == null ? _cast.uuid != uuid : !uuid.equals( _cast.uuid )) {
			return false;
		}
		
		if (userName == null ? _cast.userName != userName : !userName.equals( _cast.userName )) {
			return false;
		}
		
		if (firstName == null ? _cast.firstName != firstName : !firstName.equals( _cast.firstName )) {
			return false;
		}
		
		if (lastName == null ? _cast.lastName != lastName : !lastName.equals( _cast.lastName )) {
			return false;
		}
		
		if (primaryEmail == null ? _cast.primaryEmail != primaryEmail : !primaryEmail.equals( _cast.primaryEmail )) {
			return false;
		}
		
		if (referredBy == null ? _cast.referredBy != referredBy : !referredBy.equals( _cast.referredBy )) {
			return false;
		}
		
		if (gender == null ? _cast.gender != gender : !gender.equals( _cast.gender )) {
			return false;
		}
		
		if (deleteInd != _cast.deleteInd) {
			return false;
		}
		
		if (customerUuid == null ? _cast.customerUuid != customerUuid : !customerUuid.equals( _cast.customerUuid )) {
			return false;
		}
		
		if (lastLoginDtm == null ? _cast.lastLoginDtm != lastLoginDtm : !lastLoginDtm.equals( _cast.lastLoginDtm )) {
			return false;
		}
		
		if (lockInd != _cast.lockInd) {
			return false;
		}
		
		if (accountLevelId != _cast.accountLevelId) {
			return false;
		}
		
		if (systemGroupMemberId != _cast.systemGroupMemberId) {
			return false;
		}
		
		if (systemRoleId != _cast.systemRoleId) {
			return false;
		}
		
		if (roleName == null ? _cast.roleName != roleName : !roleName.equals( _cast.roleName )) {
			return false;
		}
		
		if (activeInd != _cast.activeInd) {
			return false;
		}
		
		if (creUserId != _cast.creUserId) {
			return false;
		}
		
		if (creDtm == null ? _cast.creDtm != creDtm : !creDtm.equals( _cast.creDtm )) {
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
		if (uuid != null) {
			_hashCode = 29 * _hashCode + uuid.hashCode();
		}
		
		if (userName != null) {
			_hashCode = 29 * _hashCode + userName.hashCode();
		}
		
		if (firstName != null) {
			_hashCode = 29 * _hashCode + firstName.hashCode();
		}
		
		if (lastName != null) {
			_hashCode = 29 * _hashCode + lastName.hashCode();
		}
		
		if (primaryEmail != null) {
			_hashCode = 29 * _hashCode + primaryEmail.hashCode();
		}
		
		if (referredBy != null) {
			_hashCode = 29 * _hashCode + referredBy.hashCode();
		}
		
		if (gender != null) {
			_hashCode = 29 * _hashCode + gender.hashCode();
		}
		
		_hashCode = 29 * _hashCode + (int) deleteInd;
		if (customerUuid != null) {
			_hashCode = 29 * _hashCode + customerUuid.hashCode();
		}
		
		if (lastLoginDtm != null) {
			_hashCode = 29 * _hashCode + lastLoginDtm.hashCode();
		}
		
		_hashCode = 29 * _hashCode + (int) lockInd;
		_hashCode = 29 * _hashCode + accountLevelId;
		_hashCode = 29 * _hashCode + systemGroupMemberId;
		_hashCode = 29 * _hashCode + systemRoleId;
		if (roleName != null) {
			_hashCode = 29 * _hashCode + roleName.hashCode();
		}
		
		_hashCode = 29 * _hashCode + (int) activeInd;
		_hashCode = 29 * _hashCode + creUserId;
		if (creDtm != null) {
			_hashCode = 29 * _hashCode + creDtm.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.codeitek.pdp.model.VwUsersystemroles: " );
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
		ret.append( ", accountLevelId=" + accountLevelId );
		ret.append( ", systemGroupMemberId=" + systemGroupMemberId );
		ret.append( ", systemRoleId=" + systemRoleId );
		ret.append( ", roleName=" + roleName );
		ret.append( ", activeInd=" + activeInd );
		ret.append( ", creUserId=" + creUserId );
		ret.append( ", creDtm=" + creDtm );
		return ret.toString();
	}

}
