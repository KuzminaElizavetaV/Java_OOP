package PresenterAll;

import Infrastructure.CalcRationalNumbers.RationalAdditionModel;
import Infrastructure.CalcRationalNumbers.RationalDivisionModel;
import Infrastructure.CalcRationalNumbers.RationalMultiplicationModel;
import Infrastructure.CalcRationalNumbers.RationalSubtractionModel;
import Infrastructure.OperationAll.OperationStorageRational;
import Infrastructure.OperationAll.OperationType;
import UserInterface.View;

/**
 * Класс управления связью между Model и View для работы с рациональными числами
 * наследуется от абстрактного класса PresenterCalc
 */
public class PresenterCalcRationalNumbers extends PresenterCalc {
    /**
     * конструктор компоненты управления связями с параметром
     * @param v экземпляр интерфейса пользователя
     */
    public PresenterCalcRationalNumbers(View v) {
        view = v;
    }

    /**
     * Метод устанавливает конкретный тип/подкласс модели расчета, с которой будет работать текущая компонента
     * управления связями - в зависимости от пользовательского выбора операции
     * @param number номер операции
     */
    @Override
    public void setModel(int number) {
        switch (number) {
            case 1 -> this.model = new RationalAdditionModel();
            case 2 -> this.model = new RationalSubtractionModel();
            case 3 -> this.model = new RationalMultiplicationModel();
            case 4 -> this.model = new RationalDivisionModel();
            default -> {
            }
        }
    }

    /**
     * Метод запуска текущей компоненты управления связями -
     * поведение, заданное интерфейсом I_Presenter, переопределяется в каждом дочернем классе
     */
    @Override
    public void buttonClick() {
        OperationStorageRational operations = new OperationStorageRational();
        operations.addOperation(1, OperationType.ADDITION.getTranslation());
        operations.addOperation(2, OperationType.SUBTRACTION.getTranslation());
        operations.addOperation(3, OperationType.MULTIPLICATION.getTranslation());
        operations.addOperation(4, OperationType.DIVISION.getTranslation());
        Double res = null;
        int operation;
        Double firstNum = view.getValue("ВВЕДИТЕ 1 ЧИСЛО: ");
        do {
            operation = view.getVariant(operations.operationMenu()); //меню выбора операций, которое создается методом
        } while (operation < 1 || operation > 4);                    //operationMenu() на основе HashMap operations
        Double secondNum = view.getValue("ВВЕДИТЕ 2 ЧИСЛО: ");
        //дальше вызвать setModel в зависимости от операции
        setModel(operation); //установили модель по типу операции
        model.setX(firstNum);
        model.setY(secondNum);
        try {
            res = (Double) model.result();}
        catch (Exception e){
            e.printStackTrace();
            myLog.log(e.getMessage());
        }
        if (res != null)
            view.viewData(String.format("%s", res), String.format("РЕЗУЛЬТАТ ОПЕРАЦИИ \"%s ЧИСЕЛ %s И %s\" =>",
                    operations.getOperationMap().get(operation), firstNum, secondNum));
        else
            view.viewData(String.format("%s", res), String.format("Некорректное выражение операции %s чисел %s и %s =>",
                    operations.getOperationMap().get(operation), firstNum, secondNum));
    }
}

