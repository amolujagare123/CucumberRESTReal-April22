Feature: all Sample rest request reqres.in

  Background: creating spec builder object
    Given Spec builder Object is created

  @createUserSampleRequest   @switchCase
  Scenario: verify create user request
    Given create user payload is created
   # When user calls AddUser request using POST Method
    When user calls "AddUser" request using "POST" Method
    Then API call should get success with status code "201"
    And  "name" should be "Roshan"
    And  "job" should be "Test Lead"
    #And  name should be "Roshan"

  @updateUserSampleRequest @switchCase
  Scenario: verify update user request
    Given update user payload is created
    #When user calls updateUSer request using PUT Method
    When user calls "UpdateUser" request using "PUT" Method
    Then API call should get success with status code "200"
    And  "name" should be "amol"
    And  "job" should be "tester"

  @deleteUserSampleRequest @switchCase
  Scenario: verify delete user request
    Given delete user payload is created
    #When user calls deleteUser request using Delete Method
    When user calls "DeleteUser" request using "DELETE" Method
    Then API call should get success with status code "204"
   #And  "" should be ""

  @getSingleUserSampleRequest @switchCase
  Scenario: verify get single user request
    Given get single user payload is created
    #When user calls getSingleUser request using GET Method
    When user calls "getSingleUser" request using "GET" Method
    Then API call should get success with status code "200"
    And  "support.url" should be "https://reqres.in/#support-heading"


  @getAllUsersSampleRequest
  Scenario: verify get single user request
    Given get All user payload is created
    #When user calls getAllUser request using GET Method
    When user calls "listUsers" request using "GET" Method
    Then API call should get success with status code "200"
    And  "total" should be "12"
    And  "data" count should be "6"


  @createUserSampleRequestPar
  Scenario: verify create user request
    Given create user payload is created with name as "Anil" and job as "HR"
    When user calls "AddUser" request using "POST" Method
    Then API call should get success with status code "201"
    #And  "name" should be "morpheus"
    #And  "job" should be "leader"
    #And  name should be "Anil"


  @createUserSampleRequestPar2
  Scenario Outline: verify create user request
    Given create user payload is created <name> and <job>
    #When user calls AddUser request using POST Method
    When user calls "AddUser" request using "POST" Method
    Then API call should get success with status code "201"
    #And  "name" should be "morpheus"
    #And  "job" should be "leader"
    And user name should be <name>
    Examples:
      | name    | job     |
      | Amol    | Trainer |
      | Rahul   | Owner   |
      | Rohit   | Business Analyst |
      | vaibhav | HR    |



