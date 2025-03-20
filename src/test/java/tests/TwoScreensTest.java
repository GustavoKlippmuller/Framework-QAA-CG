package tests;

import framework.base.BaseTest;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.awt.Toolkit;

public class TwoScreensTest extends BaseTest {

    private int screenWidth;
    private int screenHeight;

    @Test
    public void testTwoScreens() {

        setSizeScreen();

        driver.manage().window().setPosition(getPointLeft());
        driver.manage().window().setSize(getDimension());

        WebDriver rightDriver = driver.switchTo().newWindow(WindowType.WINDOW);
        rightDriver.manage().window().setPosition(getPointRight());
        rightDriver.manage().window().setSize(getDimension());
        rightDriver.get("https://www.google.com.ar");
        waitExplicitFiveSeconds();
    }

    private Dimension getDimension() {
        return new Dimension(screenWidth / 2, screenHeight);
    }

    private Point getPointLeft() {
        return new Point(0, 0);
    }

    private Point getPointRight() {
        return new Point(screenWidth / 2, 0);
    }

    private void setSizeScreen() {
        java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenWidth = (int) screenSize.getWidth();
        screenHeight = (int) screenSize.getHeight();
    }
}
