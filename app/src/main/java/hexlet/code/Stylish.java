package hexlet.code;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Stylish {
    public static String formate(ArrayList<String> list) {
        var result = list.stream()
                .map(x -> {
                    if (x.charAt(0) == '+' || x.charAt(0) == '-') {
                        return " ".repeat(2) + x;
                    } else {
                        return " ".repeat(4) + x;
                    }
                })
                .collect(Collectors.joining("\n"));

        result = "{\n" + result + "\n}";

        return result;
    }
}
