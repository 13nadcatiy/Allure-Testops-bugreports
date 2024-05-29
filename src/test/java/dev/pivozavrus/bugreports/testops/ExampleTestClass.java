package dev.pivozavrus.bugreports.testops;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.step;

class ExampleTestClass {

    static int tryCount = 0;

    @Tag("voronin-test")
    @DisplayName("Параметризированный тест (заканчивается успешно только в последней итерации)")
    @ParameterizedTest(name = "{displayName} ({argumentsWithNames})")
    @ValueSource(strings = {"test1", "test2", "test3"})
    public void exampleTest_1_v1(String arg) {
        tryCount++;

        step("Проверка", () -> {
            Assertions.assertEquals(3, tryCount, "Тест пройдет успешно только в последней итерации");
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