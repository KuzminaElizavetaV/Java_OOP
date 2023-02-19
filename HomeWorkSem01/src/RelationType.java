/**
 * Класс enum "Тип родства"
 */
public enum RelationType {
    SON("Сын"), DAUGHTER("Дочь"), FATHER("Папа"),
    MOTHER("Мама"), SISTER("Сестра"), BROTHER("Брат"), GRANDMOTHER("Бабушка"),
    GRANDFATHER("Дедушка"), UNCLE("Дядя"), AUNT("Тетя"), NIECE("Племянница"),
    NEPHEW("Племянник"), SPOUSE("Супруг(а)"), GRANDSON("Внук"),
    GRANDDAUGHTER("Внучка");
    private final String translation;

    RelationType(String translation) {
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }
}