package org.example.ports.spi;

import org.example.module.BookDto;
import org.example.module.NodeDto;

import java.util.List;

public interface NodePersostencePort {

  List<NodeDto> getNodes();

  NodeDto getNodesId(String nodeName);
}
