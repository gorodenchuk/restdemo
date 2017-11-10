package apicalls;

import com.jayway.restassured.RestAssured;

import static com.jayway.restassured.RestAssured.config;
import static com.jayway.restassured.config.LogConfig.logConfig;


public class ApiCall {

    static {
        RestAssured.config = config().logConfig(logConfig().enablePrettyPrinting(false));
//        RestAssured.baseURI = PropertyLoader.loadProperty("backendApiUrl");
        RestAssured.config = config().logConfig(logConfig().enableLoggingOfRequestAndResponseIfValidationFails());
    }


}
