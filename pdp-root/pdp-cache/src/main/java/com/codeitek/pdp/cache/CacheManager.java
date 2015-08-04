package com.codeitek.pdp.cache;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mcoletti
 * Date: 7/27/13
 * Time: 12:39 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CacheManager {
       public<T> T getCacheItem(String key);
       public<T> T getCacheItem(String key,String cacheStore);
       public<T> T addCacheItem(String key,T cache);
       public<T> T addCacheItem(String key,T cache,String cacheStore);
       public<T> List<T> addCacheItems();
       public<T> List<T> addCacheItems(String cacheStore);
       public boolean deleteCacheItem(String key);
       public boolean deleteCacheItem(String key,String cacheStore);
       public boolean resetCache();
       public boolean resetCache(String cacheStore);
       public boolean isCacheEnabled();
}
