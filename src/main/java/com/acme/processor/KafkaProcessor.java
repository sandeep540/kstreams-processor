package com.acme.processor;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;


@Configuration
public class KafkaProcessor {

    @Bean
    public Function<KStream<String, Temperature>, KStream<String, FullTemperature>> tempProcessor(){

        return kStream ->
                kStream
                        .peek((k, v) -> System.out.println("Messages : " + v))
                        .mapValues(v -> processTemperature(v));

    };

        private FullTemperature processTemperature(Temperature t) {
            FullTemperature ft = new FullTemperature();
            ft.setId(t.getId());
            ft.setTemperature(t.getTemperature());
            ft.setTimestamp(t.getTimestamp());
            ft.setF_temperature((t.getTemperature() * 1.8) + 32);

            return ft;
         }

}