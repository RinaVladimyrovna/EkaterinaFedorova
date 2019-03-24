package hws.hw10;

import hws.hw10.entities.SpellerReceivedResponse;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ResponseAssertions {

    public static void assertErrorCodeIs(SpellerReceivedResponse response, int expectedResult) {
        assertThat(response.code, equalTo(expectedResult));
    }

    public static void assertProposedWordIs(SpellerReceivedResponse response, String expectedResult) {
        assertThat(response.s, hasItem(expectedResult));
    }

    public static void assertMisprintPositionIs(SpellerReceivedResponse response, int expectedResult) {
        assertThat(response.pos, equalTo(expectedResult));
    }

    public static void assertWordLength(SpellerReceivedResponse response, int expectedResult) {
        assertThat(response.len, equalTo(expectedResult));
    }

    public static void assertCorrectionsAmount(List<SpellerReceivedResponse> response, int expectedResult) {
        assertThat(response, hasSize(expectedResult));
    }

}
