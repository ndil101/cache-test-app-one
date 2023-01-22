package com.test.testappone;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {

  private final MainService mainService;

  @GetMapping("/test/{num}")
  public MyObject getTest(@PathVariable Integer num) {
    return mainService.getResult(num);
  }

}
