package com.codeitek.pdp.ui.common;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonStreamContext;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 4/16/13
 * Time: 11:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class JsonUtil {
    private JSONObject json;
    protected JsonGenerator jsonGenerator;
    protected JsonNode jsonNode;

    public String toJson(Object o){
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        jsonGenerator.configure(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT,true);

        try {
            jsonGenerator.writeObject(o);
            JsonStreamContext streamContext = jsonGenerator.getOutputContext();
            mapper.writeTree(jsonGenerator,jsonNode);

            json = mapper.writeValueAsString(o);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return json;
    }

    public String toJson(String key,Object o){
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(o);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return json;
    }
}
