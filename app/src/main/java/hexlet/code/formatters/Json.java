package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Item;

import java.io.IOException;
import java.util.ArrayList;


public class Json {
    public static String format(ArrayList<Item> list) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(list);
    }
}
