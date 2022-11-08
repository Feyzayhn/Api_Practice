package day01;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class GetRequest01 {

    @Test
    public void test01(){

      String url = "https://restful-booker.herokuapp.com/booking";

      Response response = given().when().get(url);
      // given().when().get(url) --> end point'e gondermek icin request olusturmus olduk
      // Response response --> api tarafindan bana donen cevap

      // Response response = given().auth().basic("username","password").when().get(url);
      // basic authentication ile request gondermek icin

       //response.prettyPrint(); // response daki body i yazdirir

      //response.prettyPeek();  // response daki her seyi yazdirir

      // response.peek(); // tek satirda veriyor

       //response.print();
       // [{"bookingid":1215},{"bookingid":844},{"bookingid":87},{"bookingid":747}, ...]

        System.out.println(response.statusCode());
        System.out.println(response.statusLine());
        System.out.println(response.contentType());

        // 1) JUnit Assert'leri ile Apı testi yapabiliriz
        Assert.assertEquals("Status Kod Hatali",200, response.getStatusCode());
                                // yanlis oldugunda hata mesaji da verdirebiliyorum

        Assert.assertEquals("HTTP/1.1 200 OK",response.statusLine());
        Assert.assertEquals("application/json; charset=utf-8",response.contentType());


        // 2) assertThat ile
        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json; charset=utf-8").
                statusLine("HTTP/1.1 200 OK");

        // assertThat Hard Assert'tur INTERVIEW





    }

}


//mvn clean komutu target ı siler ve github da congfilig olusturmasini engeller
// ya da target dosyasini git ignore yapariz bu sekilde engelleriz