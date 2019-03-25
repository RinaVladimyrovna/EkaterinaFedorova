package hws.hw10;

import static hws.hw10.entities.MethodConstants.ENV_URL;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hws.hw10.entities.ApplicableOptionValues;
import hws.hw10.entities.MethodConstants;
import hws.hw10.entities.SpellerReceivedResponse;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class YandexSpellerCheckTextsApi {

    private YandexSpellerCheckTextsApi() {
    }

    //todo у тебя в константах уже есть такая переменная
    //можешь тут оставить /services/spellservice.json/checkTexts.энв - вынести в константы
    public static final String YANDEX_SPELLER_API_URL = ENV_URL.toString() + "services/spellservice.json/checkTexts";

    private HashMap<String, List<String>> parameters = new HashMap<>();

    public static class ParametersBuilder {
        YandexSpellerCheckTextsApi builder;

        private ParametersBuilder(YandexSpellerCheckTextsApi api) {
            builder = api;
        }

        public ParametersBuilder addStringParameter(MethodConstants paramName, ApplicableOptionValues params) {
            System.out.println(paramName.toString());
            builder.parameters.put(paramName.toString(), new ArrayList<String>(Arrays.asList(params.toString())));
            return this;
        }

        public ParametersBuilder addTexts(MethodConstants paramName, String... params) {
            builder.parameters.put(paramName.toString(), new ArrayList<String>(Arrays.asList(params)));
            return this;
        }

        public Response callApi() {
            return RestAssured.given(baseRequestConfiguration())
                    .queryParams(builder.parameters)
                    .log().all()
                    .get(YANDEX_SPELLER_API_URL).prettyPeek();
        }
    }

    public static ParametersBuilder getParameterAccumulator() {
        YandexSpellerCheckTextsApi api = new YandexSpellerCheckTextsApi();
        return new ParametersBuilder(api);
    }

    public static List<SpellerReceivedResponse> getSpellerAnswers(Response response) {
        List<List<SpellerReceivedResponse>> listOfLists = new Gson().fromJson(response.asString().trim(),
                new TypeToken<List<List<SpellerReceivedResponse>>>() {
                }.getType());
        List<SpellerReceivedResponse> result = new ArrayList<>();
        listOfLists.forEach(result::addAll);
        return result;
    }

    //todo убери неиспользуемые методы.

    public static RequestSpecification baseRequestConfiguration() {
        return new RequestSpecBuilder()
                .setAccept(ContentType.XML)
                .setRelaxedHTTPSValidation()
                .setBaseUri(YANDEX_SPELLER_API_URL)
                .build();
    }

}
