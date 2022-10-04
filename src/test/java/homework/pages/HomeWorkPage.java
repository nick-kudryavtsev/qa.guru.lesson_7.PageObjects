package homework.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import homework.pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeWorkPage {

    //  components
    CalendarComponent calendarComponent = new CalendarComponent();

    //  elements
    private SelenideElement
            username = $("#firstName"),
            lastname = $("#lastName"),
            userEmail = $("#userEmail"),
            gender = $("#genterWrapper"),
            phone = $("#userNumber"),
            subject = $("#subjectsInput"),
            radio = $(".custom-control.custom-checkbox.custom-control-inline:nth-child(1)"),
            picture = $("#uploadPicture"),
            address = $("#currentAddress"),
            state = $("#state"),
            stateWrapper = $("#stateCity-wrapper"),
            city = $("#city"),
            cityWrapper = $("#stateCity-wrapper"),
            submit = $("#submit");

    //  actions
    public HomeWorkPage openPage(){
        open("/automation-practice-form");
        return this;
    }
    public HomeWorkPage setUsername(String username){
        this.username.setValue(username);
        return this;
    }
    public HomeWorkPage setLastname(String lastname){
        this.lastname.setValue(lastname);
        return this;
    }
    public HomeWorkPage setUserEmail(String email){
        this.userEmail.setValue(email);
        return this;
    }
    public HomeWorkPage setGender(String value){
        this.gender.$(byText(value)).click();
        return this;
    }
    public HomeWorkPage setPhone(String value){
        this.phone.setValue(value);
        return this;
    }
    public HomeWorkPage setBirthday(String day, String month, String year){
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    public HomeWorkPage setSubject(String value){
        this.subject.setValue(value).pressEnter();
        return this;
    }
    public HomeWorkPage setRadio(){
        this.radio.click();
        return this;
    }
    public HomeWorkPage uploadImg(String value){
        this.picture.uploadFromClasspath(value);
        return this;
    }
    public HomeWorkPage setAddress(String value){
        this.address.setValue(value);
        return this;
    }
    public HomeWorkPage setState(String value){
        this.state.click();
        this.stateWrapper.$(byText(value)).click();
        return this;
    }
    public HomeWorkPage setCity(String value){
        this.city.click();
        this.cityWrapper.$(byText(value)).click();
        return this;
    }
    public HomeWorkPage clickOnSubmit(){
        this.submit.click();
        return this;
    }

    void jsDisplayNone(String el){
        executeJavaScript(
                String.format("document.querySelector(\"%s\").style.display = \"none\"", el)
        );
    }

    void jsSetDataPicker(String el, String date){
        executeJavaScript(
                String.format("document.querySelector(\"%s\").value = \"%s\"", el, date)
        );
    }

}
