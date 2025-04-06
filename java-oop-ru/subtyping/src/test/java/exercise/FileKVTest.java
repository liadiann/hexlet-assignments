package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import com.fasterxml.jackson.databind.ObjectMapper;
// BEGIN
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.TRUNCATE_EXISTING);
    }

    // BEGIN
    @Test
    public void fileKVTest() {
        KeyValueStorage storage = new FileKV(filepath.toString(), Map.of("key", "value"));
        var actual = storage.get("key", "default");
        var expected = "value";
        assertEquals(expected, actual);
        actual = storage.get("a", "default");
        expected = "default";
        assertEquals(expected, actual);
        storage.set("key2", "value2");
        actual = storage.get("key2", "default");
        expected = "value2";
        assertEquals(expected, actual);
        storage.unset("key");
        actual = storage.get("key", "default");
        expected = "default";
        assertEquals(expected, actual);
        assertEquals(Map.of("key2", "value2"), storage.toMap());
    }
    // END
}
