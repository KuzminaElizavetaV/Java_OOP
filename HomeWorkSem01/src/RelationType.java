/**
 * Класс enum "Тип родства"
 */
public enum RelationType {
    Son("Сын"), Daughter("Дочь"), Father("Папа"),
    Mother("Мама"), Sister("Сестра"), Brother("Брат"), GrandMother("Бабушка"),
    GrandFather("Дедушка"), Uncle("Дядя"), Aunt("Тетя"), Niece("Племянница"),
    Nephew("Племянник"), Spouse("Супруг(а)"), Grandson("Внук"),
    Granddaughter("Внучка");
    private final String translation;

    RelationType(String translation) {
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }
}