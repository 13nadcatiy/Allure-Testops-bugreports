package dev.pivozavr.bugreports.testops;

import dev.pivozavr.bugreports.testops.utils.DataProviderBuilder;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;

import static io.qameta.allure.Allure.step;

public class ExampleTestClass {

    @DataProvider
    public Iterator<Object[]> test1Provider() {
        return new DataProviderBuilder()
                .add("test1")
                .add("test2")
                .add("test3")
                .getIterator();
    }

    static int variationCount = 3;

    @Test(description = "Параметризированный тест", dataProvider = "test1Provider")
    public void exampleTest_1_v1(String arg) {
        if (variationCount != 0)
            variationCount--;
        step("Проверка", () -> {
            Assert.assertTrue(variationCount == 0, "Тест должен пройти  успешно только на 3й раз");
        });
    }
}