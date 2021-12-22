package Pages;

import Utils.WebExe;
import Utils.database;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends WebExe implements database {
    @FindBy(css="#nav-logo-sprites") WebElement logoAmazon;
    @FindBy(css="input#twotabsearchtextbox") WebElement searchbar;
    @FindBy(css="#nav-cart") WebElement cartMenu;
    @FindBy(css="#nav-link-accountList") WebElement accountNavBar;
    @FindBy(xpath="//*[@id='nav-al-signin']//span[text()='Sign in']") WebElement dropDownSignInButton;
    String userNickName = "Sign in";
    private String xpathGreetingAccount(){ return "//*[@id='nav-link-accountList-nav-line-1'][text()='Hello, "+this.userNickName+"']"; }

    public void clickAccountNavBar(){
        waitingForPresenceOfElement(accountNavBar,5000,100);
        click(accountNavBar,5);
    }

    public void hoveringMouseToAccountNavBar(){
        waitingForPresenceOfElement(accountNavBar,5000,100);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(accountNavBar).perform();
    }

    public void clickButtonSignInFromDropDownAccountNavBar(){
        waitUntilVisible(dropDownSignInButton, 5000);
        click(dropDownSignInButton,5);
    }

    public void assertionCurrentPageIsHomePage(){
        String urlPattern = ".*www\\.amazon\\.com[\\/]{0,1}(\\?ref_=nav_ya_signin&)";
        int maxWait = 5;
        while(!getDriver().getCurrentUrl().replaceAll(urlPattern,"").equals("") && maxWait >0){
            try{Thread.sleep(1000);} catch (InterruptedException e){}
            maxWait--;
        }

        if(maxWait==0) Assert.fail();
    }

    public void assertionHomepageView(String... name){
        waitingForPresenceOfElement(accountNavBar, 5000, 100);
        waitingForPresenceOfElement(logoAmazon, 5000, 100);
        waitingForPresenceOfElement(searchbar, 5000, 100);
        waitingForPresenceOfElement(cartMenu, 5000, 100);

        Assert.assertTrue(accountNavBar.isDisplayed());
        Assert.assertTrue(logoAmazon.isDisplayed());
        Assert.assertTrue(searchbar.isDisplayed());
        Assert.assertTrue(cartMenu.isDisplayed());

        this.userNickName = name.length>=1 ?  name[0] : this.userNickName;
        element(By.xpath(this.xpathGreetingAccount())).isDisplayed();
    }
}
