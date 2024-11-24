package com.calculator.pageobjects;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CalculatorPage {
    private static final String RESULT_FIELD = ".qv3Wpe";
    private static final String RESET_BUTTON_LBL = "all clear";
    private static final String CLEAR_BUTTON_LBL = "clear entry";
    private static final String DECIMAL_BUTTON_LBL = "point";
    private static final String ADD_LBL = "plus";
    private static final String MINUS_LBL = "minus";
    private static final String DIVIDE_LBL = "divide";
    private static final String MULTIPLY_LBL = "multiply";
    private static final String EQUALS_LBL = "equals";
    private Page page;

    public CalculatorPage(Page page) {
        this.page = page;
    }

    public void clickButton(String buttonText) {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(buttonText).setExact(true)).click();

    }


    public String getResult() {
        return page.locator(RESULT_FIELD).textContent();
    }

    public void clickAdd() {
        page.getByLabel(ADD_LBL, new Page.GetByLabelOptions().setExact(true)).click();
    }

    public void clickSubtract() {
        page.getByLabel(MINUS_LBL, new Page.GetByLabelOptions().setExact(true)).click();
    }

    public void clickDivide() {
        page.getByLabel(DIVIDE_LBL, new Page.GetByLabelOptions().setExact(true)).click();
    }

    public void clickMultiply() {
        page.getByLabel(MULTIPLY_LBL, new Page.GetByLabelOptions().setExact(true)).click();
    }

    public void clickEquals() {
        page.getByLabel(EQUALS_LBL, new Page.GetByLabelOptions().setExact(true)).click();
    }

    public void clickReset() {
        page.getByLabel(RESET_BUTTON_LBL).click();
    }

    public void clearEntry() {
        page.getByLabel(CLEAR_BUTTON_LBL).click();
    }

    public void clickDecimal() {
        page.getByLabel(DECIMAL_BUTTON_LBL).click();
    }
}
