package testbase;

import assure.RestAssuredHttpClient;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    RestAssuredHttpClient httpClient1;

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
