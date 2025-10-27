package racingcar.util;

public final class ValidationUtils {

    private ValidationUtils() {
    }

    public static int validateAndParseInt(String value, String message) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateNotBlank(String value, String message) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }
}
