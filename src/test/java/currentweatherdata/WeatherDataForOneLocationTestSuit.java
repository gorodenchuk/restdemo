package currentweatherdata;

import apicalls.CurrentWeatherDataForOneLocation;
import assure.RestAssuredHttpClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.response.Response;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testbase.TestBase;
import weatherResponse.WeatherByCityResponseModel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gorod on 12.09.2017.
 */
public class WeatherDataForOneLocationTestSuit extends TestBase {


    private static Logger Log = Logger.getLogger(WeatherDataForOneLocationTestSuit.class.getName());
    Response response;

    @Test
    public void test_05() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        int expLondonWeatherId = 2643743;

        response = CurrentWeatherDataForOneLocation.
                weatherDataForOneLocationByCityName("London", "b1b15e88fa797225412429c1c50c122a1");

        int responseCode = response.statusCode();
        int actLondonWeatherId = objectMapper.readValue(response.asString(), WeatherByCityResponseModel.class).getId();

        Assert.assertEquals(actLondonWeatherId,  expLondonWeatherId, "Actual weatherId doesn`t match with expected");
        Assert.assertEquals(responseCode, 200, "Actual statusCode doesn`t match with expected");
    }

}