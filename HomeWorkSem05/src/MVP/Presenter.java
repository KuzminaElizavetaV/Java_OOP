package MVP;

import Infrastucture.*;

import java.util.logging.Logger;
import Logger.MyLogger;
import UI.View;

/**
 * Класс управления связью между Model(пакет Infrastructure) и View (пакет UI)
 * @param <T> обобщеннный тип, но только для тех классов, которые наследуются от астрактного класса CalcModel
 */
public class Presenter <T extends CalcModel> {
    static MyLogger myLog = new MyLogger(Logger.getLogger(Presenter.class.getName()));

    View view;
    Model model;

    public Presenter(T m, View v) {
        model = m;
        view = v;
    }

    public void buttonClick(){
        if (this.model instanceof CalcRationalNumbers) this.buttonClickRational();
        else if (this.model instanceof CalcComplexNumbers) buttonClickComplex();
    }
    public void buttonClickRational() {
        Double res = null;
        Double first = view.getValue("ВВЕДИТЕ ЧИСЛО: ");
        char operation = view.getOperation("ВВЕДИТЕ ОПЕРАЦИЮ (+,-,*,/): ");
        Double second = view.getValue("ВВЕДИТЕ ЧИСЛО: ");
        model.setX(first);
        model.setY(second);
        try {
            res = (Double) model.result(operation);}
        catch (Exception e){
            e.printStackTrace();
            myLog.log(e.getMessage());
        }
        view.viewResult(String.format("%s", res), String.format("%s %s %s = ", first, operation,second));

    }
    public void buttonClickComplex(){
        ComplexNumber res = null;
        ComplexNumber firstNum = new ComplexNumber(view.getValue("ВВЕДИТЕ ВЕЩЕСТВЕННУЮ ЧАСТЬ 1 КОМПЛЕКСНОГО ЧИСЛА: "),
                view.getValue("ВВЕДИТЕ МНИМУЮ ЧАСТЬ 1 КОМПЛЕКСНОГО ЧИСЛА: "));
        char operation = view.getOperation("ВВЕДИТЕ ОПЕРАЦИЮ (+,-,*,/): ");
        ComplexNumber secondNum = new ComplexNumber(view.getValue("ВВЕДИТЕ ВЕЩЕСТВЕННУЮ ЧАСТЬ 2 КОМПЛЕКСНОГО ЧИСЛА: "),
                view.getValue("ВВЕДИТЕ МНИМУЮ ЧАСТЬ 2 КОМПЛЕКСНОГО ЧИСЛА: "));
        model.setX(firstNum);
        model.setY(secondNum);
        try {
            res = (ComplexNumber) model.result(operation);}
        catch (Exception e){
            e.printStackTrace();
            myLog.log(e.getMessage());
        }
        view.viewResult(String.format("%s", res), String.format("%s %s %s = ", firstNum, operation, secondNum));
    }
}

