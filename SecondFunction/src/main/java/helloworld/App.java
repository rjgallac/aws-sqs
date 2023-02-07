package helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.SendMessageRequest;

/**
 * Handler for requests to Lambda function.
 */
public class App implements RequestHandler<SQSEvent, Void> {

    public Void handleRequest(SQSEvent sqsEvent, Context context) {
        for(SQSEvent.SQSMessage msg : sqsEvent.getRecords()){
            System.out.println(new String(msg.getBody()));
        }
//        String queueUrl = System.getenv("QUEUE_URL");
//        System.out.println(queueUrl);
//        System.out.println("HIHIHI-------");
//        AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();
//        List<Message> messages = sqs.receiveMessage(queueUrl).getMessages();
//        System.out.println(messages);
//        for (Message m : messages) {
//            System.out.println("reading message" + m.getBody());
//        }
//
//        for (Message m : messages) {
//            System.out.println("deleting message");
//            sqs.deleteMessage(queueUrl, m.getReceiptHandle());
//        }
        return null;

    }

    private String getPageContents(String address) throws IOException{
        URL url = new URL(address);
        try(BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return br.lines().collect(Collectors.joining(System.lineSeparator()));
        }
    }
}
