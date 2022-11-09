package day04;

import io.restassured.response.Response;
import org.junit.Test;
import pojos.Account;
import pojos.Country;
import pojos.Customer;
import pojos.User;
import utilities.GMIBankBaseURL;
import utilities.JsonUtil;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class GetRequest09 extends GMIBankBaseURL {

   /*
http://www.gmibank.com/api/tp-customers/110452

Pojo ile dogrulama yap
 */

    @Test
    public void test09() {

         /*
    "user": {
        "id": 110016,
        "login": "leopoldo.reinger",
        "firstName": "Jasmine",
        "lastName": "Stehr",
        "email": "marni.zboncak@yahoo.com",
        "activated": true,
        "langKey": "en",
        "imageUrl": null,
        "resetDate": null
    },
     */

        // Set the Url
        spec01.pathParams("1", "tp-customers", "2", 110452);

        // Account [] accounts;

        User user = new User(110016, "leopoldo.reinger", "Jasmine", "Stehr",
                "marni.zboncak@yahoo.com", true, "en", null, null);

        Country country = new Country(3, "USA", null);

        Customer expectedData = new Customer(110452, "Jasmine", "Stehr", "V", "marni.zboncak@yahoo.com",
                "463-609-2097", "1-112-497-0270", "16525", "14387 Al Ridge5343 Bert Burgs",
                "Waltermouth", "761-59-2911", "2021-11-28T21:00:00Z", false, country, "California", user);

        System.err.println("expectedData = " + expectedData); // rengi kirmizi olsun diye err yaptik ekranda kolay gorelim diye ama normalde bu çok kullanilmaz çünkü err error demektir

        Response response = given().
                spec(spec01).
                headers("Authorization", "Bearer " + generateToken()).
                when().
                get("/{1}/{2}");

        response.prettyPrint();

        Customer actualData = response.as(Customer.class);
        System.out.println("actualData = " + actualData);

        assertEquals(expectedData.getId(),actualData.getId());
        assertEquals(expectedData.getUser().getLogin(),actualData.getUser().getLogin());
        assertEquals(expectedData.getCountry().getName(),actualData.getCountry().getName());

        //Object Mapper

        Customer actualData2 = JsonUtil.convertJsonToJava(response.asString(),Customer.class);
        System.out.println("actualData2 = " + actualData2);

        assertEquals(expectedData.getId(),actualData.getId());
        assertEquals(expectedData.getUser().getLogin(),actualData.getUser().getLogin());
        assertEquals(expectedData.getCountry().getName(),actualData.getCountry().getName());

    }
}
