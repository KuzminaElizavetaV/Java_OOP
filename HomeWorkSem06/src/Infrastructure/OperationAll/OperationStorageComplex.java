package Infrastructure.OperationAll;

import java.util.Map;

/**
 * Класс Хранилище операций для компоненты калькулятора комплексных чисел, наследуется от класса OperationStorage
 */
public class OperationStorageComplex extends OperationStorage{

    public OperationStorageComplex() {
        super();
    }

    @Override
    public Map<Integer, String> getOperationMap() {
        return super.getOperationMap();
    }

    /**
     * Переопределение метода добавления операции в словарь родительского класса OperationStorage
     * @param key целое число по порядку
     * @param operation строка тип операции (для гибкости и удобства использую класс enum OperationType)
     */
    @Override
    public void addOperation(Integer key, String operation) {
        super.addOperation(key, operation);
    }

    /**
     * Переопределение метода создания на основе словаря консольного меню для пользователя всех имеющихся операций
     * для комплексных чисел
     * @return строку меню операций
     */
    @Override
    public String operationMenu() {
        StringBuilder operationMenu = new StringBuilder();
        operationMenu.append("******** ВВЕДИТЕ ЧИСЛО, СОГЛАСНО ПУНКТУ МЕНЮ ********\n");
        for (Map.Entry<Integer, String> el : getOperationMap().entrySet()) {
            operationMenu.append("    ").append(el.getKey()).append(" => ").append("ОПЕРАЦИЯ \"")
                    .append(el.getValue()).append("\" КОМПЛЕКСНЫХ ЧИСЕЛ\n");
        }
        return operationMenu.toString();
    }
}
