package org.geektimes.cache.interceptor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.spi.CachingProvider;
import org.geektimes.cache.DataRepository;
import org.geektimes.cache.InMemoryDataRepository;
import org.geektimes.interceptor.DefaultInterceptorEnhancer;
import org.geektimes.interceptor.InterceptorEnhancer;
import org.junit.Test;

/**
 * @author Liutianyou
 * @date 2021/8/3 10:08 下午
 */
public class CacheRemoveInterceptorTest {

  private DataRepository dataRepository = new InMemoryDataRepository();

  private InterceptorEnhancer enhancer = new DefaultInterceptorEnhancer();

  private CachingProvider cachingProvider = Caching.getCachingProvider();

  private CacheManager cacheManager = cachingProvider.getCacheManager();

  @Test
  public void test() {
    DataRepository repository = enhancer.enhance(dataRepository, DataRepository.class, new CachePutInterceptor(),new CacheRemoveInterceptor());
    assertTrue(repository.create("A", 1));
    Cache cache = cacheManager.getCache("simpleCache");
    assertEquals(repository.get("A"), cache.get("A"));
    //移除元素
    assertTrue(repository.remove("A"));
    assertNull(cache.get("A"));
  }

}
