/**
 * Класс enum Приоритет
 */
public enum Priority {
    LOW("НИЗКИЙ"), MEDIUM("СРЕДНИЙ"), URGENT("СРОЧНЫЙ"), NOW("НЕМЕДЛЕННЫЙ");

    private final String translation;

    Priority(String translation) {
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }
}
