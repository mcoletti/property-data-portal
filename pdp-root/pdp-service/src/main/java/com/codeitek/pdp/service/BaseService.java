package com.codeitek.pdp.service;

import com.codeitek.pdp.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/27/13
 * Time: 12:42 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class BaseService {

    private final CacheManager cacheManager;

    @Autowired
    protected BaseService(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public CacheManager getCacheManager() {
        return cacheManager;
    }

    public String CreateCacheKey(String... keys){

        StringBuilder keyBuilder = new StringBuilder();
        for(String key:keys){
            keyBuilder.append(key);
            keyBuilder.append("_");
        }

        String key = keyBuilder.toString();
        key = key.substring(0,key.lastIndexOf("_"));
        return key;
    }

}
