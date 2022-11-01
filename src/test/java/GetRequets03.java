import io.restassured.response.Response;
import org.junit.Test;
import org.junit.internal.RealSystem;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetRequets03 {

    /* Matchers ile datalari dogrulayiniz
     "id": 5,
            "email": "charles.morris@reqres.in",
            "first_name": "Charles",
            "last_name": "Morris",
            "avatar": "https://reqres.in/img/faces/5-image.jpg"
     */


    @Test
    public void test01() {

        // id 'si 5 olan veri icin index olarak girdik 4 diye

        String url = "https://reqres.in/api/users";
       Response response = given().when().get(url);

       response.then().
               body("data[4].email",equalTo("charles.morris@reqres.in"),
               "data[4].first_name",equalTo("Charles"),
               "data[4].last_name",equalTo("Morris"));



    }

    @Test
    public void test02() {

        /*
         "id": 2,
            "email": "janet.weaver@reqres.in",
            "first_name": "Janet",
            "last_name": "Weaver",
            "avatar": "https://reqres.in/img/faces/2-image.jpg"
         */

        String url = "https://reqres.in/api/users";
        Response response = given().when().get(url);

        response.then().body("data[1].email",equalTo("janet.weaver@reqres.in"),
                "data[1].first_name",equalTo("Janet"),
                "data[1].last_name",equalTo("Weaver"));

    }

    @Test
    public void test03() {

        /*
        "id": 3,
            "email": "emma.wong@reqres.in",
            "first_name": "Emma",
            "last_name": "Wong",
         */
        String url = "https://reqres.in/api/users";
        Response response = given().when().get(url);

        response.
                then().
                body("data[2].email",equalTo("emma.wong@reqres.in"),
                "data[2].first_name",equalTo("Emma"),
                "data[2].last_name",equalTo("Wong"));


    }

    @Test
    public void test04() {

        /*
         "id": 4,
            "email": "eve.holt@reqres.in",
            "first_name": "Eve",
            "last_name": "Holt",
         */

        String url = "https://reqres.in/api/users";
        Response response = given().when().get(url);

        response.
                then().
                body("data[3].email",equalTo("eve.holt@reqres.in"),
                        "data[3].first_name",equalTo("Eve"),
                        "data[3].last_name",equalTo("Holt"));

    }

    @Test
    public void test05() {

        /*

           "id": 6,
            "email": "tracey.ramos@reqres.in",
            "first_name": "Tracey",
            "last_name": "Ramos",
         */

        String url = "https://reqres.in/api/users";
        Response response = given().when().get(url);

        response.
                then().
                body("data[5].email",equalTo("tracey.ramos@reqres.in"),
                        "data[5].first_name",equalTo("Tracey"),
                        "data[5].last_name",equalTo("Ramos"));
    }
}
