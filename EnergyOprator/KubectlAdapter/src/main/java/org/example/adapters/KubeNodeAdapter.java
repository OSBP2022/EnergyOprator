package org.example.adapters;
import io.kubernetes.client.openapi.ApiException;
import org.example.entity.Node;
import org.example.kubernetesClient.Client;
import org.example.mapper.NodeMapper;
import org.example.module.NodeDto;
import org.example.ports.spi.NodePersostencePort;
import org.example.ports.spi.kubeNodePersistencePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class KubeNodeAdapter implements kubeNodePersistencePort {

  private Logger logger = LoggerFactory.getLogger(Client.class);
  private Client nodeClient = new Client();


  @Override
  public List<NodeDto> getNodes() {
    try {
      return NodeMapper.nodeListToNodeDtoList(nodeClient.getNodes());
    } catch (IOException | ApiException e) {
      logger.error(e.getMessage(),this);
    }
    return null;
  }

  @Override
  public NodeDto getNodesId(String nodeName) {
    try {
      Node node = nodeClient.getNode(nodeName);
      return NodeMapper.nodeToNodeDto(node);
    } catch (IOException | ApiException e) {
      throw new RuntimeException(e);
    }
  }
}
