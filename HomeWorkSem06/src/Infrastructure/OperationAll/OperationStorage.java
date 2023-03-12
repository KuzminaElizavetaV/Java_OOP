package Infrastructure.OperationAll;

import java.util.HashMap;
import java.util.Map;

/**
 * Абстрактный класс Хранилище операций (создание словаря операций и вывода меню на основе данных словаря).
 */
public abstract class OperationStorage {
    private final Map<Integer, String> operationMap = new HashMap<>();

    public OperationStorage() {
    }

    public Map<Integer, String> getOperationMap() {
        return operationMap;
    }

    /**
     * Метод добавления операции в словарь
     * @param key целое число по порядку
     * @param operation строка тип операции (для гибкости и удобства использую класс enum OperationType)
     */
    public void addOperation(Integer key, String operation){
        operationMap.put(key, operation);
    }

    /**
     * Метод создает на основе словаря консольное меню для пользователя всех имеющихся операций
     * @return строку меню операций
     */
    public String operationMenu(){
        StringBuilder operationMenu = new StringBuilder();
        operationMenu.append("***** ВВЕДИТЕ ЧИСЛО, СОГЛАСНО ПУНКТУ МЕНЮ *****\n");
        for (Map.Entry<Integer, String> el : this.operationMap.entrySet()) {
            operationMenu.append("    ").append(el.getKey()).append(" => ").append("ОПЕРАЦИЯ \"")
                    .append(el.getValue()).append("\"\n");
        }
        return operationMenu.toString();
    }
}
