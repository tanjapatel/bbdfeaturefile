@smoke
Feature: category

  Scenario Outline: user should be able to navigate all category from top header on home page
  successful
    Given user is on home page
    When user clicks all "<category_name>"on top header menu
    Then page breadcrumbs display "<category_url>"on home page
    Examples:
      | category_name     | category_url                                   |
      | Computers         | https://demo.nopcommerce.com/computers         |
      | Electronics       | https://demo.nopcommerce.com/electronics       |
      | Apparel           | https://demo.nopcommerce.com/apparel           |
      | Digital downloads | https://demo.nopcommerce.com/digital-downloads |
      | Books             | https://demo.nopcommerce.com/books             |
      | Jewelry           | https://demo.nopcommerce.com/jewelry           |
      | Gift Cards        | https://demo.nopcommerce.com/gift-cards        |
