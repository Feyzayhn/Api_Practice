package day03;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utilities.GMIBankBaseURL;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest07 extends GMIBankBaseURL {

    /*
http://www.gmibank.com/api/tp-customers/110472 adresindeki müşteri bilgilerini doğrulayın
   “firstName”: “Melva”,
   “lastName”: “Bernhard”,
   “email”: “chas.kuhlman@yahoo.com”
   “zipCode”: “40207"
   “country.name”: “San Jose”
   “user.login”: “delilah.metz”


     */

    @Test
    public void test07() {

        // Set the Url
        spec01.pathParams("1", "tp-customers", "2", 110472);

        // REQUEST VE RESPONSE
        Response response = given().
                spec(spec01).
                headers("Authorization", "Bearer " + generateToken()).
                when().
                get("/{1}/{2}");
        response.prettyPrint();

        // Matcher ile dogrulama
        response.then().assertThat().body("firstName", equalTo("Melva"),
                "lastName", equalTo("Bernhard"),
                "email", equalTo("chas.kuhlman@yahoo.com"),
                "zipCode", equalTo("40207"),
                "country.name", equalTo("San Jose"),
                "user.login", equalTo("delilah.metz"));

        //Json Path ile dogrulama
        JsonPath json = response.jsonPath();
        Assert.assertEquals("Melva", json.getString("firstName"));
        Assert.assertEquals("Bernhard", json.getString("lastName"));
        Assert.assertEquals("chas.kuhlman@yahoo.com", json.getString("email"));
        Assert.assertEquals("40207", json.getString("zipCode"));
        Assert.assertEquals("San Jose", json.getString("country.name"));
        Assert.assertEquals("delilah.metz", json.getString("user.login"));

    }
}
