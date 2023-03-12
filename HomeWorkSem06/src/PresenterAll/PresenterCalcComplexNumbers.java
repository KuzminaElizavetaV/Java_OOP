package PresenterAll;

import Infrastructure.CalcComplexNumbers.ComplexAdditionModel;
import Infrastructure.CalcComplexNumbers.ComplexDivisionModel;
import Infrastructure.CalcComplexNumbers.ComplexMultiplicationModel;
import Infrastructure.CalcComplexNumbers.ComplexSubtractionModel;
import Infrastructure.ComplexNumber;
import Infrastructure.OperationAll.OperationStorageComplex;
import Infrastructure.OperationAll.OperationType;
import UserInterface.View;

/**
 * Класс управления связью между Model и View для работы с комплексными числами
 * наследуется от абстрактного класса PresenterCalc
 */
public class PresenterCalcComplexNumbers extends PresenterCalc {
    /**
     * конструктор компоненты управления связями с параметром
     * @param v экземпляр интерфейса пользователя
     */
    public PresenterCalcComplexNumbers(View v) {
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
            case 1 -> this.model = new ComplexAdditionModel();
            case 2 -> this.model = new ComplexSubtractionModel();
            case 3 -> this.model = new ComplexMultiplicationModel();
            case 4 -> this.model = new ComplexDivisionModel();
        }
    }

    /**
     * Метод запуска текущей компоненты управления связями -
     * поведение, заданное интерфейсом I_Presenter, переопределяется в каждом дочернем классе
     */
    @Override
    public void buttonClick() {
        OperationStorageComplex operations = new OperationStorageComplex();
        operations.addOperation(1, OperationType.ADDITION.getTranslation());
        operations.addOperation(2, OperationType.SUBTRACTION.getTranslation());
        operations.addOperation(3, OperationType.MULTIPLICATION.getTranslation());
        operations.addOperation(4, OperationType.DIVISION.getTranslation());
        ComplexNumber res = null;
        int operation;
        ComplexNumber firstNum = new ComplexNumber(view.getValue("ВВЕДИТЕ ВЕЩЕСТВЕННУЮ ЧАСТЬ 1 КОМПЛЕКСНОГО ЧИСЛА:"),
                view.getValue("ВВЕДИТЕ МНИМУЮ ЧАСТЬ 1 КОМПЛЕКСНОГО ЧИСЛА: "));
        do {
            operation = view.getVariant(operations.operationMenu()); //меню выбора операций
        } while (operation < 1 || operation > 4);
        ComplexNumber secondNum = new ComplexNumber(view.getValue("ВВЕДИТЕ ВЕЩЕСТВЕННУЮ ЧАСТЬ 2 КОМПЛЕКСНОГО ЧИСЛА:"),
                view.getValue("ВВЕДИТЕ МНИМУЮ ЧАСТЬ 2 КОМПЛЕКСНОГО ЧИСЛА: "));
        this.setModel(operation); //установили модель по типу операции
        //передали значения чисел в модель
        model.setX(firstNum);
        model.setY(secondNum);
        try {
            res = (ComplexNumber) model.result();
        } catch (Exception e){
            e.printStackTrace();
            myLog.log(e.getMessage());
        }
        if (res != null)
            view.viewData(String.format("%s", res), String.format("РЕЗУЛЬТАТ ОПЕРАЦИИ \"%s ЧИСЕЛ %s И %s\" =>",
                    operations.getOperationMap().get(operation), firstNum, secondNum));
    }
}

