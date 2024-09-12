package Mastermind;

import java.util.HashMap;

public class colours {

    static HashMap<String, String> _colourMap = new HashMap<>(6);

    public static HashMap<String, String> colourMap() {
        _colourMap.put("r", "\u001B[31mo\u001B[0m");
        _colourMap.put("y", "\u001B[33mo\u001B[0m");
        _colourMap.put("g", "\u001B[32mo\u001B[0m");
        _colourMap.put("b", "\u001B[34mo\u001B[0m");
        _colourMap.put("m", "\u001B[35mo\u001B[0m");
        _colourMap.put("c", "\u001B[36mo\u001B[0m");
        return _colourMap;
    }
}
