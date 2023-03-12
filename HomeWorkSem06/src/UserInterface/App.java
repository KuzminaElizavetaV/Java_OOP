package UserInterface;

import PresenterAll.I_Presenter;
import PresenterAll.PresenterCalcComplexNumbers;
import PresenterAll.PresenterCalcRationalNumbers;

import java.io.File;

/**
 * Класс App - запуск и верхнее меню приложения
 */
public class App {
    private final View view;
    private I_Presenter presenter; //задается после пользовательского выбора

    /**
     * Конструктор экземпляра App, принимает параметры:
     * @param view тип View, например, new ConsoleView()
     */
    public App(View view) {
        this.view = view;
    }
    //Принцип инверсии зависимостей: экз-р App при создании может принять любой тип View при необходимости,
    //и не ограничиваться ConsoleView

    /**
     * метод задает значение переменной presenter, а именно создает экземпляр конкретного класса,
     * расширяемого I_Presenter в зависимости от выбора пользователя
     * @param num числовое обозначение пользовательского выбора - пункт меню
     */
    void setPresenter(int num) {
        if (num == 1) presenter = new PresenterCalcRationalNumbers(view);
        else if (num == 2) {
            presenter = new PresenterCalcComplexNumbers(view);
        }
    }

    /**
     * Запуск приложения и старт главного меню
     */
    public void start() {
        while (true) {
            int menu = view.getVariant("""
                    
                    **** ВВЕДИТЕ ЧИСЛО, СОГЛАСНО ПУНКТУ МЕНЮ ****:
                        1 => ОПЕРАЦИИ С РАЦИОНАЛЬНЫМИ ЧИСЛАМИ
                        2 => ОПЕРАЦИИ С КОМПЛЕКСНЫМИ ЧИСЛАМИ
                        3 => ПРОСМОТР ФАЙЛА ЛОГИРОВАНИЯ
                        4 => ВЫХОД ИЗ ПРОГРАММЫ""");
            switch (menu) {
                case 1, 2:
                    this.setPresenter(menu); //установили Презентер в зависимости от выбранного пункта
                    //дальше неважно, какой там презентер, т.к. реализован метод интерфейса I_Presenter - buttonClick()
                    presenter.buttonClick();
                    //Принцип 5 - инверсии зависимостей. Здесь приложение слабо связано с типом расчетов,
                    //оно зависит от Абстракций и легче расширяется при необходимости
                    break;
                case 3:
                    view.viewLog(new File("Test\\src\\CalculatorLog.txt"));
                    break;
                case 4:
                    return;
                default:
                    view.viewData( "ВВЕДЕН НЕКОРРЕКТНЫЙ ПУНКТ МЕНЮ."," ПОВТОРИТЕ ВВОД.");
                    break;
            }
        }
    }
}

