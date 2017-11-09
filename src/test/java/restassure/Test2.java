package restassure;

import assure.RestAssuredHttpClient;
import elevation.Elevation;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import parsers.JsonParser;


import java.util.HashMap;
import java.util.Map;

public class Test2 {

	private static final Logger Log = LogManager.getLogger(Test2.class);

	RestAssuredHttpClient httpClient1;
	RestAssuredHttpClient httpClient2;

	@BeforeClass
	public void setupHttpClientTests() throws Exception {
		httpClient1 = new RestAssuredHttpClient("https://maps.googleapis.com",
				"/maps/api");
	}

	@AfterClass
	public void tearDownHttpClientTests() {
		httpClient1.resetClientProps();
	}

	@Test
	public void getHttpMethodAndJsonToObjectMapperTest() throws Exception {
		Map<String, String> params3 = new HashMap<String, String>();
		params3.put("path", "36.578581,-118.291994|36.23998,-116.83171");
		params3.put("samples", "3");
		JsonParser parser = new JsonParser();
		Elevation elevation = parser.readJsonToObject(Elevation.class,
				httpClient1.callHttpGet("/elevation/json", params3).asInputStream());

		Assert.assertEquals(-116.831710, elevation.getResults().get(2)
				.getLocation().getLng());
	}

}