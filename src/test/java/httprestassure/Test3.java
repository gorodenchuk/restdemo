package httprestassure;

import assure.RestAssuredHttpClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import elevation.Elevation;
import org.testng.Assert;
import org.testng.annotations.Test;
import parsers.JsonParser;
import scenariosstates.WeatherByCity;
import weatherResponse.WeatherResponseModel;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.*;

/**
 * Created by gorod on 12.09.2017.
 */
public class Test3 {

    //Simple get request for getting wea ther request by city name
    //Status code : 200
//    @Test
    public void test_01() {
        Response resp= when().
                get("http://samples.openweathermap.org/data/2.5/weather?q=London&appid=b1b15e88fa797225412429c1c50c122a1");
        System.out.println(resp.getStatusCode());
        Assert.assertEquals(resp.getStatusCode(), 200);
    }

    //How to use parameters with rest assured
//    @Test
    public void test_03() {
        Response resp = given().
                param("q", "London").
                param("appid", "b1b15e88fa797225412429c1c50c122a1").
                when().
                get("http://samples.openweathermap.org/data/2.5/weather");
        System.out.println(resp.getStatusCode());
        Assert.assertEquals(resp.getStatusCode(), 200);
    }

    //Assert our testcase in Rest assured api
//    @Test
    public void test_04() {

                given().
                        param("q", "London").
                        param("appid", "b1b15e88fa797225412429c1c50c122a1").
                        when().
                        get("http://samples.openweathermap.org/data/2.5/weather").
                        then().
                        assertThat().statusCode(200);
    }

    private WeatherByCity weatherByCity;
//
//    public Test3(WeatherByCity weatherByCity){
//        this.weatherByCity = weatherByCity;
//    }

    @Test
    public void test_05() throws IOException {

        Map<String,String> parameters = new HashMap<>();
        parameters.put("q", "London");
        parameters.put("appid", "b1b15e88fa797225412429c1c50c122a1");

        Response resp = given().
                parameters(parameters).
        when().
                get("http://samples.openweathermap.org/data/2.5/weather");
        System.out.println(resp.asString());

//        JsonParser parser = new JsonParser();
//        parser.readJsonToObject(WeatherResponseModel.class, resp.asInputStream());
//        weatherByCity.weatherResponseModel = weatherByCity.objectMapper.readValue(weatherByCity.response.asString(), WeatherResponseModel.class);
//        System.out.println("****************" + weatherByCity.weatherResponseModel.getWeather().getId().toString() + "*******************");
//        Assert.assertEquals(weatherByCity.weatherResponseModel.getId(),
//                expectedTravelDistance, "Wrong trave distance recieved from Data Matrix API");
        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.readValue(resp.asString(), WeatherResponseModel.class).getId();


//        JsonParser parser = new JsonParser();
//        WeatherResponseModel weatherResponseModel = parser.readJsonToObject(WeatherResponseModel.class,
//                resp.toString());


        System.out.println(objectMapper.readValue(resp.asString(), WeatherResponseModel.class).getId());

//        public ObjectMapper objectMapper = new ObjectMapper();
//        WeatherResponseModel weatherResponseModel = parser.readJsonToObject();


//        System.out.println(resp.asString());


    }

//    @Test
    public void test_06() {

        Response resp = given().
                parameter("id", "2172797").
                param("appid", "b1b15e88fa797225412429c1c50c122a1").
                when().
                get("http://samples.openweathermap.org/data/2.5/weather");

        Assert.assertEquals(resp.getStatusCode(), 200);

        System.out.println(resp.asString());
    }

//    @Test
    public void test_07() {

        Response resp = given().
                parameter("zip", "94040,us").
                param("appid", "b1b15e88fa797225412429c1c50c122a1").
                when().
                get("http://samples.openweathermap.org/data/2.5/weather");

        Assert.assertEquals(resp.getStatusCode(), 200);

        System.out.println(resp.asString());
    }

//    @Test
    public void test_08() {

        String weatherReport = given().
                parameter("id", "2172797").
                parameter("appid", "b1b15e88fa797225412429c1c50c122a1").
                when().
                get("http://samples.openweathermap.org/data/2.5/weather").
                then().
                contentType(ContentType.JSON).
                extract().
                path("weather[0].description");

        System.out.println("weather.report : " + weatherReport);
    }

//    @Test
    public void test_09() {

        Response resp = given().
                parameter("id", "2172797").
                parameter("appid", "b1b15e88fa797225412429c1c50c122a1").
                when().
                get("http://samples.openweathermap.org/data/2.5/weather");

        String actualWheatherReport = resp.
                then().
                contentType(ContentType.JSON).
                extract().
                path("weather[0].description");

        String expectedWeatherReport = null;

        if(actualWheatherReport.equals(expectedWeatherReport)) {
            System.out.println("Testcase pass");
        }
        else
            System.out.println("Testcase fail");
    }

//    @Test
    public void test_10() {

        Response resp = given().
                parameter("id", "2172797").
                parameter("appid", "b1b15e88fa797225412429c1c50c122a1").
                when().
                get("http://samples.openweathermap.org/data/2.5/weather");

        String reportByID = resp.
                then().
                contentType(ContentType.JSON).
                extract().
                path("weather[0].description");

        System.out.println("weather description by ID : " + reportByID);

        String lon = String.valueOf(resp.
                then().
                contentType(ContentType.JSON).
                extract().
                path("coord.lon"));

        System.out.println("Longitude is : " + lon);

        String lat = String.valueOf(resp.
                then().
                contentType(ContentType.JSON).
                extract().
                path("coord.lat"));

        System.out.println("Latitude is : " + lat);

        String reportByCoordinates = given().
                parameter("lat", lat).
                parameter("lon", lon).
                parameter("appid", "b1b15e88fa797225412429c1c50c122a1").
                when().
                get("http://samples.openweathermap.org/data/2.5/weather").
                then().contentType(ContentType.JSON).
                extract().
                path("weather[0].description");

        System.out.println("report by coordinates : " + reportByCoordinates);

        Assert.assertEquals(reportByID, reportByCoordinates);

    }
}