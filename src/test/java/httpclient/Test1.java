//package httpclient;
//
//import elevation.Elevation;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.methods.HttpUriRequest;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import parsers.JsonParser;
//import org.apache.http.impl.client.HttpClientBuilder;
//
//import java.io.IOException;
//import java.net.URISyntaxException;
//import java.net.URL;
//import java.util.HashMap;
//import java.util.Map;
////import utility.data.test.ElevationServiceData;
//
//public class Test1 {
//
//	private static final Logger Log = LogManager.getLogger(Test1.class);
//	HttpClientHelper helper;
//
//	@BeforeMethod
//	public void setup() {
//		helper = new HttpClientHelper();
//	}
//
////	@Test
//	public void httpClientTest1() throws ClientProtocolException,
//			URISyntaxException, IOException {
//		URL testUrl = new URL("https", "maps.googleapis.com",
//				"/maps/api/elevation/json");
//
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("locations", "39.7391536,-104.9847034");
//		HttpResponse response = helper.executeGetRequest(testUrl, params);
//
//		System.out.println("---------------------------" + "\n" + response + "\n" + "--------------------------");
//
//		Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
//		Assert.assertEquals(response.getEntity().getContentType().getValue(),
//				"application/json; charset=UTF-8");
//
//	}
//
////	@Test
//	public void httpClientTestTimeout() throws ClientProtocolException,
//			URISyntaxException, IOException {
//		URL testUrl = new URL("https", "maps.googleapis.com",
//				"/maps/api/elevation/json");
//
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("locations", "39.7391536,-104.9847034");
//		try {
//			HttpResponse response = helper.executeGetRequestWithTimeout(
//					testUrl, params, 100);
//			System.out.println("---------------------------" + "\n" + response + "\n" + "--------------------------");
//
//			Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
//		} catch (Exception e) {
//			Assert.fail("connection timeout");
//		}
//
//	}
//
//	@Test
//	public void httpClientTestTResponseBody() throws ClientProtocolException,
//			URISyntaxException, IOException {
//		URL testUrl = new URL("https", "maps.googleapis.com",
//				"/maps/api/elevation/json");
//
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("locations", "39.7391536,-104.9847034");
//
//		HttpResponse response = helper.executeGetRequest(testUrl, params);
//
//		JsonParser parser = new JsonParser();
//		Elevation elev = parser.readJsonToObject(Elevation.class, response.getEntity()
//				.getContent());
//
//		System.out.println("---------------------------" + "\n" + response + "\n" + "--------------------------");
//
//		Assert.assertTrue(elev.getResults().get(0).getLocation().getLat() == 39.7391536);
//	}
//
////	@Test
////	public void httpClientTestDBResponseBody() throws ClientProtocolException,
////			URISyntaxException, IOException {
////		URL testUrl = new URL("https", "maps.googleapis.com",
////				"/maps/api/elevation/json");
////
////		String lat1 = "39.7391536";
////		String lng1 = "-104.9847034";
////		Map<String, String> params = new HashMap<String, String>();
////		params.put("locations", lat1 + "," + lng1);
////
////		HttpResponse response = helper.executeGetRequest(testUrl, params);
////
////		JsonParser parser = new JsonParser();
////		Elevation elev = parser.readJsonToObject(Elevation.class, response.getEntity()
////				.getContent());
////
////		ElevationServiceData service = new ElevationServiceData();
////		Result res = service.prepareElevationObjects(lat1, lng1);
//
////		Assert.assertEquals(elev.getResults().get(0), res);
////	}
//}
