Feature: Different Elements Page Test

  Scenario: Interface testing

    Given I open the site
    Then Browser title should be 'MAIN_PAGE_TITLE'

    When I login as 'PITER'
    Then User's name should be 'PITER'
    And Interface should have all necessary elements

    When I expand Service drop-down in the header
    Then Service drop-down in the header contains the following options
      | SUPPORT_PAGE_LINK            |
      | DATES_PAGE_LINK              |
      | COMPLEX_TABLE_PAGE_LINK      |
      | SIMPLE_TABLE_PAGE_LINK       |
      | USER_TABLE_PAGE_LINK         |
      | TABLE_WITH_PAGES_PAGE_LINK   |
      | DIFFERENT_ELEMENTS_PAGE_LINK |
      | PERFORMANCE_PAGE_LINK        |

    When I click expand Service drop-down in the left section
    Then Service drop-down in the left section contains the following options
      | SUPPORT_PAGE_LINK            |
      | DATES_PAGE_LINK              |
      | COMPLEX_TABLE_PAGE_LINK      |
      | SIMPLE_TABLE_PAGE_LINK       |
      | USER_TABLE_PAGE_LINK         |
      | TABLE_WITH_PAGES_PAGE_LINK   |
      | DIFFERENT_ELEMENTS_PAGE_LINK |
      | PERFORMANCE_PAGE_LINK        |

    # TODO This step should be parametrised, so you have to create
    # TODO one single step that can be user in order to open any kind of pages
    # Done via ServiceListOptions ENUM
    When I follow DIFFERENT_ELEMENTS_PAGE_LINK via the header drop-down
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
    Then There is a log row for 'SELEN_LOG' radio button

    When I select 'YELLOW' from the colour selection drop-down
    Then There is a log row for 'YELLOW_LOG' colour drop-down

    When I deselect checkboxes:
      | WATER |
      | WIND  |
    Then The following checkboxes are unchecked:
      | WATER_FALSE_LOG |
      | WIND_FALSE_LOG  |