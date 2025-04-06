package exercise;

import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private String filepath;

    public FileKV(String filepath, Map<String, String> startMap) {
        this.filepath = filepath;
        Utils.writeFile(filepath, Utils.serialize(startMap));
    }

    @Override
    public void set(String key, String value) {
        var map = toMap();
        map.put(key, value);
        Utils.writeFile(filepath, Utils.serialize(map));
    }

    @Override
    public void unset(String key) {
        var map = toMap();
        map.remove(key);
        Utils.writeFile(filepath, Utils.serialize(map));
    }

    @Override
    public String get(String key, String defaultValue) {
        return toMap().getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        var content = Utils.readFile(filepath);
        return Utils.deserialize(content);
    }
}
// END
