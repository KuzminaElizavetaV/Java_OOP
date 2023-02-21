package Furniture;

public enum Condition {
    OPENED("Открыто"), CLOSED("Закрыто");

    private final String translation;

    Condition(String translation) {
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }
}
