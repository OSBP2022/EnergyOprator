package org.example.entity;

public class Node {

  private String name;
  private String cpu;
  private String memory;
  private String created;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCpu() {
    return cpu;
  }

  public void setCpu(String cpu) {
    this.cpu = cpu;
  }

  public String getMemory() {
    return memory;
  }

  public void setMemory(String memory) {
    this.memory = memory;
  }

  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  @Override
  public String toString() {
    return "Node{" +
            "name='" + name + '\'' +
            ", cpu='" + cpu + '\'' +
            ", memory='" + memory + '\'' +
            ", created='" + created + '\'' +
            '}';
  }
}
