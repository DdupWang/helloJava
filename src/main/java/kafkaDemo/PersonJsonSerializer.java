package kafkaDemo;

import com.alibaba.fastjson.JSON;

import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

/**
 * Created by shirukai on 2018/8/25
 */
public class PersonJsonSerializer implements Serializer<Person> {
//    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

//    @Override
    public byte[] serialize(String topic, Person data) {
        return JSON.toJSONBytes(data);
    }

//    @Override
    public void close() {

    }
}
