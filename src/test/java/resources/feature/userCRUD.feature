Feature: Best Buy Application

  As a user I want to test Best Buy Application

  Scenario Outline: Product Api CRUD Test
    Given Best buy application is running
    When I create a new product by providing the information name "<name>" type "<type>" price "<price>" shipping "<shipping>" upc "<upc>" description "<description>" manufacturer "<manufacturer>" model "<model>" url "<url>" image "<image>"
    Then I verify that the product with name "<name>" is created
    And I update product by providing the information name "<name>" type "<type>" price "<price>" shipping "<shipping>" upc "<upc>" description "<description>" manufacturer "<manufacturer>" model "<model>" url "<url>" image "<image>"
    And The product with name "<name>" is updated successfully
    And I delete the product that created with name "<name>"
    Then The product deleted successfully from the application
    Examples:
      | name                        | type     | price | shipping | upc       | description                                   | manufacturer | model     | url                         | image                                           |
      | Duracell-Batteries(12-Pack) | HarGood  | 100   | 5        | 987654321 | Compatible with any devices                   | CanCompany   | MN2727B4z | http://www.google.com/image | http://dummyimage.com/128x100.png/ff4444/ffffff |
      | Duracell-Batteries          | SoftGood | 200   | 4        | 988547869 | Not compatible with select electronic devices | BangCompany  | MN2525B4z | http://www.yahoo.com/image  | http://dummyimage.com/214x100.png/5fa2dd/ffffff |

  Scenario Outline: Store Api CRUD Test
    Given Best buy application is running
    When I create a new store by providing the information name "<name>" type "<type>" address "<address>" addresstwo "<address2>" city "<city>" state "<state>" zip "<zip>" lat "<lat>" lng "<lng>" hours "<hours>"
    Then I verify that the store with name "<name>" is created
    And I update store by providing the information name "<name>" type "<type>" address "<address>" addresstwo "<address2>" city "<city>" state "<state>" zip "<zip>" lat "<lat>" lng "<lng>" hours "<hours>"
    And The store with name "<name>" is updated successfully
    And I delete the store that created with name "<name>"
    Then The store deleted successfully from the application
    Examples:
      | name | type      | address       | address2 | city   | state          | zip     | lat | lng | hours   |
      | Jhon | WareHouse | 1 London Road | CV 40    | London | Greater London | LL11LL  | 45  | 90  | Mon8to8 |
      | Wick | Store     | 1 Trent Road  | CV 30    | Trent  | Stoke          | SK1 1SK | 90  | 45  | Mon8to8 |




