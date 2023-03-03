package MVP;

import Infrastucture.*;

import java.util.logging.Logger;
import Logger.MyLog;
import UI.View;

public class Presenter <T extends CalcModel> {
    static MyLog myLog = new MyLog(Logger.getLogger(Presenter.class.getName()));

    View view;
    Model model;

    public Presenter(T m, View v) {
        model = m;
        view = v;
    }

    //или создать отдельный класс для обработки PresenterComplex, экз-р которого запускать в App при соотв.выборе?
    public void buttonClick(){
        if (this.model instanceof CalcRationalNumbers) this.buttonClickRational();
        else if (this.model instanceof CalcComplexNumbers) buttonClickComplex();
    }
    public void buttonClickRational() {
        Double res = null;
        Double first = view.getValue("Введите число: ");
        char operation = view.getOperation("Введите операцию (+,-,*,/): ");
        Double second = view.getValue("Введите число: ");
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
        ComplexNumber firstNum = new ComplexNumber(view.getValue("Введите реальную часть компл.числа: "),
                view.getValue("Введите мнимую часть компл.числа: "));
        char operation = view.getOperation("Введите операцию (+,-,*,/): ");
        ComplexNumber secondNum = new ComplexNumber(view.getValue("Введите реальную часть компл.числа: "),
                view.getValue("Введите мнимую часть компл.числа: "));
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

