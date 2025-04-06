package exercise;

import java.util.Map;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> map = storage.toMap();
        for (var entry : map.entrySet()) {
            storage.set(entry.getValue(), entry.getKey());
            storage.unset(entry.getKey());
        }
    }
}
// END
