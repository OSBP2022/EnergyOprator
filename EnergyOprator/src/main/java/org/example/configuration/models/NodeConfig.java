package org.example.configuration.models;


import org.example.adapters.KubeNodeAdapter;
import org.example.adapters.NodeJpaAdapter;
import org.example.ports.api.NodeServicePort;
import org.example.ports.spi.NodePersostencePort;;
import org.example.ports.spi.kubeNodePersistencePort;
import org.example.service.NodeServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NodeConfig {
  @Bean
  public NodePersostencePort nodePersistence(){return new NodeJpaAdapter();}

  @Bean
  public kubeNodePersistencePort KubenodePersistence(){return new KubeNodeAdapter();}

  @Bean
  public NodeServicePort nodeService(){
    return new NodeServiceImpl(nodePersistence(), KubenodePersistence());
  }
}
