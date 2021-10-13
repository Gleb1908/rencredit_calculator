package pages;

import categories.CheckBoxes;
import categories.CheckingValue;
import categories.InputFields;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class CalculatorPage extends BasePage {


    /**
     * Проверка открытия страницы, путём проверки title страницы
     *
     * @return MortgagePage - т.е. остаемся на этой странице
     */
    public CalculatorPage checkOpenCalculatorPage() {
        Assertions.assertEquals("Вклады",
                driverManager.getDriver().getTitle(),
                "Заголовок отсутствует/не соответствует требуемому");
        return this;
    }

    @Step("Выбрать валюту {currencyType}")
    public CalculatorPage choiceOfCurrencyType (InputFields currencyType) {
        String checkBoxCheckedLoc = "//div[@data-property='amount']//label[contains(@class,'field_" + currencyType.getTitle() + "')]";

        if (!isElementPresent(checkBoxCheckedLoc)) {
            switch (currencyType.getTitle()) {
                case ("usd"): {
                    String checkBox = "//label[contains(@class,'calculator__currency-field')]/input[@value='USD']/..";
                    driverManager.getDriver().findElement(By.xpath(checkBox)).click();
                    break;
                }
                case ("rub"): {
                    String checkBox = "//label[contains(@class,'calculator__currency-field')]/input[@value='RUB']/..";
                    driverManager.getDriver().findElement(By.xpath(checkBox)).click();
                    break;
                }
            }
        }
        return this;
    }


    /**
     * Метод заполнения полей
     *
     * @param inputFields - имя веб элемента, поля ввода
     * @param value     - значение вводимое в поле
     * @return MortgagePage - т.е. остаемся на этой странице
     */
    @Step("Ввод данных в поле {inputFields}")
    public CalculatorPage fillField(InputFields inputFields, InputFields value) {
        WebElement element = writeValuesToTheLine(inputFields,value);
        Assertions.assertEquals(value.getTitle().replaceAll("\\s+",""),
                                element.getAttribute("value").replaceAll("\\s+",""),
                                "Поле '" + inputFields.getTitle() + "' было заполнено некорректно");
        return this;
    }

    /**
     * Метод заполнения поля
     *
     * @param inputFields - имя веб элемента, поля ввода
     * @param value     - значение вводимое в поле
     */
    private WebElement writeValuesToTheLine (InputFields inputFields, InputFields value) {
        WebElement propertyValue = driverManager.getDriver().findElement(By.xpath("//div[@class='calculator__slide-section']//label[contains(text(),'" + inputFields.getTitle() + "')]/..//input"));
        waitUtilElementToBeClickable(propertyValue).click();
        propertyValue.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
        propertyValue.sendKeys(value.getTitle());
        return propertyValue;
    }

    @Step("Выбор срока в месяцах: {value}")
    public CalculatorPage selectValue(InputFields inputFields, InputFields value) {
        selectValuesFromList(inputFields,value);
        return this;
    }


    private void selectValuesFromList (InputFields inputFields, InputFields value) {

        driverManager.getDriver().findElement(By.xpath("//div[@class='calculator__slide-section']//label[contains(text(),'" + inputFields.getTitle() + "')]/..//div[@class='jq-selectbox__trigger-arrow']")).click();

        driverManager.getDriver().findElement(By.xpath("//div[@class='calculator__slide-section']//label[contains(text(),'" + inputFields.getTitle() + "')]/..//li[text()='" + value.getTitle() + "']")).click();

    }

    @Step("Выбор чекбокса {nameCheckBox}")
    public CalculatorPage selectCheckBox (CheckBoxes nameCheckBox, CheckBoxes trueOrFalse) {

        String checkBoxCheckedLoc = "//div[@class='calculator__check-row-field']//span[contains(text(),'" + nameCheckBox.getTitle() + "')]/../..//div[contains(@class,'__check checked')]";
        String checkBoxUnCheckedLoc = "//div[@class='calculator__check-row-field']//span[contains(text(),'" + nameCheckBox.getTitle() + "')]/../..//div[contains(@class,'__check')]";
        if (!String.valueOf(isElementPresent(checkBoxCheckedLoc)).equalsIgnoreCase(trueOrFalse.getTitle())) {
            WebElement element = driverManager.getDriver().findElement(By.xpath(checkBoxUnCheckedLoc));
            element.click();
        }
        return this;
    }


    private boolean isElementPresent (String element) {
        try {
            driverManager.getDriver().findElement(By.xpath(element));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Проверка корректности данных в поле {nameField}")
    public CalculatorPage checkingCalculatedValues (CheckingValue nameField, CheckingValue value) {

        switch (nameField.getTitle()) {
            case("Начислено"): {

                String actualValueStr = driverManager.getDriver().findElement(By.xpath("//tr[@class='calculator__dep-result-table-row']/td[contains(text(),'')]//span[@class='js-calc-earned']")).getText();
                numberCastingAndChecking (nameField, value, actualValueStr);

                break;
            }
            case("Пополнение за"): {

                String actualValueStr = driverManager.getDriver().findElement(By.xpath("//tr[@class='calculator__dep-result-table-row']/td[contains(text(),'')]//span[@class='js-calc-replenish']")).getText();
                numberCastingAndChecking (nameField, value, actualValueStr);

                break;
            }
            case("К снятию через"): {

                String actualValueStr = driverManager.getDriver().findElement(By.xpath("//div[@class='calculator__dep-result-value']//span[@class='js-calc-result']")).getText();
                numberCastingAndChecking (nameField, value, actualValueStr);

                break;
            }
        }
        return this;
    }


    private void numberCastingAndChecking (CheckingValue nameField, CheckingValue value, String actualValueStr) {

        double expectedValue = Double.parseDouble(value
                .getTitle()
                .replaceAll("\\s+","")
                .replaceAll(",","."));

        double actualValue = Double.parseDouble(actualValueStr
                .replaceAll("\\s+","")
                .replaceAll(",","."));

        Assertions.assertEquals(expectedValue,
                actualValue,
                "Поле '" + nameField.getTitle() + "' рассчитывается некорректно");

    }

}