package org.sadtech.social.core.utils;

/**
 * Класс утилита, содержащий сообщения об ошибках, и сообщения логирования.
 *
 * @author upagge [15/08/2019]
 */
public class ExceptionMessages {

    public final static String UTILITY_CLASS = "Класс утилита";

    private ExceptionMessages() {
        throw new IllegalStateException(UTILITY_CLASS);
    }
}
