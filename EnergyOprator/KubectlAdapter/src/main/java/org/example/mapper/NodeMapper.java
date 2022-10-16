package org.example.mapper;

import org.example.entity.Node;
import org.example.module.NodeDto;

import java.util.ArrayList;
import java.util.List;

public class NodeMapper {

  public static NodeDto nodeToNodeDto(Node node){
    NodeDto nodeDto = new NodeDto();
    nodeDto.setName(node.getName());
    nodeDto.setCpu(node.getCpu());
    nodeDto.setMemory(node.getMemory());
    nodeDto.setCreated(node.getCreated());
    return nodeDto;
  }

  public static Node nodeDtoToNode(NodeDto nodeDto){
    Node node = new Node();
    node.setName(nodeDto.getName());
    node.setCpu(node.getCpu());
    node.setMemory(node.getMemory());
    node.setCreated(node.getCreated());
    return node;
  }

  public static List<NodeDto> nodeListToNodeDtoList(List<Node> nodeList){
    List<NodeDto> nodeDtoList = new ArrayList<>();
    for (Node node:nodeList) {
      nodeDtoList.add(nodeToNodeDto(node));
    }
    return nodeDtoList;
  }

  public List<Node> nodeDtoListToNodeList(List<NodeDto> nodeDtoList){
    List<Node> nodeList = new ArrayList<>();
    for (NodeDto nodeDto:nodeDtoList) {
      nodeList.add(nodeDtoToNode(nodeDto));
    }
    return nodeList;
  }
}
