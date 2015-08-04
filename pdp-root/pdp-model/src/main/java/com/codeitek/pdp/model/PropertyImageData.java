package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 4/20/13
 * Time: 6:23 PM
 * To change this template use File | Settings | File Templates.
 */
@Deprecated
@XmlRootElement(name = "propertyImageData")
public class PropertyImageData implements Serializable {


    private int id;
    private String imageTitle;
    private String imageUrl;
    private String imageType;
    private int propertyDataId;

    public PropertyImageData() {
    }

    /**
     *
     * @param id
     * @param imageTitle
     * @param imageUrl
     * @param imageType
     * @param propertyDataId
     */
    public PropertyImageData(int id, String imageTitle, String imageUrl, String imageType, int propertyDataId) {
        this.id = id;
        this.imageTitle = imageTitle;
        this.imageUrl = imageUrl;
        this.imageType = imageType;
        this.propertyDataId = propertyDataId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageTitle() {
        return imageTitle;
    }

    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getPropertyDataId() {
        return propertyDataId;
    }

    public void setPropertyDataId(int propertyDataId) {
        this.propertyDataId = propertyDataId;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }
}
