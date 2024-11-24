package com.calculator.tests;

import com.calculator.pageobjects.CalculatorPage;
import com.calculator.utils.ReportListener;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import static com.aventstack.extentreports.Status.INFO;

public class CalculatorTest extends BaseTest {

    private CalculatorPage calculatorPage;

    @BeforeClass
    public void createPage(ITestContext context) {
        calculatorPage = new CalculatorPage(page);
    }

    @BeforeMethod
    public void reset(){
        page.reload();
    }

    @Test
    public void testAddition() {
        extentTest = ReportListener.test.get();
        extentTest.log(INFO, "Test Addition functionality");
        int input1 = 0;
        int input2 = 1;
        calculatorPage.clickButton(String.valueOf(input1));
        calculatorPage.clickAdd();
        calculatorPage.clickButton(String.valueOf(input2));
        calculatorPage.clickEquals();

        String result = calculatorPage.getResult();
        Assert.assertEquals(result, String.valueOf(input1 + input2), "Result of addition is correct.");
    }

    @Test
    public void testSubtraction() {
        extentTest = ReportListener.test.get();
        extentTest.log(INFO, "Test Subtraction functionality");
        int input1 = 2;
        int input2 = 3;
        calculatorPage.clickButton(String.valueOf(input1));
        calculatorPage.clickSubtract();
        calculatorPage.clickButton(String.valueOf(input2));
        calculatorPage.clickEquals();

        // Verify the result
        String result = calculatorPage.getResult();
        Assert.assertEquals(result, String.valueOf(input1 - input2), "Result of subtraction is correct.");
    }

    @Test
    public void testMultiplication() {
        extentTest = ReportListener.test.get();
        extentTest.log(INFO, "Test Multiplication functionality");
        int input1 = 4;
        int input2 = 5;
        calculatorPage.clickButton(String.valueOf(input1));
        calculatorPage.clickMultiply();
        calculatorPage.clickButton(String.valueOf(input2));
        calculatorPage.clickEquals();

        // Verify the result
        String result = calculatorPage.getResult();
        Assert.assertEquals(result, String.valueOf(input1 * input2), "Result of multiplication is correct.");
    }

    @Test
    public void testDivision() {
        extentTest = ReportListener.test.get();
        extentTest.log(INFO, "Test Division functionality");
        int input1 = 6;
        int input2 = 3;
        calculatorPage.clickButton(String.valueOf(input1));
        calculatorPage.clickDivide();
        calculatorPage.clickButton(String.valueOf(input2));
        calculatorPage.clickEquals();

        String result = calculatorPage.getResult();
        Assert.assertEquals(result, String.valueOf(input1 / input2), "Result of Division is correct.");
    }

    @Test
    public void testDivideByZero() {

        int input1 = 6;
        int input2 = 0;

        extentTest = ReportListener.test.get();
        extentTest.log(INFO, "Test Divide by 0");

        calculatorPage.clickButton(String.valueOf(input1));
        calculatorPage.clickDivide();
        calculatorPage.clickButton(String.valueOf(input2));
        calculatorPage.clickEquals();

        String result = calculatorPage.getResult();
        Assert.assertTrue(result.equals("Infinity"), "Calculator handles divide by 0 properly.");
    }

    @Test
    public void testClear() {
        extentTest = ReportListener.test.get();
        extentTest.log(INFO, "Test Clear button functionality");
        int input1 = 9;
        int input2 = 8;
        calculatorPage.clickButton(String.valueOf(input1));
        calculatorPage.clickAdd();
        calculatorPage.clickButton(String.valueOf(input2));
        calculatorPage.clearEntry();
        calculatorPage.clearEntry();
        calculatorPage.clearEntry();

        String result = calculatorPage.getResult();
        Assert.assertEquals(result, "0", "Result is cleared.");
    }

    @Test
    public void testDecimalPoint() {

        extentTest = ReportListener.test.get();
        extentTest.log(INFO, "Test Decimal Point functionality");
        calculatorPage.clickButton("2");
        calculatorPage.clickDecimal();
        calculatorPage.clickButton("5");
        calculatorPage.clickAdd();
        calculatorPage.clickButton("1");
        calculatorPage.clickDecimal();
        calculatorPage.clickButton("5");
        calculatorPage.clickEquals();

        String result = calculatorPage.getResult();
        Assert.assertEquals(result, "4", "Result of decimal operands is correct.");
    }

    @AfterClass
    public void closePage() {
        page.close();
    }
}



