package org.example;

import com.google.gson.reflect.TypeToken;
import io.kubernetes.client.Metrics;
import io.kubernetes.client.custom.ContainerMetrics;
import io.kubernetes.client.custom.NodeMetrics;
import io.kubernetes.client.custom.NodeMetricsList;
import io.kubernetes.client.custom.PodMetrics;
import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1Namespace;
import io.kubernetes.client.openapi.models.V1Pod;
import io.kubernetes.client.openapi.models.V1PodList;
import io.kubernetes.client.util.Config;
import io.kubernetes.client.util.Watch;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException, ApiException {
    ApiClient client = Config.defaultClient();
    Configuration.setDefaultApiClient(client);

    Metrics metrics = new Metrics(client);
    NodeMetricsList list = metrics.getNodeMetrics();
    for (NodeMetrics item : list.getItems()) {
      System.out.println(item.getMetadata().getName());
      System.out.println("------------------------------");
      for (String key : item.getUsage().keySet()) {
        System.out.println("\t" + key);
        System.out.println("\t" + item.getUsage().get(key));
      }
      System.out.println();
    }

    for (PodMetrics item : metrics.getPodMetrics("default").getItems()) {
      System.out.println(item.getMetadata().getName());
      System.out.println("------------------------------");
      if (item.getContainers() == null) {
        continue;
      }
      for (ContainerMetrics container : item.getContainers()) {
        System.out.println(container.getName());
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        for (String key : container.getUsage().keySet()) {
          System.out.println("\t" + key);
          System.out.println("\t" + container.getUsage().get(key));
        }
        System.out.println();
      }
    }
  }
}