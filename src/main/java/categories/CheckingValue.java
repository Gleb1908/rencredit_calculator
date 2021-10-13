package categories;

public enum CheckingValue {

    ACCRUED ("Начислено"),
    ACCRUED_VALUE_RUB ("12 781.28"),
    ACCRUED_VALUE_USD ("920.60"),

    REPLENISHMENT ("Пополнение за"),
    REPLENISHMENT_VALUE_RUB ("250 000,00"),
    REPLENISHMENT_VALUE_USD ("220 000,00"),

    WITHDRAW ("К снятию через"),
    WITHDRAW_VALUE_RUB ("562 781,28"),
    WITHDRAW_VALUE_USD ("720 920,60");

    private String title;

    CheckingValue(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
