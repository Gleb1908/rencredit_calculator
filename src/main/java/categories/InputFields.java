package categories;

public enum InputFields {

    RUB ("rub"),
    USD ("usd"),

    DEPOSIT_AMOUNT ("Сумма вклада"),
    DEPOSIT_AMOUNT_VALUE_RUB ("300 000"),
    DEPOSIT_AMOUNT_VALUE_USD ("500 000"),

    PERIOD ("На срок"),
    PERIOD_VALUE_3 ("3 месяца"),
    PERIOD_VALUE_6 ("6 месяцев"),
    PERIOD_VALUE_9 ("9 месяцев"),
    PERIOD_VALUE_12 ("12 месяцев"),
    PERIOD_VALUE_13 ("13 месяцев"),
    PERIOD_VALUE_18 ("18 месяцев"),

    MONTHLY_TOP_UP ("Ежемесячное пополнение"),
    MONTHLY_TOP_UP_VALUE_RUB ("50 000"),
    MONTHLY_TOP_UP_VALUE_USD ("20 000");

    private String title;

    InputFields(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
