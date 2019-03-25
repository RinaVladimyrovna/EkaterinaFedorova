package hws.hw10;

import static hws.hw10.ResponseAssertions.assertCorrectionsAmount;
import static hws.hw10.ResponseAssertions.assertErrorCodeIs;
import static hws.hw10.ResponseAssertions.assertProposedWordIs;
import static hws.hw10.entities.ApplicableOptionValues.*;
import static hws.hw10.entities.MethodConstants.LANGUAGE;
import static hws.hw10.entities.MethodConstants.OPTIONS;
import static hws.hw10.entities.MethodConstants.TEXT;

import hws.hw10.entities.SpellerReceivedResponse;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;


public class YandexSpellerCheckTextsTests {

    @DataProvider
    private Object[][] verificationTextsProvider() {
        return new Object[][]{
                {"Check URLs ignoring", "Have you heard about https://tech.yandex.ru/speller/doc/dg/reference/speller-options-docpage/?"},
                {"Check e-mails ignoring", "Please, send it to mozilla@rambler.com"},
                {"Check file names ignoring", "I cannot find Response.xml or response.xlsx."}
        };
    }

    @Test(description = "1 - verify that CheckTexts is working correctly with one text argument")
    //todo можно не коменты писать, а description в аннотации Test
    public void checkSingleMistake() {

        String text = "cheesse";
        List<SpellerReceivedResponse> response = YandexSpellerCheckTextsApi.getSpellerAnswers(
                YandexSpellerCheckTextsApi.getParameterAccumulator()
                        .addTexts(TEXT, text)
                        .addStringParameter(LANGUAGE, ENGLISH)//todo en  - можно вынести в enum
                        .callApi());
        assertErrorCodeIs(response.get(0), 1);
        assertProposedWordIs(response.get(0), "cheese");

    }

    @Test(description = "2 - verify that CheckTexts is working correctly with word duplication (error code = 2)")
    public void checkDoubleMistake() {

        String text = "I love eating eating cheese";
        String text1 = "You should tell please always";
        List<SpellerReceivedResponse> response = YandexSpellerCheckTextsApi.getSpellerAnswers(
                YandexSpellerCheckTextsApi.getParameterAccumulator()
                        .addTexts(TEXT, text, text1)
                        .addStringParameter(LANGUAGE, ENGLISH)
                        .callApi());
        assertCorrectionsAmount(response, 1);
        assertErrorCodeIs(response.get(0), 2);


    }

    @Test(description = "3 - verify that CheckTexts is working correctly with more then one text argument")
    public void checkDuplications() {

        String text = "cheesse";
        String text1 = "pleaase";
        List<SpellerReceivedResponse> response = YandexSpellerCheckTextsApi.getSpellerAnswers(
                YandexSpellerCheckTextsApi.getParameterAccumulator()
                        .addTexts(TEXT, text, text1)
                        .addStringParameter(LANGUAGE, ENGLISH)
                        .callApi());
        assertErrorCodeIs(response.get(0), 1);
        assertProposedWordIs(response.get(0), "cheese");
        assertErrorCodeIs(response.get(1), 1);
        assertProposedWordIs(response.get(1), "please");

    }

    @Test(description = "4 - verify that CheckTexts is working correctly with incorrect capitalisation")
    public void checkCapitalisationMistake() {

        String text = "I live in london";
        String text1 = "Do you mean LonDon?";
        String text2 = "No. London.";
        List<SpellerReceivedResponse> response = YandexSpellerCheckTextsApi.getSpellerAnswers(
                YandexSpellerCheckTextsApi.getParameterAccumulator()
                        .addTexts(TEXT, text, text1, text2)
                        .addStringParameter(LANGUAGE, ENGLISH)
                        .callApi());
        assertCorrectionsAmount(response, 2);
        assertErrorCodeIs(response.get(0), 3);
        assertProposedWordIs(response.get(0), "London");
        assertErrorCodeIs(response.get(1), 3);
        assertProposedWordIs(response.get(1), "London");

    }

    @Test(description = "5 - verify that CheckTexts can ignore incorrect capitalisation")
    public void checkCapitalisationMistakesIgnored() {

        String text = "I live in london";
        String text1 = "Do you mean LonDon?";
        String text2 = "No. London.";
        List<SpellerReceivedResponse> response = YandexSpellerCheckTextsApi.getSpellerAnswers(
                YandexSpellerCheckTextsApi.getParameterAccumulator()
                        .addTexts(TEXT, text, text1, text2)
                        .addStringParameter(LANGUAGE, ENGLISH)
                        .addStringParameter(OPTIONS, IGNORE_CAPITALIZATION)
                        .callApi());
        assertCorrectionsAmount(response, 0);

    }

    @Test(description = "6 - verify that CheckTexts can ignore digits in words")
    public void checkDigitsMistakesIgnored() {

        String text = "I live in L0nd0n.";
        String text1 = "Do you mean Lon6on?";
        String text2 = "No. London.";
        List<SpellerReceivedResponse> response = YandexSpellerCheckTextsApi.getSpellerAnswers(
                YandexSpellerCheckTextsApi.getParameterAccumulator()
                        .addTexts(TEXT, text, text1, text2)
                        .addStringParameter(LANGUAGE, ENGLISH)
                        .addStringParameter(OPTIONS, IGNORE_DIGITS)
                        .callApi());
        assertCorrectionsAmount(response, 0);

    }

    //todo 7/8/9 тесты можно объедить с помощью @dataprovider
    //testCheck is not used anywhere but test case name part in idea for now. But in the future it can be used
    //in logs or somewhere else
    @Test(description = "7-9 - verify that CheckTexts can ignore URLs, e-mails and file names respectively",
            dataProvider = "verificationTextsProvider")
    public void checkUrlsAreEvoided(String testCheck, String testText) {

        List<SpellerReceivedResponse> response = YandexSpellerCheckTextsApi.getSpellerAnswers(
                YandexSpellerCheckTextsApi.getParameterAccumulator()
                        .addTexts(TEXT, testText)
                        .addStringParameter(LANGUAGE, ENGLISH)
                        .addStringParameter(OPTIONS, IGNORE_URLS)
                        .callApi());
        assertCorrectionsAmount(response, 0);

    }

    @Test(description = "10 - verify that CheckTexts can correct mistakes in Ukraine")
    public void checkUkraineMistakes() {

        String text = "Я погано знаю украiнську мову";
        List<SpellerReceivedResponse> response = YandexSpellerCheckTextsApi.getSpellerAnswers(
                YandexSpellerCheckTextsApi.getParameterAccumulator()
                        .addTexts(TEXT, text)
                        .addStringParameter(LANGUAGE, UKRAINIAN)
                        .callApi());
        assertCorrectionsAmount(response, 1);
        assertErrorCodeIs(response.get(0), 1);
        assertProposedWordIs(response.get(0), "українську");

    }

}
