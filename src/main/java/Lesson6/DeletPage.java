package Lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeletPage extends BaseView{
//    ead4d728-0d7a-0d70-8659-5b2877fb8879_qa-NOTES_SIDEBAR_NOTE_SNIPPET
    @FindBy(id = "ead4d728-0d7a-0d70-8659-5b2877fb8879_qa-NOTES_SIDEBAR_NOTE")
    private WebElement createNote;

    @FindBy(id = "qa-NOTE_ACTIONS")
    private WebElement OpenWindow;
    @FindBy(id = "qa-ACTION_DELETE")
    private WebElement DeletButton;
    @FindBy(linkText = "Корзина")
    private WebElement BasketButton;
    @FindBy(id = "qa-SPACE_VIEW_ACTIONS_HEADER")
    private WebElement ClearBasketButton;

    public DeletPage clickCreateNote(){
        createNote.click();
        return this;
    }

    public DeletPage clickOpenWindow(){
        OpenWindow.click();
        return this;
    }
    public DeletPage clickDeletButton(){
        DeletButton.click();
        return this;
    }

    public DeletPage clickBasketButton(){
        BasketButton.click();
        return this;
    }

    public DeletPage clickClearBasketButton(){
        ClearBasketButton.click();
        return this;
    }


    public DeletPage(WebDriver driver){
        super(driver);
    }
}
