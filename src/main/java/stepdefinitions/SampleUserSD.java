package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class SampleUserSD {
    RequestSpecification request;
    Response response;
    String myResponse;
    RequestSpecification reqSpec;

    @Given("create user payload is created")
    public void create_user_payload_is_created() {

         request = given().log().all().spec(reqSpec).body("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}");

    }
    @When("user calls AddUser request using POST Method")
    public void user_calls_add_user_request_using_post_method() {

         response = request.when().post("/api/users");

    }
    @Then("API call should get success with status code {string}")
    public void api_call_should_get_success_with_status_code(String statusCode) {

        ResponseSpecification respSpec = new ResponseSpecBuilder().expectStatusCode(Integer.parseInt(statusCode)).build();

         myResponse = response.then().log().all().spec(respSpec).extract().asString();
        System.out.println(myResponse);
    }

    @And("{string} should be {string}")
    public void shouldBe(String jPath, String expectedValue) {

        JsonPath jsonPath = new JsonPath(myResponse);
        String actual = jsonPath.getString(jPath);

        Assert.assertEquals("incorrect value",expectedValue,actual);
    }

    @Given("update user payload is created")
    public void updateUserPayloadIsCreated() {
        RequestSpecification reqSpec = new RequestSpecBuilder().setBaseUri("https://reqres.in")
                .addHeader("Content-Type", "application/json")
                .build();

        request = given().log().all().spec(reqSpec).body("{\n" +
                "    \"name\": \"amol\",\n" +
                "    \"job\": \"tester\"\n" +
                "}");
    }

    @When("user calls updateUSer request using PUT Method")
    public void userCallsUpdateUSerRequestUsingPUTMethod() {

        response = request.when().put("/api/users/2");
    }

    @Given("Spec builder Object is created")
    public void specBuilderObjectIsCreated() {
         reqSpec = new RequestSpecBuilder().setBaseUri("https://reqres.in")
                .addHeader("Content-Type", "application/json")
                .build();
    }

    @Given("delete user payload is created")
    public void deleteUserPayloadIsCreated() {
        request = given().log().all().spec(reqSpec);
    }

    @When("user calls deleteUser request using Delete Method")
    public void userCallsDeleteUserRequestUsingDeleteMethod() {
        response = request.when().delete("/api/users/2");
    }

    @Given("get single user payload is created")
    public void getSingleUserPayloadIsCreated() {

        request = given().log().all().spec(reqSpec);
    }

    @When("user calls getSingleUser request using GET Method")
    public void userCallsGetSingleUserRequestUsingGETMethod() {
        response = request.when().get("/api/users/2");
    }

    @Given("get All user payload is created")
    public void getAllUserPayloadIsCreated() {

        request =  given().log().all().spec(reqSpec).queryParam("page","2");
    }

    @When("user calls getAllUser request using GET Method")
    public void userCallsGetAllUserRequestUsingGETMethod() {

        response = request.when().get("/api/users");
    }

    @And("{string} count should be {string}")
    public void countShouldBe(String jPath, String expectedValue) {

        JsonPath jsonPath = new JsonPath(myResponse);
        int actual = jsonPath.getInt(jPath+".size()");

        Assert.assertEquals("incorrect value",Integer.parseInt(expectedValue),actual);
    }
}
