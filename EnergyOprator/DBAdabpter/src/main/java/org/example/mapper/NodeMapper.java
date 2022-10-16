package org.example.mapper;

import org.example.entity.Book;
import org.example.entity.Node;
import org.example.module.BookDto;
import org.example.module.NodeDto;

import java.util.ArrayList;
import java.util.List;

public class NodeMapper {


  public static NodeDto nodeToNodeDto(Node node){
    NodeDto nodeDto = new NodeDto();
    nodeDto.setName(node.getName());
    nodeDto.setMemory(node.getMemory());
    nodeDto.setCpu(node.getCpu());
    nodeDto.setCreated(node.getCreated());
    return nodeDto;
  }

  public static Node nodeDtoToNode(NodeDto nodeDto){
    Node node = new Node();
    node.setName(nodeDto.getName());
    node.setCpu(nodeDto.getCpu());
    node.setMemory(nodeDto.getMemory());
    node.setCreated(nodeDto.getCreated());
    return node;
  }

  public static List<NodeDto> nodelistToNodeDtoList(List<Node> nodeList){
    List<NodeDto> nodeDtoList = new ArrayList<>();
    for (Node node:nodeList) {
      nodeDtoList.add(nodeToNodeDto(node));
    }
    return nodeDtoList;
  }

  public List<Node> BookDtoListTobookList(List<NodeDto> nodeDtoList){
    List<Node> nodeList = new ArrayList<>();
    for (NodeDto nodeDto:nodeDtoList) {
      nodeList.add(nodeDtoToNode(nodeDto));
    }
    return nodeList;
  }
}
