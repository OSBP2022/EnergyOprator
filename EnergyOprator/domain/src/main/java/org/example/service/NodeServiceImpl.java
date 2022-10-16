package org.example.service;

import org.example.module.NodeDto;
import org.example.ports.api.NodeServicePort;
import org.example.ports.spi.BookPersistencePort;
import org.example.ports.spi.NodePersostencePort;
import org.example.ports.spi.kubeNodePersistencePort;

import java.util.List;

public class NodeServiceImpl implements NodeServicePort {

  private NodePersostencePort nodePersostencePort;

  private kubeNodePersistencePort kubeNodePersostencePort;


  public NodeServiceImpl(NodePersostencePort nodePersostencePort, kubeNodePersistencePort kubeNodePersostencePort) {
    this.nodePersostencePort = nodePersostencePort;
    this.kubeNodePersostencePort = kubeNodePersostencePort;
  }

  @Override
  public List<NodeDto> getNodes() {
    return nodePersostencePort.getNodes();
  }

  @Override
  public NodeDto getNodesId(String nodeName) {
    return nodePersostencePort.getNodesId(nodeName);
  }

  @Override
  public List<NodeDto> getCurrentNodes() {

    return kubeNodePersostencePort.getNodes();
  }
}
