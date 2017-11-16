package currentweatherdata;

import assure.RestAssuredHttpClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.filter.log.LogDetail;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testbase.TestBase;
import weatherResponse.WeatherByCityResponseModel;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by gorod on 12.09.2017.
 */
public class WeatherDataForOneLocationTestSuit extends TestBase {


    private static Logger Log = Logger.getLogger(WeatherDataForOneLocationTestSuit.class.getName());


    @Test
    public void test_05() throws Exception {

        int expLondonWeatherId = 2643743;

        Map<String,String> parameters = new HashMap<>();
        parameters.put("q", "London");
        parameters.put("appid", "b1b15e88fa797225412429c1c50c122a1");

//        Log.info("Performing weatherDataForOneLocationByCityName API call");
//        Log.info("[query parameter] cityName: " + parameters.get("q"));
//        Log.info("[query parameter] appId: " + parameters.get("appid"));

        response = httpClient1.callHttpGet("/weather", parameters);

        int responseCode = response.statusCode();
        int actLondonWeatherId = objectMapper.readValue(response.asString(), WeatherByCityResponseModel.class).getId();

//        Log.info("Respone code: " + responseCode);
//        Log.info("Response is\n: " + response.prettyPeek());

        Assert.assertEquals(actLondonWeatherId,  expLondonWeatherId, "Actual weatherId doesn`t match with expected");
        Assert.assertEquals(responseCode, 200, "Actual statusCode doesn`t match with expected");
    }




//    public static void main(String[] args) {
////        RequestSpecification requestSpecification = new RequestSpecBuilder().
////                .log(LogDetail.ALL)
////                .build();
//
//
//
//        Log.info("_______________________________________________");
//        Log.info("_______________________________________________");
//        Log.info("_______________________________________________");
//        Map<String,String> parameters = new HashMap<>();
//        parameters.put("q", "London");
//        parameters.put("appid", "b1b15e88fa797225412429c1c50c122a1");
//
//        given().
//                parameters("id", "2172797").
//                param("appid", "b1b15e88fa797225412429c1c50c122a1").
//                when().
//                get("http://samples.openweathermap.org/data/2.5/weather").then().log().body();
//
//        Log.info("_______________________________________________");
//        Log.info("_______________________________________________");
////        Log.info(response.statusCode());
//        Log.info("_______________________________________________");
//        Log.info("_______________________________________________");
//        Log.info("_______________________________________________");
//    }

}