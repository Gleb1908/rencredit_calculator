package tests;

import baseTestClass.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.Listener;

import static categories.CheckBoxes.*;
import static categories.CheckingValue.*;
import static categories.DepositsSubMenuTitle.PROFITABILITY_CALCULATOR;
import static categories.InputFields.*;
import static categories.ToolbarTitle.DEPOSITS;

@ExtendWith(Listener.class)
public class CalculatorTest extends BaseTest {

    @Test
    public void calculatorTestRub() {

        app.getHomePage()
                .selectToolbarTitleAndSubMenu(DEPOSITS, PROFITABILITY_CALCULATOR)
                .checkOpenCalculatorPage()
                .choiceOfCurrencyType(RUB)
                .fillField(DEPOSIT_AMOUNT, DEPOSIT_AMOUNT_VALUE_RUB)
                .selectValue(PERIOD, PERIOD_VALUE_6)
                .fillField(MONTHLY_TOP_UP, MONTHLY_TOP_UP_VALUE_RUB)
                .selectCheckBox(MONTHLY_CAPITALIZATION, CHECK)
                .selectCheckBox(PARTIAL_WITHDRAWAL, UNCHECK)
                .checkingCalculatedValues(ACCRUED, ACCRUED_VALUE_RUB)
                .checkingCalculatedValues(REPLENISHMENT,REPLENISHMENT_VALUE_RUB)
                .checkingCalculatedValues(WITHDRAW,WITHDRAW_VALUE_RUB);
    }

    @Test
    public void calculatorTestUsd() {

        app.getHomePage()
                .selectToolbarTitleAndSubMenu(DEPOSITS, PROFITABILITY_CALCULATOR)
                .checkOpenCalculatorPage()
                .choiceOfCurrencyType(USD)
                .fillField(DEPOSIT_AMOUNT, DEPOSIT_AMOUNT_VALUE_USD)
                .fillField(MONTHLY_TOP_UP, MONTHLY_TOP_UP_VALUE_USD)
                .selectValue(PERIOD, PERIOD_VALUE_12)
                .selectCheckBox(MONTHLY_CAPITALIZATION, CHECK)
                .selectCheckBox(PARTIAL_WITHDRAWAL, UNCHECK)
                .checkingCalculatedValues(ACCRUED, ACCRUED_VALUE_USD)
                .checkingCalculatedValues(REPLENISHMENT,REPLENISHMENT_VALUE_USD)
                .checkingCalculatedValues(WITHDRAW,WITHDRAW_VALUE_USD);
    }

}
