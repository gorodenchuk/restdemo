package scenariosstates;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.response.Response;
import weatherResponse.WeatherResponseModel;

/**
 * Created by oshcherbatyy on 22-02-17.
 */
public class WeatherByCity {
    public int responseCode;
    public Response response;

    public WeatherResponseModel weatherResponseModel;

    public ObjectMapper objectMapper = new ObjectMapper();
}
