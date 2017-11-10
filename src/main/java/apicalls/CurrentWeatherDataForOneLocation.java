package apicalls;

import assure.RestAssuredHttpClient;
import com.jayway.restassured.response.Response;
import utils.Log;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;


public class CurrentWeatherDataForOneLocation extends ApiCall{

    public static Response weatherDataForOneLocationByCityName (String q, String appid) throws IOException {
        Log.info("Performing weatherDataForOneLocationByCityName API call");
        Log.info("[query parameter] cityName: " + q);
        Log.info("[query parameter] appId: " + appid);

//        можливо варто зробити колекцію окремим методом
        Map<String,String> parameters = new HashMap<>();
        parameters.put("q", q);
        parameters.put("appid", appid);

        Response response =
                given().
                        parameters(parameters).
                        when().
                get("http://samples.openweathermap.org/data/2.5/weather");

        Log.info("Respone code: " + response.getStatusCode());
        Log.info("Response is\n: " + response.prettyPeek());
        return response;
    }

}
