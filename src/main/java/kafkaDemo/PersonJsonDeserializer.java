package kafkaDemo;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

/**
 * Created by shirukai on 2018/8/25
 */
public class PersonJsonDeserializer implements Deserializer<Person> {
//    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

//    @Override
    public Person deserialize(String topic, byte[] data) {
        return JSON.parseObject(data, Person.class);
    }

//    @Override
    public void close() {

    }
}
