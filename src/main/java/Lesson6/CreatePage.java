package Lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePage extends BaseView{

    @FindBy(id = "qa-HOME_WIDGET_CONTROL_Notes_2|0_0|0_42YMZ3|13")
    private WebElement createButton;


    public CreatePage clickCreateButton(){
        createButton.click();
        return this;
    }

    public CreatePage(WebDriver driver) {
        super(driver);
    }
}
