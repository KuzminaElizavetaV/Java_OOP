package Furniture;

/**
 * Класс enum Состояние (шкафа: открыт-закрыт)
 */
public enum Condition {
    OPENED("ОТКРЫТ"), CLOSED("ЗАКРЫТ");

    private final String translation;

    Condition(String translation) {
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }
}
