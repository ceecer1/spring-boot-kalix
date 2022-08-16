package com.example;

import java.util.Arrays;
import java.util.Collections;

import com.example.deal.action.DealTopicJsonServiceAction;
import com.example.deal.action.DealTopicServiceAction;
import com.example.deal.domain.DealEntity;
import com.example.deal.view.DealViewServiceImpl;
import kalix.javasdk.Kalix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Boot {
    private static final Logger LOG = LoggerFactory.getLogger(Boot.class);

    public static Kalix createKalix() {
        // The KalixFactory automatically registers any generated Actions, Views or Entities,
        // and is kept up-to-date with any changes in your protobuf definitions.
        // If you prefer, you may remove this and manually register these components in a
        // `new Kalix()` instance.
        return KalixFactory.withComponents(
                DealEntity::new,
                DealTopicJsonServiceAction::new,
                DealTopicServiceAction::new,
                DealViewServiceImpl::new);
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Boot.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "8083"));
        app.run(args);
        LOG.info("starting the Kalix service");
        createKalix().start();
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
//
//            System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }
//
//        };
//    }

}
