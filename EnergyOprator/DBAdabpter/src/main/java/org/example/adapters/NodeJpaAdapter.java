package org.example.adapters;

import org.example.entity.Book;
import org.example.entity.Node;
import org.example.mapper.BookMapper;
import org.example.mapper.NodeMapper;
import org.example.module.BookDto;
import org.example.module.NodeDto;
import org.example.ports.spi.BookPersistencePort;
import org.example.ports.spi.NodePersostencePort;
import org.example.repositorys.BookRepository;
import org.example.repositorys.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NodeJpaAdapter implements NodePersostencePort {
  @Autowired
  private NodeRepository nodeRepository;

  @Override
  public List<NodeDto> getNodes() {
    List<Node> nodeList = nodeRepository.findAll();

    return NodeMapper.nodelistToNodeDtoList(nodeList);

  }

  @Override
  public NodeDto getNodesId(String nodeName) {
    List<Node> nodeList = nodeRepository.findAll();
    for (Node node : nodeList) {
      if (node.getName().equalsIgnoreCase(nodeName)) {
        return NodeMapper.nodeToNodeDto(node);
      }
    }
    return null;
  }
}
