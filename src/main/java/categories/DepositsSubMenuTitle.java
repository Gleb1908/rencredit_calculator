package categories;

public enum DepositsSubMenuTitle {

    SAVINGS_ACCOUNT ("Накопительный счет"),
    PROFITABLE_INVESTMENT ("Вклад «Ренессанс Доходный»"),
    CUMULATIVE_INVESTMENT ("Вклад «Ренессанс Накопительный»"),
    WITHOUT_BORDERS_INVESTMENT ("Вклад «Ренессанс Без границ»"),
    SPECIAL_INVESTMENT ("Вклад «Ренессанс Специальный»"),
    ALL_INVESTMENTS ("Все вклады"),
    PROFITABILITY_CALCULATOR ("Калькулятор доходности"),
    REPLENISHMENT_METHODS ("Способы пополнения вклада"),
    HOW_TO_OPEN_INVESTMENT ("Как открыть вклад онлайн?"),
    TARIFFS_AND_CONDITIONS ("Тарифы и условия");

    private String title;

    DepositsSubMenuTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
