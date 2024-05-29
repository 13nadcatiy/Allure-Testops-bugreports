package dev.pivozavr.bugreports.testops;

import dev.pivozavr.bugreports.testops.utils.DataProviderBuilder;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;

import static io.qameta.allure.Allure.step;

public class ExampleTestClassTestNG {

    @DataProvider
    public Iterator<Object[]> test1Provider() {
        return new DataProviderBuilder()
                .add("test1")
                .add("test2")
                .add("test3")
                .getIterator();
    }

    static int variationCount = 3;

    @Test(description = "Параметризированный тест (заканчивается успешно только в последней итерации)", dataProvider = "test1Provider")
    public void exampleTest_1_v1(String arg) throws InterruptedException {
        Thread.sleep(2000);
        variationCount--;
        step("Проверка", () -> {
            Assert.assertTrue(variationCount == 0, "Тест должен пройти  успешно только на 3й раз");
        });
    }
}