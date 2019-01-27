package Lesson_2;

import Base.SeleniumBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SimpleTestWithDataProviders extends SeleniumBase {

    @DataProvider
    private Object[][] simpleDataProvider() {
        return new Object[][] {
                {0, "Ivan"},
                {1, "Roman"},
                {2, "Dima"}
        };
    }

    @Test(dataProvider = "simpleDataProvider")
    public void simpleTest (int i, String s) {
        System.out.println("int = " + i + "\n" + "String = " + s);
    }
}
