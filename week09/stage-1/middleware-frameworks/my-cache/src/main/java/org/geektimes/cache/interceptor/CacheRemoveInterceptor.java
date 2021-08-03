package org.geektimes.cache.interceptor;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.annotation.CachePut;
import javax.cache.annotation.CacheRemove;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import org.geektimes.interceptor.AnnotatedInterceptor;

/**
 * @author Liutianyou
 * @date 2021/8/2 11:22 下午
 */
@Interceptor
public class CacheRemoveInterceptor extends AnnotatedInterceptor<CacheRemove> {

  private final CachingProvider cachingProvider = Caching.getCachingProvider();

  private final CacheManager cacheManager = cachingProvider.getCacheManager();

  @Override
  protected Object execute(InvocationContext context, CacheRemove cacheRemove)
      throws Throwable {

    String cacheName = cacheRemove.cacheName();
    Cache cache = getCache(cacheName);
    boolean afterInvocation = cacheRemove.afterInvocation();
    // The result of target method
    Object result = context.proceed();
    if (afterInvocation) {
      Object[] parameters = context.getParameters();
      Object key = parameters[0];
      cache.remove(key);
    }
    return result;
  }

  private Cache getCache(String cacheName) {
    Cache cache = cacheManager.getCache(cacheName);
    if (cache == null) {
      cache = cacheManager.createCache(cacheName,
          new MutableConfiguration().setTypes(Object.class, Object.class));
    }
    return cache;
  }
}
