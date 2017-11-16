package testbase;

import assure.RestAssuredHttpClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import utils.LogListener;

@Listeners(LogListener.class)
public class TestBase {

    protected RestAssuredHttpClient httpClient1;
    protected Response response;
    protected ObjectMapper objectMapper = new ObjectMapper();

    @BeforeClass
    public void setupHttpClientTests() throws Exception {
        httpClient1 = new RestAssuredHttpClient("http://samples.openweathermap.org",
                "/data/2.5");
    }


    @AfterClass
    public void tearDownHttpClientTests() {
        httpClient1.resetClientProps();
    }
}
