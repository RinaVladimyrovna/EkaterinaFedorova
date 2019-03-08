package hws.hw8.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.Icon;
import com.epam.jdi.light.ui.html.complex.Menu;
import hws.hw8.entities.HeaderMenuItems;
import hws.hw8.entities.Users;
import hws.hw8.forms.LogInForm;

public class JdiIndexPage extends WebPage {

    LogInForm logInForm;

    @Css("[id='user-icon']")
    private Icon loginIcon;

    @Css(".m-l8")
    private Menu menu;


    public void login(Users user) {
        loginIcon.click();
        logInForm.loginAs(user);
    }

    public void navigateToPage(HeaderMenuItems link) {
        menu.select(link);
    }

}
