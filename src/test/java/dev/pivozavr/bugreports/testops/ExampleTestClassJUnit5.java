package dev.pivozavr.bugreports.testops;

import dev.pivozavr.bugreports.testops.utils.DataProviderBuilder;
import io.qameta.allure.Param;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;

class ExampleTestClassJUnit5 {

    public static Stream<Arguments> customDataProvider() {
        return new DataProviderBuilder()
                .add("login1", "pass1")
                .add("login2", "pass2")
                .add("login3", "pass3")
                .getStream();
    }

    public static Stream<Arguments> classicDataProvider() {
        return Stream.of(
                Arguments.of("user1", "pass1"),
                Arguments.of("user2", "pass2"),
                Arguments.of("user3", "pass3")
        );
    }

    static int variationCount = 3;

    /**
     * Добрый вечер, Павел
     *
     * У вас не правильно указана в коде параметризация, поэтому в тест кейсах параметры не передаются и прогон происходит ретраями.
     *
     * Прикладываю ссылку на инструкцию по параметризации:
     * https://github.com/allure-framework/allure-java/issues/822#issuecomment-1253438899
     *
     * С уважением
     * Яковлев В.
     */
    @Tag("voronin-test")
    @DisplayName("Параметризированный тест (заканчивается успешно только в последней итерации)")
    @ParameterizedTest(name = "{displayName} ({argumentsWithNames})")
    @MethodSource("classicDataProvider")
    public void exampleTest_1_v1(@Param("Логин") String param1,
                                 @Param("Пароль") String param2) throws InterruptedException {
        Thread.sleep(2000);
        variationCount--;
        step(String.format("Проверка с параметрами \"%s\" и \"%s\"", param1, param2), () -> {
            Assertions.assertEquals(0, variationCount,
                    "Тест должен пройти  успешно только на 3й раз. Сейчас прогон " + (3 - variationCount));
        });
    }
}