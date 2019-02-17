Feature: Different Elements Page Test

  Scenario: Interface testing

    Given I open site
    Then The browser title should be 'MAIN_PAGE_TITLE'

    When I login as 'PITER'
    Then User's name should be 'PITER'
    And Interface should have all the necessary elements

    When I click on Service subcategory in the header
    Then Service dropdown menu in header displays following options
      | SUPPORT_PAGE_LINK  |
      | DATES_PAGE_LINK    |
      | COMPLEX_TABLE_PAGE_LINK      |
      | SIMPLE_TABLE_PAGE_LINK       |
      | USER_TABLE_PAGE_LINK         |
      | TABLE_WITH_PAGES_PAGE_LINK   |
      | DIFFERENT_ELEMENTS_PAGE_LINK |
      | PERFORMANCE_PAGE_LINK        |

    When I click on Service subcategory in the left section
    Then Service dropdown in left section displays following options
      | SUPPORT_PAGE_LINK  |
      | DATES_PAGE_LINK    |
      | COMPLEX_TABLE_PAGE_LINK      |
      | SIMPLE_TABLE_PAGE_LINK       |
      | USER_TABLE_PAGE_LINK         |
      | TABLE_WITH_PAGES_PAGE_LINK   |
      | DIFFERENT_ELEMENTS_PAGE_LINK |
      | PERFORMANCE_PAGE_LINK        |

    When I open header menu Service -> Different Elements Page
    Then Interface on Different elements page contains all needed elements
    And There is a Right section
    And There is a Left section

    When I select checkboxes:
      | WATER |
      | WIND  |
    Then For each checkbox there is a log row
      | WATER_TRUE_LOG |
      | WIND_TRUE_LOG  |

    When I select 'SELEN' radio button
    Then There is a log raw for 'SELEN_LOG' radio button

    When I select 'YELLOW' from the color selection dropdown
    Then There is a log raw for 'YELLOW_LOG' color dropdown

    When I unselect checkboxes:
      | WATER |
      | WIND  |
    Then Following boxes are unchecked:
      | WATER_FALSE_LOG |
      | WIND_FALSE_LOG  |