package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "financialKey")
public class FinancialKey implements Serializable
{
    /**
     * This attribute maps to the column ID in the FINACIAL_KEY table.
     */
    protected int id;

    /**
     * This attribute maps to the column KEY in the FINACIAL_KEY table.
     */
    protected String key;

    /**
     * This attribute maps to the column DISPLAY_NAME in the FINACIAL_KEY table.
     */
    protected String displayName;

    /**
     * This attribute maps to the column UI_SECTION_GROUP_KEY in the FINACIAL_KEY table.
     */
    protected String uiSectionGroupKey;

    /**
     * This attribute maps to the column FINACIAL_KEY_ORDER in the FINACIAL_KEY table.
     */
    protected int finacialKeyOrder;

    /**
     * Method 'FinancialKey'
     *
     */
    public FinancialKey()
    {
    }

    /**
     * Method 'getId'
     *
     * @return int
     */
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
     * Method 'getKey'
     *
     * @return String
     */
    public String getKey()
    {
        return key;
    }

    /**
     * Method 'setKey'
     *
     * @param key
     */
    public void setKey(String key)
    {
        this.key = key;
    }

    /**
     * Method 'getDisplayName'
     *
     * @return String
     */
    public String getDisplayName()
    {
        return displayName;
    }

    /**
     * Method 'setDisplayName'
     *
     * @param displayName
     */
    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }

    /**
     * Method 'getUiSectionGroupKey'
     *
     * @return String
     */
    public String getUiSectionGroupKey()
    {
        return uiSectionGroupKey;
    }

    /**
     * Method 'setUiSectionGroupKey'
     *
     * @param uiSectionGroupKey
     */
    public void setUiSectionGroupKey(String uiSectionGroupKey)
    {
        this.uiSectionGroupKey = uiSectionGroupKey;
    }

    /**
     * Method 'getFinacialKeyOrder'
     *
     * @return int
     */
    public int getFinacialKeyOrder()
    {
        return finacialKeyOrder;
    }

    /**
     * Method 'setFinacialKeyOrder'
     *
     * @param finacialKeyOrder
     */
    public void setFinacialKeyOrder(int finacialKeyOrder)
    {
        this.finacialKeyOrder = finacialKeyOrder;
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

        if (!(_other instanceof FinancialKey)) {
            return false;
        }

        final FinancialKey _cast = (FinancialKey) _other;
        if (id != _cast.id) {
            return false;
        }

        if (key == null ? _cast.key != key : !key.equals( _cast.key )) {
            return false;
        }

        if (displayName == null ? _cast.displayName != displayName : !displayName.equals( _cast.displayName )) {
            return false;
        }

        if (uiSectionGroupKey == null ? _cast.uiSectionGroupKey != uiSectionGroupKey : !uiSectionGroupKey.equals( _cast.uiSectionGroupKey )) {
            return false;
        }

        if (finacialKeyOrder != _cast.finacialKeyOrder) {
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
        _hashCode = 29 * _hashCode + id;
        if (key != null) {
            _hashCode = 29 * _hashCode + key.hashCode();
        }

        if (displayName != null) {
            _hashCode = 29 * _hashCode + displayName.hashCode();
        }

        if (uiSectionGroupKey != null) {
            _hashCode = 29 * _hashCode + uiSectionGroupKey.hashCode();
        }

        _hashCode = 29 * _hashCode + finacialKeyOrder;
        return _hashCode;
    }

    /**
     * Method 'createPk'
     *
     * @return FinancialKeyPk
     */
    public FinancialKeyPk createPk()
    {
        return new FinancialKeyPk(id);
    }

    /**
     * Method 'toString'
     *
     * @return String
     */
    public String toString()
    {
        StringBuffer ret = new StringBuffer();
        ret.append( "com.codeitek.pdp.model.FinancialKey: " );
        ret.append( "id=" + id );
        ret.append( ", key=" + key );
        ret.append( ", displayName=" + displayName );
        ret.append( ", uiSectionGroupKey=" + uiSectionGroupKey );
        ret.append( ", finacialKeyOrder=" + finacialKeyOrder );
        return ret.toString();
    }

}
