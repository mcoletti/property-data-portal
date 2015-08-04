package com.codeitek.pdp.model;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.*;
import java.util.Date;

@XmlRootElement(name = "userActivityLog")
@XmlType(name = "userActivityLog",namespace = PDPServiceConstants.NAMESPACE)
public class UserActivityLog implements Serializable
{
    /**
     * This attribute maps to the column ID in the USER_ACTIVITY_LOG table.
     */
    private int id;

    /**
     * This attribute maps to the column LOG_DETAIL in the USER_ACTIVITY_LOG table.
     */
    private String logDetail;

    /**
     * This attribute maps to the column LOG_DTM in the USER_ACTIVITY_LOG table.
     */
    private Date logDtm;

    /**
     * This attribute maps to the column USER_UUID in the USER_ACTIVITY_LOG table.
     */
    private String userUuid;

    /**
     * Method 'UserActivityLog'
     *
     */
    public UserActivityLog()
    {
    }

    /**
     * Full Constructor
     * @param id
     * @param logDetail
     * @param logDtm
     * @param userUuid
     */
    public UserActivityLog(int id, String logDetail, Date logDtm, String userUuid) {
        this.id = id;
        this.logDetail = logDetail;
        this.logDtm = logDtm;
        this.userUuid = userUuid;
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
     * Method 'getLogDetail'
     *
     * @return String
     */
    @XmlElement
    public String getLogDetail()
    {
        return logDetail;
    }

    /**
     * Method 'setLogDetail'
     *
     * @param logDetail
     */
    public void setLogDetail(String logDetail)
    {
        this.logDetail = logDetail;
    }

    /**
     * Method 'getLogDtm'
     *
     * @return Date
     */
    @XmlElement
    public Date getLogDtm()
    {
        return logDtm;
    }

    /**
     * Method 'setLogDtm'
     *
     * @param logDtm
     */
    public void setLogDtm(Date logDtm)
    {
        this.logDtm = logDtm;
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
     * @return UserActivityLogPk
     */
    public UserActivityLogPk createPk()
    {
        return new UserActivityLogPk(id);
    }

    /**
     * Method 'toString'
     *
     * @return String
     */
    public String toString()
    {
        StringBuffer ret = new StringBuffer();
        ret.append( "com.codeitek.pdp.model.UserActivityLog: " );
        ret.append( "id=" + id );
        ret.append( ", logDetail=" + logDetail );
        ret.append( ", logDtm=" + logDtm );
        ret.append( ", userUuid=" + userUuid );
        return ret.toString();
    }

}
