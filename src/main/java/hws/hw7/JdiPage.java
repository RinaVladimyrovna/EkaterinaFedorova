package hws.hw7;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;

import hws.hw7.pages.JdiIndexPage;
import hws.hw7.pages.MetalAndColorPage;

@JSite("https://epam.github.io/JDI")
public class JdiPage {

    @Url("index.html")
    public static JdiIndexPage indexPageJdi;

    @Url("metals-colors.html")
    public static MetalAndColorPage metalsColorsPage;

}
