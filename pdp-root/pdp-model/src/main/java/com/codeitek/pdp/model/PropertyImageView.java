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
@XmlRootElement(name = "propertyImageView")
public class PropertyImageView implements Serializable {


    private int id;
    private String imageTitle;
    private String type;
    private String imageUrl;
    private int propertyDataId;

    public PropertyImageView() {
    }

    /**
     *
     * @param id
     * @param imageTitle
     * @param type
     * @param imageUrl
     * @param propertyDataId
     */
    public PropertyImageView(int id, String imageTitle, String type, String imageUrl, int propertyDataId) {
        this.id = id;
        this.imageTitle = imageTitle;
        this.type = type;
        this.imageUrl = imageUrl;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
