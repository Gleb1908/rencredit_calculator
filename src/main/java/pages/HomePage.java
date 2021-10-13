package pages;

import categories.DepositsSubMenuTitle;
import categories.ToolbarTitle;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {


    /**
     * Функция клика на любой пункт мени и подменю
     *
     * @param toolbarTitle - наименование меню
     * @return MortgagePage - т.е. переходим на страницу выбранного подменю
     */
    @Step("Выбрать пункт меню и подменю")
    public CalculatorPage selectToolbarTitleAndSubMenu(ToolbarTitle toolbarTitle, DepositsSubMenuTitle depositsSubMenuTitle) {
        selectToolbarTitle(toolbarTitle);
        selectSubMenu(toolbarTitle, depositsSubMenuTitle);
        return pageManager.getCalculatorPage();
    }


    /**
     * Функция клика на любой пункт меню
     *
     * @param toolbarTitle - наименование меню
     */
    private void selectToolbarTitle(ToolbarTitle toolbarTitle) {
        String toolbarTitleLoc = "//nav[@class='nav nav_primary']//span[contains(text(),'" + toolbarTitle.getTitle() + "')]";
        try {
            WebElement element = driverManager.getDriver().findElement(By.xpath(toolbarTitleLoc));
            element.click();
        } catch (NoSuchElementException ignored) {
            Assertions.fail("Меню '" + toolbarTitle.getTitle() + "' не найдено на стартовой странице");
        }
    }

    /**
     * Функция клика на любое подменю
     *
     * @param depositsSubMenuTitle - наименование подменю
     */
    private void selectSubMenu(ToolbarTitle toolbarTitle, DepositsSubMenuTitle depositsSubMenuTitle) {
        String subMenuTitleLog = "//nav[@class='nav nav_primary']//span[contains(text(),'" + toolbarTitle.getTitle() + "')]/../..//li[@class='nav__item']/a[contains(text(),'" + depositsSubMenuTitle.getTitle() + "')]";
        try {
            WebElement element = driverManager.getDriver().findElement(By.xpath(subMenuTitleLog));
            element.click();
        } catch (NoSuchElementException ignored) {
            Assertions.fail("Подменю '" + depositsSubMenuTitle.getTitle() + "' не найдено на стартовой странице");
        }
    }
}
