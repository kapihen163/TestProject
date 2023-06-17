package Lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExitPage extends BaseView{

    @FindBy(className = "mjp8WyYQODySClV2byHt")
    private WebElement AccountMailElement;

    @FindBy(id = "qa-ACCOUNT_DROPDOWN_LOGOUT")
    private WebElement ExitAccount;

    public ExitPage clickAccountMailElement (){
        AccountMailElement.click();
        return this;
    }

    public ExitPage clickExitAccount(){
        ExitAccount.click();
        return this;
    }

    public ExitPage(WebDriver driver){
        super(driver);
    }
}
