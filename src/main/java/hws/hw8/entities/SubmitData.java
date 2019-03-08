package hws.hw8.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public class SubmitData {

    public List<String> radioButtons;
    public List<String> checkboxes;
    public String colorDropDown;
    public String metalDropDown;
    public List<String> vegetableDropDown;

}
