package io.wolfd.city.server.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import mikera.vectorz.Vector3;

@JsonIgnoreProperties(ignoreUnknown=true)
public class WebVector3 {
  private final Vector3 v;

  public WebVector3(Vector3 v) {
    this.v = v;
  }
  @JsonProperty public double getX() {
    return v.getX();
  }

  @JsonProperty public double getY() {
    return v.getY();
  }

  @JsonProperty public double getZ() {
    return v.getZ();
  }
}
