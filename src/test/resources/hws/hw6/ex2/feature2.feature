Feature: Use Table Test

  # TODO It will be better to reuse steps from previous scenario instead of create new one
  # Done. Supposed that scenario should be left intact at maximum
  Scenario: User Table Page test
    Given I open the site
    And I login as 'PITER'
    When I follow USER_TABLE_PAGE_LINK via the header drop-down
    Then 'User Table' page is opened
    And 6 NumberType Dropdowns are displayed on Users Table on User Table Page
    And 6 User names are displayed on Users Table on User Table Page
    And 6 Description images are displayed on Users Table on User Table Page
    And 6 Description texts under images are displayed on Users Table on User Table Page
    And 6 checkboxes are displayed on Users Table on User Table Page
    And User table contains following values:
      | Number | User             | Description                      |
      | 1      | Roman            | Wolverine                        |
      | 2      | Sergey Ivan      | Spider Man                       |
      | 3      | Vladzimir        | Punisher                         |
      | 4      | Helen Bennett    | Captain America some description |
      | 5      | Yoshi Tannamuri  | Cyclope some description         |
      | 6      | Giovanni Rovelli | Hulk some description            |


    When I select 'vip' checkbox for "Sergey Ivan"
    Then 1 log row has "Vip: condition changed to true" text in log section

    When I click on dropdown in column Type for user Roman
    Then Roman droplist contains values
      | Admin   |
      | User    |
      | Manager |