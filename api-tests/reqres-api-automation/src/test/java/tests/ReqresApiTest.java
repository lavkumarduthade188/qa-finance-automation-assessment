package tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class ReqresApiTest {

	Properties config = new Properties();

	@BeforeClass
	public void setup() throws Exception {

		InputStream file = getClass().getClassLoader().getResourceAsStream("config.properties");

		config.load(file);

		RestAssured.baseURI = config.getProperty("base.url");
	}
	
	@Test
	public void getUserSuccessfully() {

		given().header("x-api-key", config.getProperty("api.key"))

				.when().get("/api/users/2")

				.then().log().all().statusCode(200).body("data.id", equalTo(2)).body("data.email", containsString("@"))
				.body("data.first_name", instanceOf(String.class)).body("data.last_name", instanceOf(String.class));
	}

	@Test
	public void getNonExistingUser() {

		given().header("x-api-key", config.getProperty("api.key"))

				.when().get("/api/users/23")

				.then().log().all().statusCode(404);
	}
}