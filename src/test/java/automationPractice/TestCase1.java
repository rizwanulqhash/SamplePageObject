package automationPractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.automationPractice.LoginPage;
import pageObjects.automationPractice.MyAccount;
import pageObjects.automationPractice.MyAddresses;
import pageObjects.base.BaseTest;

public class TestCase1 extends BaseTest {
    LoginPage loginPage;
    MyAccount myAccount;
    String addressTitle = "AsusAddress";

    @Test
    public void openLoginPageTest() {
        LaunchApplication();
        loginPage = clickOnSignInLink();
        Assert.assertEquals(loginPage.getPageTitle(), "Login - My Store");
    }

    @Test(dependsOnMethods = "openLoginPageTest")
    public void loginTest() {
        loginPage
                .enterEmail("asu9421@gmail.com")
                .enterPassword("aut555");
        myAccount = loginPage.clickOnSignInButton();
        Assert.assertEquals(myAccount.getPageTitle(), "My account - My Store");
    }

    @Test(dependsOnMethods = "loginTest")
    public void AddAddress() {
        MyAddresses myAddress = myAccount.ClickOnMyAddress();
        myAddress.clickOnAddNewAddress();
        myAddress
                .enterFirstName("Asif")
                .enterLastName("Sarkar")
                .enterAddress1("5th Avenue Street, North Dacota")
                .enterCity("Seattle")
                .SelectState(2)
                .enterPostcode("50001")
                .enterHomePhone("1234567890")
                .enterMobilePhone("1234567890")
                .enterAddressTitle(addressTitle);
        myAccount = myAddress.ClickOnSaveButton();
    }

    @Test(dependsOnMethods = "AddAddress")
    public void DeleteAddress() {
        myAccount.DeleteAddress1();
    }

    @Test(dependsOnMethods = "DeleteAddress")
    public void performSignOut() {
        clickOnSignOutLink();
        Assert.assertEquals(loginPage.getPageTitle(), "Login - My Store");
    }

    /*@Test
    public void failedTest(){
        driver.get("https://www.google.com");
        //getScreenShot("sample screen shot");
        Reporter.log("Hi Asif, this is from TestNGRelated Reporter Log");
        Assert.assertEquals("1","2");
    }*/


}


