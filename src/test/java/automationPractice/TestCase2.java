package automationPractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.automationPractice.EveningDresses;
import pageObjects.automationPractice.HomePage;
import pageObjects.automationPractice.LoginPage;
import pageObjects.base.BaseTest;

public class TestCase2 extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;
    EveningDresses eveningDresses;

    @Test
    public void NavigateToWomenEveningDressSection2() throws InterruptedException {
        homePage = LaunchApplication();
        eveningDresses = homePage.openWomenEveningDressMenu();
        Assert.assertEquals(eveningDresses.getPageTitle(), "Evening Dresses - My Store");
    }

    @Test
    public void test123(){

    }





}
