package dev.pivozavrus.bugreports.testops;

import io.qameta.allure.AllureId;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.step;

class ExampleTestClass {

    @Tag("voronin-test")
    @DisplayName("Параметризированный тест")
    @ParameterizedTest(name = "{displayName} ({argumentsWithNames})")
    @ValueSource(strings = {"test1", "test2", "test3"})
    public void exampleTest_1_v1(String arg) {
        step("Шаг теста", () -> {
            //Происходит магия
        });
    }

    @Tag("voronin-test")
    @Test
    @DisplayName("Параметризированный тест")
    public void exampleTest_2_v1() {
        step("Шаг теста", () -> {
            //Происходит магия
        });
    }


}