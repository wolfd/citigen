package io.wolfd.city.server.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import mikera.vectorz.Vector3;

public class RoadData {
  private final WebVector3 a;
  private final WebVector3 b;

  @JsonCreator
  public RoadData(@JsonProperty WebVector3 a, @JsonProperty WebVector3 b) {
    this.a = a;
    this.b = b;
  }

  public WebVector3 getA() {
    return a;
  }

  public WebVector3 getB() {
    return b;
  }
}
