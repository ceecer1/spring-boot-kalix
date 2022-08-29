package com.example.deal.action;

import com.example.Boot;
import com.example.deal.action.base.AbstractDealTopicJsonServiceAction;
import com.example.deal.domain.DealDomain;
import com.google.protobuf.Any;
import kalix.javasdk.JsonSupport;
import kalix.javasdk.action.ActionCreationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Flow;

// This class was initially generated based on the .proto definition by Kalix tooling.
// This is the implementation for the Action Service described in your com/example/deal/action/deal_topic_json_api.proto file.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class DealTopicJsonServiceAction extends AbstractDealTopicJsonServiceAction {

  private static final Logger LOG = LoggerFactory.getLogger(DealTopicJsonServiceAction.class);

  public DealTopicJsonServiceAction(ActionCreationContext creationContext) {}

  static class StringSubscriber implements HttpResponse.BodySubscriber<String> {

    final CompletableFuture<String> bodyCF = new CompletableFuture<>();
    Flow.Subscription subscription;
    List<ByteBuffer> responseData = new CopyOnWriteArrayList<>();

    @Override
    public CompletionStage<String> getBody() {
      return bodyCF;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
      this.subscription = subscription;
      subscription.request(1); // Request first item
    }

    @Override
    public void onNext(List<ByteBuffer> buffers) {
      System.out.println("-- onNext " + buffers);
      try {
        System.out.println("\tBuffer Content:\n" + asString(buffers));
      }
      catch (Exception e) {
        System.out.println("\tUnable to print buffer content");
      }
      buffers.forEach(ByteBuffer::rewind); // Rewind after reading
      responseData.addAll(buffers);
      subscription.request(1); // Request next item
    }

    @Override
    public void onError(Throwable throwable) {
      bodyCF.completeExceptionally(throwable);
    }

    @Override
    public void onComplete() {
      bodyCF.complete(asString(responseData));
    }

    private String asString(List<ByteBuffer> buffers) {
      return new String(toBytes(buffers), StandardCharsets.UTF_8);
    }

    private byte[] toBytes(List<ByteBuffer> buffers) {
      int size = buffers.stream()
              .mapToInt(ByteBuffer::remaining)
              .sum();
      byte[] bs = new byte[size];
      int offset = 0;
      for (ByteBuffer buffer : buffers) {
        int remaining = buffer.remaining();
        buffer.get(bs, offset, remaining);
        offset += remaining;
      }
      return bs;
    }

  }

  @Override
  public Effect<Any> dealChangeJsonToTopic(DealDomain.DealSubmitted dealSubmitted) {
    DealSubmittedMessage jsonMessage =
            new DealSubmittedMessage(
                    dealSubmitted.getDealIdx(),
                    dealSubmitted.getModifiedTimestamp(),
                    dealSubmitted.getStatus());
    Any jsonAny = JsonSupport.encodeJson(jsonMessage);

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .POST(HttpRequest.BodyPublishers.ofString("{\"sql\":\"SELECT * FROM USER_VIEWS EMIT CHANGES;\", \"properties\": { \"ksql.streams.auto.offset.reset\": \"earliest\" }}"))
            .uri(URI.create("https://pksqlc-7kzyw.us-east-2.aws.confluent.cloud/query-stream"))
            .header("Authorization", getBasicAuthenticationHeader("N5NGLX7TIHB7S2YD", "WkvGOu7aQeSJIzlBpXMwy/BhCtTmGjfG15VxhDa/PEM1+jPbKNm4O5vRAKcjzkP8"))

            .build();

    client.sendAsync(request, responseInfo -> new StringSubscriber())
            .whenComplete((r, t) -> LOG.info("--- Message Body: " + r.body()))
            .thenApply(HttpResponse::body);
    return effects().reply(jsonAny);
  }

  private static final String getBasicAuthenticationHeader(String username, String password) {
    String valueToEncode = username + ":" + password;
    return "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());
  }
}
