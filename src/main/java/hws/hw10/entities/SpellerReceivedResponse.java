package hws.hw10.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@ToString
public class SpellerReceivedResponse {

    public int code;
    public int pos;
    public int row;
    public int col;
    public int len;
    public String word;
    public List<String> s;

}
