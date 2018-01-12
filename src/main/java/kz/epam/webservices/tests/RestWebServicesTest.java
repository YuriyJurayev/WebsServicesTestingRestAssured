package kz.epam.webservices.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import kz.epam.webservices.model.user.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static kz.epam.webservices.utils.ConsolePrinter.*;


public class RestWebServicesTest {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void verifyHTTPStatusCode() {
        int actualStatusCode = sendRequestAndReceiveResponse("/users").getStatusCode();
        printInteger(actualStatusCode);
        Assert.assertEquals(actualStatusCode, 200);
    }

    @Test
    public void verifyHTTPResponseHeader() {
        String ContentTypeHeaderValue = sendRequestAndReceiveResponse("/users").getHeader("content-type");
        printString(ContentTypeHeaderValue);
        Assert.assertTrue(ContentTypeHeaderValue.contains("application/json; charset=utf-8"));
    }

    @Test
    public void verifyHTTPResponseBody() {
        User[] users = sendRequestAndReceiveResponse("/users").as(User[].class);
        printUsersInfo(users);
        Assert.assertEquals(users.length, 10);
    }

    private Response sendRequestAndReceiveResponse(String resourceRoute){
        return RestAssured.given().get(resourceRoute).andReturn();
    }
}
