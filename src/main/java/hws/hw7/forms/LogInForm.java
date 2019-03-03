package hws.hw7.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.TextField;
import hws.hw7.entities.Users;

public class LogInForm extends Form<Users> {

    @Css("[id='name']")
    private TextField login;

    @Css("[id='password']")
    private TextField password;

    @Css("[id='login-button']")
    private Button submit;

}
