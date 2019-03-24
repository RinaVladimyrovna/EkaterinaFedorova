package hws.hw10;

import hws.hw10.entities.SpellerReceivedResponse;
import org.testng.annotations.Test;

import java.util.List;

import static hws.hw10.ResponseAssertions.*;
import static hws.hw10.entities.MethodConstants.*;


public class YandexSpellerCheckTextsTests {

    @Test
    //1 - verify that CheckTexts is working correctly with one text argument
    public void checkSingleMistake() {

        String text = "cheesse";
        List<SpellerReceivedResponse> response = YandexSpellerCheckTextsApi.getSpellerAnswers(
                YandexSpellerCheckTextsApi.getParameterAccumulator()
                        .addTexts(TEXT, text)
                        .addStringParameter(LANGUAGE, "en")
                        .callApi());
        assertErrorCodeIs(response.get(0), 1);
        assertProposedWordIs(response.get(0), "cheese");

    }

    @Test
    //2 - verify that CheckTexts is working correctly with word duplication (error code = 2)
    public void checkDoubleMistake() {

        String text = "I love eating eating cheese";
        String text1 = "You should tell please always";
        List<SpellerReceivedResponse> response = YandexSpellerCheckTextsApi.getSpellerAnswers(
                YandexSpellerCheckTextsApi.getParameterAccumulator()
                        .addTexts(TEXT, text, text1)
                        .addStringParameter(LANGUAGE, "en")
                        .callApi());
        assertCorrectionsAmount(response, 1);
        assertErrorCodeIs(response.get(0), 2);


    }

    @Test
    //3 - verify that CheckTexts is working correctly with more then one text argument
    public void checkDuplications() {

        String text = "cheesse";
        String text1 = "pleaase";
        List<SpellerReceivedResponse> response = YandexSpellerCheckTextsApi.getSpellerAnswers(
                YandexSpellerCheckTextsApi.getParameterAccumulator()
                        .addTexts(TEXT, text, text1)
                        .addStringParameter(LANGUAGE, "en")
                        .callApi());
        assertErrorCodeIs(response.get(0), 1);
        assertProposedWordIs(response.get(0), "cheese");
        assertErrorCodeIs(response.get(1), 1);
        assertProposedWordIs(response.get(1), "please");

    }

    @Test
    //4 - verify that CheckTexts is working correctly with incorrect capitalisation
    public void checkCapitalisationMistake() {

        String text = "I live in london";
        String text1 = "Do you mean LonDon?";
        String text2 = "No. London.";
        List<SpellerReceivedResponse> response = YandexSpellerCheckTextsApi.getSpellerAnswers(
                YandexSpellerCheckTextsApi.getParameterAccumulator()
                        .addTexts(TEXT, text, text1, text2)
                        .addStringParameter(LANGUAGE, "en")
                        .callApi());
        assertCorrectionsAmount(response, 2);
        assertErrorCodeIs(response.get(0), 3);
        assertProposedWordIs(response.get(0), "London");
        assertErrorCodeIs(response.get(1), 3);
        assertProposedWordIs(response.get(1), "London");

    }

    @Test
    //5 - verify that CheckTexts can ignore incorrect capitalisation
    public void checkCapitalisationMistakesIgnored() {

        String text = "I live in london";
        String text1 = "Do you mean LonDon?";
        String text2 = "No. London.";
        List<SpellerReceivedResponse> response = YandexSpellerCheckTextsApi.getSpellerAnswers(
                YandexSpellerCheckTextsApi.getParameterAccumulator()
                        .addTexts(TEXT, text, text1, text2)
                        .addStringParameter(LANGUAGE, "en")
                        .addStringParameter(OPTIONS, "512")
                        .callApi());
        assertCorrectionsAmount(response, 0);

    }

    @Test
    //6 - verify that CheckTexts can ignore digits in words
    public void checkDigitsMistakesIgnored() {

        String text = "I live in L0nd0n.";
        String text1 = "Do you mean Lon6on?";
        String text2 = "No. London.";
        List<SpellerReceivedResponse> response = YandexSpellerCheckTextsApi.getSpellerAnswers(
                YandexSpellerCheckTextsApi.getParameterAccumulator()
                        .addTexts(TEXT, text, text1, text2)
                        .addStringParameter(LANGUAGE, "en")
                        .addStringParameter(OPTIONS, "2")
                        .callApi());
        assertCorrectionsAmount(response, 0);

    }

    @Test
    //7 - verify that CheckTexts can ignore URLs
    public void checkUrlsAreEvoided() {

        String text = "Have you heard about https://tech.yandex.ru/speller/doc/dg/reference/speller-options-docpage/?";
        List<SpellerReceivedResponse> response = YandexSpellerCheckTextsApi.getSpellerAnswers(
                YandexSpellerCheckTextsApi.getParameterAccumulator()
                        .addTexts(TEXT, text)
                        .addStringParameter(LANGUAGE, "en")
                        .addStringParameter(OPTIONS, "4")
                        .callApi());
        assertCorrectionsAmount(response, 0);

    }

    @Test
    //8 - verify that CheckTexts can ignore e-mails
    public void checkEmailsAreEvoided() {

        String text = "Please, send it to mozilla@rambler.com";
        List<SpellerReceivedResponse> response = YandexSpellerCheckTextsApi.getSpellerAnswers(
                YandexSpellerCheckTextsApi.getParameterAccumulator()
                        .addTexts(TEXT, text)
                        .addStringParameter(LANGUAGE, "en")
                        .addStringParameter(OPTIONS, "4")
                        .callApi());
        assertCorrectionsAmount(response, 0);

    }

    @Test
    //9 - verify that CheckTexts can ignore file names
    public void checkFileNamesAreEvoided() {

        String text = "I cannot find Response.xml or response.xlsx.";
        List<SpellerReceivedResponse> response = YandexSpellerCheckTextsApi.getSpellerAnswers(
                YandexSpellerCheckTextsApi.getParameterAccumulator()
                        .addTexts(TEXT, text)
                        .addStringParameter(LANGUAGE, "en")
                        .addStringParameter(OPTIONS, "4")
                        .callApi());
        assertCorrectionsAmount(response, 0);

    }

    @Test
    //10 - verify that CheckTexts can correct mistakes in Ukraine
    public void checkUkraineMistakes() {

        String text = "Я погано знаю украiнську мову";
        List<SpellerReceivedResponse> response = YandexSpellerCheckTextsApi.getSpellerAnswers(
                YandexSpellerCheckTextsApi.getParameterAccumulator()
                        .addTexts(TEXT, text)
                        .addStringParameter(LANGUAGE, "uk")
                        .callApi());
        assertCorrectionsAmount(response, 1);
        assertErrorCodeIs(response.get(0), 1);
        assertProposedWordIs(response.get(0), "українську");

    }

}
