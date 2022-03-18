//package com.myooo.myooo.practice.kafka;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.common.record.BaseRecords;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//
//@Slf4j
//@Service
//public class OOOKafkaListener {
//
////    @KafkaListener(topics = "fact_external_fee_pay", autoStartup = "true", concurrency = "1", clientIdPrefix = "FactExternalFeePay", groupId = "${spring.kafka.consumer.group-id}")
//    public void kafkaListener(List<ConsumerRecord<String, BaseRecords>> records) {
//        log.info("OOOKafkaListener 接到kafka消息: [{}]", records.toString());
//    }
//}
