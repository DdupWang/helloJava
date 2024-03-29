package kafkaDemo;


//import util.properties packages

//import org.apache.kafka.common.serialization.StringSerializer
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

//import simple producer packages
//import KafkaProducer packages
//import ProducerRecord packages

//Create java class named"SimpleProducer"
public class kafkaProduce {

    public static void main(String[] args) throws Exception {

        // Check arguments length value
        if (args.length == 0) {
            System.out.println("Enter topic name");
            return;
        }

        //Assign topicName to string variable
        String topicName = args[0].toString();

        // create instance for properties to access producer configs
        Properties props = new Properties();

        //Assign localhost id
        props.put("bootstrap.servers","localhost:9092");

        //Set acknowledgements for producer requests.
        props.put("acks","all");

        //If the request fails, the producer can automatically retry,
        props.put("retries", 0);

        //Specify buffer size in config
        props.put("batch.size", 16384);

        //Reduce the no of requests less than 0
        props.put("linger.ms", 1);

        //The buffer.memory controls the total amount of memory available to the producer for buffering.
        props.put("buffer.memory", 33554432);

        //key的序列化方式
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        //value的序列化方式
        props.put("value.serializer", "kafkaDemo.PersonJsonSerializer");

        Producer<String, String> producer = new KafkaProducer<String, String>(props);

        Person person=new Person();
        for (int i = 0; i < 100; i++) {

            person.setAge(i);
            person.setId(i);
            person.setName("Mr WangRui");
//            producer.send(new ProducerRecord<String,Person>(topicName,"1", person));
        }
        System.out.println("Message sent successfully");
        producer.close();
    }
}
