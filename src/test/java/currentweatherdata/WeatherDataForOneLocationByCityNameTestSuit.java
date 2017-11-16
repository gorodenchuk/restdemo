package currentweatherdata;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testbase.TestBase;
import weatherResponse.WeatherByCityResponseModel;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by gorod on 12.09.2017.
 */
public class WeatherDataForOneLocationByCityNameTestSuit extends TestBase {


    private static Logger Log = Logger.getLogger(WeatherDataForOneLocationByCityNameTestSuit.class.getName());


    @Test (description = "Request with valid data in cityName and appid parameters. Response should be 200")
    public void checkStatusCodeOfRequestWithValidData() throws Exception {
        Map<String,String> parameters = new HashMap<>();
        parameters.put("q", "London");
        parameters.put("appid", "b1b15e88fa797225412429c1c50c122a1");

        response = httpClient1.callHttpGet("/weather", parameters);
        int responseCode = response.statusCode();

        Assert.assertEquals(responseCode, 200, "Actual statusCode doesn`t match with expected");
    }

    @Test (description = "Request with invalid cityName and valid appid parameters. Response should be 404")
    public void checkStatusCodeOfRequestWithInvalidCityName() throws Exception {
        Map<String,String> parameters = new HashMap<>();
        parameters.put("q", "qwerty");
        parameters.put("appid", "b1b15e88fa797225412429c1c50c122a1");

        response = httpClient1.callHttpGet("/weather", parameters);
        int responseCode = response.statusCode();

        Assert.assertEquals(responseCode, 404, "Actual statusCode doesn`t match with expected");
    }

    @Test (description = "Request with missed cityName but valid appid parameters. Response should be 404")
    public void checkStatusCodeOfRequestWithMissedCityName() throws Exception {
        Map<String,String> parameters = new HashMap<>();
        parameters.put("appid", "b1b15e88fa797225412429c1c50c122a1");

        response = httpClient1.callHttpGet("/weather", parameters);
        int responseCode = response.statusCode();

        Assert.assertEquals(responseCode, 401, "Actual statusCode doesn`t match with expected");
    }

    @Test (description = "Request with missed cityName and appid parameters. Response should be 404")
    public void checkStatusCodeOfRequestWithMissedCityNameAndAppId() throws Exception {
        response = httpClient1.callHttpGet("/weather");
        int responseCode = response.statusCode();

        Assert.assertEquals(responseCode, 401, "Actual statusCode doesn`t match with expected");
    }

    @Test (description = "Request with valid data in cityName and appid parameters. CityID shoud be 2643743")
    public void checkCityIdWithValidData() throws Exception {
        int expLondonId = 2643743;
        Map<String,String> parameters = new HashMap<>();
        parameters.put("q", "London");
        parameters.put("appid", "b1b15e88fa797225412429c1c50c122a1");

        response = httpClient1.callHttpGet("/weather", parameters);
        int actLondonId = objectMapper.readValue(response.asString(), WeatherByCityResponseModel.class).getId();

        Assert.assertEquals(actLondonId,  expLondonId, "Actual cityId doesn`t match with expected");
    }




}