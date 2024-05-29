package dev.pivozavrus.bugreports.testops;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.step;

class ExampleTestClassJUnit5 {

    @Tag("voronin-test")
    @DisplayName("Параметризированный тест")
    @ParameterizedTest(name = "{displayName} ({argumentsWithNames})")
    @ValueSource(strings = {"test1", "test2", "test3"})
    public void exampleTest_1_v1(String arg) throws InterruptedException {
        Thread.sleep(2000);
        step("Шаг теста", () -> {
            //Происходит магия
        });
    }

    @Tag("voronin-test")
    @Test
    @DisplayName("Параметризированный тест")
    public void exampleTest_2_v1() throws InterruptedException {
        Thread.sleep(2000);
        step("Шаг теста", () -> {
            //Происходит магия
        });
    }


}