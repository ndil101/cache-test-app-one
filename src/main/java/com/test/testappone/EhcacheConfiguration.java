package com.test.testappone;

import java.time.Duration;
import javax.cache.CacheManager;
import javax.cache.Caching;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.jsr107.Eh107Configuration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableCaching
@Configuration
public class EhcacheConfiguration {

  @Bean
  public CacheManager EhcacheManager() {
    var cachingProvider = Caching.getCachingProvider();
    var cacheManager = cachingProvider.getCacheManager();

    cacheManager.createCache("myTestOne",
        Eh107Configuration.fromEhcacheCacheConfiguration(
            CacheConfigurationBuilder
                .newCacheConfigurationBuilder(Integer.class,
                    MyObject.class,
                    ResourcePoolsBuilder.newResourcePoolsBuilder()
                        .offheap(100, MemoryUnit.MB)
                        .build())
                .withExpiry(ExpiryPolicyBuilder.timeToIdleExpiration(Duration.ofHours(23)))
                .build()
        )
    );

    return cacheManager;
  }

}
