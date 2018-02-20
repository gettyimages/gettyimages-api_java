Feature: User Products
    As a developer using the Getty Images
    I want to be able to get a list of a user's products
    So I can display them in my application

Scenario: Retrieve a user's products list using their credentials
	Given I have an apikey
	And an apisecret
	And a username
	And a password
	When I retrieve products
	Then I receive a successful response
	And the response contains the user's product list

    Scenario: Retrieve products without specifying user credentials
    Given I have an apikey
	And an apisecret
	When I retrieve products
    Then I receive a successful response
    And the products list is empty

Scenario: Specify fields in product request
	Given I have an apikey
	And an apisecret
	And a username
	And a password
	And I specify product field download_requirements
	When I retrieve products
	Then I receive a successful response
	And the response contains the user's product list
	And the response contains download_requirements
