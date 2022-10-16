package org.example.ports.spi;

import org.example.module.NodeDto;

import java.util.List;

public interface kubeNodePersistencePort {
  List<NodeDto> getNodes();

  NodeDto getNodesId(String nodeName);
}
