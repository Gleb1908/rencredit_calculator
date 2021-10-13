package categories;

public enum ToolbarTitle {

    CREDITS ("Кредиты"),
    CARDS ("Карты"),
    DEPOSITS ("Вклады"),
    INVESTMENTS ("Инвестиции"),
    SERVICES ("Сервисы");

    private String title;

    ToolbarTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
