package Infrastructure.OperationAll;

/**
 * Перечисление типов операций
 */
public enum OperationType {
    ADDITION("СЛОЖЕНИЕ"), SUBTRACTION("ВЫЧИТАНИЕ"), MULTIPLICATION("УМНОЖЕНИЕ"),
    DIVISION("ДЕЛЕНИЕ");

    private final String translation;

    OperationType(String translation) {
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }
}
