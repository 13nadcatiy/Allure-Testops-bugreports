package dev.pivozavr.bugreports.testops;

import dev.pivozavr.bugreports.testops.utils.DataProviderBuilder;
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

    @Test(description = "Параметризированный тест", dataProvider = "test1Provider")
    public void exampleTest_1_v1(String arg) {
        step("Шаг теста", () -> {
            //Происходит магия
        });
    }

    @Test(description = "Простой тест")
    public void exampleTest_2_v1() {
        step("Шаг теста", () -> {
            //Происходит магия
        });
    }


}