Feature: all Sample rest request reqres.in

  Background: creating spec builder object
    Given Spec builder Object is created

  @createUserSampleRequest
  Scenario: verify create user request
    Given create user payload is created
    When user calls AddUser request using POST Method
    Then API call should get success with status code "201"
    And  "name" should be "morpheus"
    And  "job" should be "leader"

  @updateUserSampleRequest
  Scenario: verify update user request
    Given update user payload is created
    When user calls updateUSer request using PUT Method
    Then API call should get success with status code "200"
    And  "name" should be "amol"
    And  "job" should be "tester"

  @deleteUserSampleRequest
  Scenario: verify delete user request
    Given delete user payload is created
    When user calls deleteUser request using Delete Method
    Then API call should get success with status code "204"
   #And  "" should be ""

  @getSingleUserSampleRequest
  Scenario: verify get single user request
    Given get single user payload is created
    When user calls getSingleUser request using GET Method
    Then API call should get success with status code "200"
    And  "support.url" should be "https://reqres.in/#support-heading"

  @getAllUsersSampleRequest
  Scenario: verify get single user request
    Given get All user payload is created
    When user calls getAllUser request using GET Method
    Then API call should get success with status code "200"
    And  "total" should be "12"
    And  "data" count should be "6"

