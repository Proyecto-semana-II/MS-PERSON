package com.proyectobancario.personmicroservicios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.proyectobancario.personmicroservicios.model.dto.Parameter;

@Service
public class KafkaSenderServiceImpl implements IKafkaSenderService {

	@Autowired
	KafkaTemplate kafkaTemplate;

	@Override
	public void sendMessage(String topico, Parameter parameter) {
		ListenableFuture<SendResult<String, Parameter>> future = kafkaTemplate.send(topico, parameter);
		future.addCallback(new  ListenableFutureCallback<SendResult<String, Parameter>>() {

			@Override
			public void onSuccess(SendResult<String, Parameter> result) {
				System.out.println("Enviado "+result.getProducerRecord().value().getName()+" al topic "+result.getRecordMetadata().topic());
				
			}

			@Override
			public void onFailure(Throwable ex) {
				ex.printStackTrace();
			}
		});
	}
	
	
	/*String kafkaTopic = "test1";
	
	public void send(String message) {
	    
	    kafkaTemplate.send(kafkaTopic, message);
	}*/

}
