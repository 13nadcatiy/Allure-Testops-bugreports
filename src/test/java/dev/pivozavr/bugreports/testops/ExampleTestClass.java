package dev.pivozavr.bugreports.testops;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.step;

class ExampleTestClass {

    static int variationCount = 3;

    @Tag("voronin-test")
    @DisplayName("Параметризированный тест (заканчивается успешно только в последней итерации)")
    @ParameterizedTest(name = "{displayName} ({argumentsWithNames})")
    @ValueSource(strings = {"test1", "test2", "test3"})
    public void exampleTest_1_v1(String arg) {
        variationCount--;
        step("Проверка", () -> {
            Assertions.assertEquals(0, variationCount, "Тест должен пройти  успешно только на 3й раз");
        });
    }
}