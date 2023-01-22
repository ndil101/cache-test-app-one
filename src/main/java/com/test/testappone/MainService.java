package com.test.testappone;

import java.time.Instant;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainService {

  @Cacheable(value = "myTestOne", key = "#num")
  public MyObject getResult(Integer num) {
    return new MyObject("Num: " + num + ", DateTime: " + Instant.now());
  }

}
