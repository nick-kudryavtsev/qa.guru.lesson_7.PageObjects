package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    //  elements
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail");

    //  actions


    public RegistrationFormPage openPage(){
        open("automation-practise-form");
        $(".practise-form-wrapper").shouldHave(Condition.text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setName(String name){
        firstNameInput.setValue(name);

        return this;
    };
}
