package com.codeitek.pdp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 4/20/13
 * Time: 6:25 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "imageDataList")
public class ImageDataList extends GenericList<PropertyImageData> {

    @XmlElement(name = "imageData")
    @Override
    public List<PropertyImageData> getList() {
        return this.list;
    }
}
