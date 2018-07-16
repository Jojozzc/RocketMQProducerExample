import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.common.RemotingHelper;

public class Producer {
    public static void main(String[] args)throws MQClientException, InterruptedException {
        String topic = "MsgLog";
        String tag = "msgSend";
        System.out.println(ServerConfig.getNamesvrURL());
        DefaultMQProducer producer = new DefaultMQProducer("producer1");
        producer.setNamesrvAddr(ServerConfig.getNamesvrURL() );
        producer.start();
        for (int i = 0; i < 10; i++) {
            try {
                Message msg = new Message(topic,// topic
                        tag,// tag
                        ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET)// body
                );
                //调用producer的send()方法发送消息
                //这里调用的是同步的方式，所以会有返回结果
                SendResult sendResult = producer.send(msg);
                //打印返回结果，可以看到消息发送的状态以及一些相关信息
                System.out.println(sendResult);
            } catch (Exception e) {
                e.printStackTrace();
                Thread.sleep(1000);
            }
        }

        //发送完消息之后，调用shutdown()方法关闭producer
        producer.shutdown();

    }
}
