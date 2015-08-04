package com.codeitek.pdp.model;

import java.io.Serializable;
import java.util.Date;

public class VwUserGroups implements Serializable
{
	/** 
	 * This attribute maps to the column UUID in the vw_UserGroups table.
	 */
	public String uuid;

	/** 
	 * This attribute maps to the column USER_NAME in the vw_UserGroups table.
	 */
	public String userName;

	/** 
	 * This attribute maps to the column FIRST_NAME in the vw_UserGroups table.
	 */
	public String firstName;

	/** 
	 * This attribute maps to the column LAST_NAME in the vw_UserGroups table.
	 */
	public String lastName;

	/** 
	 * This attribute maps to the column PRIMARY_EMAIL in the vw_UserGroups table.
	 */
	public String primaryEmail;

	/** 
	 * This attribute maps to the column REFERRED_BY in the vw_UserGroups table.
	 */
	public String referredBy;

	/** 
	 * This attribute maps to the column GENDER in the vw_UserGroups table.
	 */
	public String gender;

	/** 
	 * This attribute maps to the column DELETE_IND in the vw_UserGroups table.
	 */
	public short deleteInd;

	/** 
	 * This attribute maps to the column CUSTOMER_UUID in the vw_UserGroups table.
	 */
	public String customerUuid;

	/** 
	 * This attribute maps to the column LAST_LOGIN_DTM in the vw_UserGroups table.
	 */
	public Date lastLoginDtm;

	/** 
	 * This attribute maps to the column LOCK_IND in the vw_UserGroups table.
	 */
	public short lockInd;

	/** 
	 * This attribute maps to the column ACCOUNT_LEVEL_ID in the vw_UserGroups table.
	 */
	public int accountLevelId;

	/** 
	 * This attribute maps to the column GROUP_MEMBER_ID in the vw_UserGroups table.
	 */
	public int groupMemberId;

	/** 
	 * This attribute maps to the column GROUP_ID in the vw_UserGroups table.
	 */
	public int groupId;

	/** 
	 * This attribute maps to the column GROUP_NAME in the vw_UserGroups table.
	 */
	public String groupName;

	/**
	 * Method 'VwUsergroups'
	 * 
	 */
	public VwUserGroups()
	{
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
	 * Method 'getGroupMemberId'
	 * 
	 * @return int
	 */
	public int getGroupMemberId()
	{
		return groupMemberId;
	}

	/**
	 * Method 'setGroupMemberId'
	 * 
	 * @param groupMemberId
	 */
	public void setGroupMemberId(int groupMemberId)
	{
		this.groupMemberId = groupMemberId;
	}

	/**
	 * Method 'getGroupId'
	 * 
	 * @return int
	 */
	public int getGroupId()
	{
		return groupId;
	}

	/**
	 * Method 'setGroupId'
	 * 
	 * @param groupId
	 */
	public void setGroupId(int groupId)
	{
		this.groupId = groupId;
	}

	/**
	 * Method 'getGroupName'
	 * 
	 * @return String
	 */
	public String getGroupName()
	{
		return groupName;
	}

	/**
	 * Method 'setGroupName'
	 * 
	 * @param groupName
	 */
	public void setGroupName(String groupName)
	{
		this.groupName = groupName;
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
		
		if (!(_other instanceof VwUserGroups)) {
			return false;
		}
		
		final VwUserGroups _cast = (VwUserGroups) _other;
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
		
		if (groupMemberId != _cast.groupMemberId) {
			return false;
		}
		
		if (groupId != _cast.groupId) {
			return false;
		}
		
		if (groupName == null ? _cast.groupName != groupName : !groupName.equals( _cast.groupName )) {
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
		_hashCode = 29 * _hashCode + groupMemberId;
		_hashCode = 29 * _hashCode + groupId;
		if (groupName != null) {
			_hashCode = 29 * _hashCode + groupName.hashCode();
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
		ret.append( "com.codeitek.pdp.model.VwUsergroups: " );
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
		ret.append( ", groupMemberId=" + groupMemberId );
		ret.append( ", groupId=" + groupId );
		ret.append( ", groupName=" + groupName );
		return ret.toString();
	}

}
