package org.example.ports.api;

import org.example.module.NodeDto;

import java.util.List;

public interface NodeServicePort {
  List<NodeDto> getNodes();

  NodeDto getNodesId(String nodeName);

  List<NodeDto> getCurrentNodes();
}
