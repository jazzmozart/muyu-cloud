package com.muyus.muyucloud.data.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.ReadPreference;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.annotations.Entity;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AnnotationTypeFilter;

/**
 * MongoConfiguration
 *
 * @author: WangHui
 * @email: adan_wang@dingyuegroup.cn
 * @date: 2018/2/12
 */
@Configuration
public class MongoConfiguration {
    private final String basePackage = "com.muyus.muyucloud.data.mongodb.entity";

    @Bean
    public Datastore getDatastore(MongoProperties mongoProperties) {
        Morphia morphia = new Morphia();
        MongoClientOptions.Builder builder = MongoClientOptions.builder().readPreference(ReadPreference.primaryPreferred());

        MongoClientURI mongoClientURI = new MongoClientURI(mongoProperties.getUri(), builder);

        ClassPathScanningCandidateComponentProvider entityScanner = new ClassPathScanningCandidateComponentProvider(true);
        entityScanner.addIncludeFilter(new AnnotationTypeFilter(Entity.class));
        for (BeanDefinition candidate : entityScanner.findCandidateComponents(basePackage)) {
            try {
                morphia.map(Class.forName(candidate.getBeanClassName()));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return morphia.createDatastore(new MongoClient(mongoClientURI), mongoProperties.getDatabase());
    }
}
