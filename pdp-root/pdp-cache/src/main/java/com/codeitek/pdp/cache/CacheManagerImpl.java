package com.codeitek.pdp.cache;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/27/13
 * Time: 2:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class CacheManagerImpl implements CacheManager {

    private final boolean cacheEndabled;

    @Autowired
    public CacheManagerImpl(String cacheEnabled) {
        this.cacheEndabled = Boolean.valueOf(cacheEnabled);
    }


    @Override
    public <T> T getCacheItem(String key) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T> T getCacheItem(String key, String cacheStore) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T> T addCacheItem(String key, T cache) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T> T addCacheItem(String key, T cache, String cacheStore) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T> List<T> addCacheItems() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T> List<T> addCacheItems(String cacheStore) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean deleteCacheItem(String key) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean deleteCacheItem(String key, String cacheStore) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean resetCache() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean resetCache(String cacheStore) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isCacheEnabled() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
