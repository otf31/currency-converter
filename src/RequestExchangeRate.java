import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestExchangeRate {
  public ExchangeRate searchExchangeRate(String currency){
    var uri = URI.create("https://v6.exchangerate-api.com/v6/87eed5ffccaf7a681074bba3/latest/" +  currency);

    var client = HttpClient.newHttpClient();
    var request = HttpRequest.newBuilder()
            .uri(uri)
            .build();

    try {
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

      return new Gson().fromJson(response.body(), ExchangeRate.class);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
