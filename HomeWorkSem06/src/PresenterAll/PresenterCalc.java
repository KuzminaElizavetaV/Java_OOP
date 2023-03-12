package PresenterAll;

import Infrastructure.Model;
import Logger.MyLoggerNew;
import UserInterface.View;

import java.util.logging.Logger;

/**
 * Абстрактный класс описывает компоненту связи Model и View между собой,
 * расширяется интерфейсом I_Presenter для реализации дочерними классами
 */
public abstract class PresenterCalc implements I_Presenter {
    static protected MyLoggerNew myLog;
    protected View view;
    protected Model model;

    static {
        myLog = new MyLoggerNew(Logger.getLogger(PresenterCalc.class.getName()));
    }
}
