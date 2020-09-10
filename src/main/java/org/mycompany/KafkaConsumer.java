package org.mycompany;

import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Component
public class KafkaConsumer extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		
		Processor upProcessor = new UpperCaseProcessor();
		
		  from("kafka:{{kafka.topic}}?brokers={{kafka.host}}:{{kafka.port}}")
          .log("Message received from Kafka : ${body}")
          .log("    on the topic ${headers[kafka.TOPIC]}")
          .log("    on the partition ${headers[kafka.PARTITION]}")
          .log("    with the offset ${headers[kafka.OFFSET]}")
          .log("    with the key ${headers[kafka.KEY]}")
          .process(upProcessor)
          .log("${body}");
		
		
	}


	
	
}
