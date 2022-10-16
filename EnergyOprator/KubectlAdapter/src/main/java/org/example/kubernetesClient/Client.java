package org.example.kubernetesClient;

import io.kubernetes.client.Metrics;
import io.kubernetes.client.custom.NodeMetrics;
import io.kubernetes.client.custom.NodeMetricsList;
import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.util.Config;
import org.example.entity.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Client {

  private Logger logger = LoggerFactory.getLogger(Client.class);

  public List<Node> getNodes() throws IOException, ApiException {
    List<Node> nodesList= new ArrayList<>();
    ApiClient client = Config.defaultClient();
    Configuration.setDefaultApiClient(client);
    Metrics metrics = new Metrics(client);
    NodeMetricsList list = metrics.getNodeMetrics();
    for (NodeMetrics item : list.getItems()) {
      Node node = new Node();
      node.setName(item.getMetadata().getName());
      node.setCpu(item.getUsage().get("cpu").getNumber().toString());
      node.setCpu(item.getUsage().get("memory").getNumber().toString());
      node.setCreated(item.getMetadata().getCreationTimestamp().toString());
      nodesList.add(node);
    }
    logger.info(nodesList.toString());
    return nodesList;
  }
  public Node getNode(String name) throws IOException, ApiException {

    ApiClient client = Config.defaultClient();
    Configuration.setDefaultApiClient(client);
    Metrics metrics = new Metrics(client);
    NodeMetricsList list = metrics.getNodeMetrics();
    for (NodeMetrics item : list.getItems()) {
      if(item.getMetadata().getName().equalsIgnoreCase(name)){
        Node node = new Node();
        node.setName(item.getMetadata().getName());
        node.setCpu(item.getUsage().get("cpu").toString());
        node.setCpu(item.getUsage().get("memory").toString());
        node.setCreated(item.getMetadata().getCreationTimestamp().toString());
        return node;
      }

    }
    return new Node();
  }
}
