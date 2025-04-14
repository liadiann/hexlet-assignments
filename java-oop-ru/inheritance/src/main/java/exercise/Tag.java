package exercise;

//import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public abstract class Tag {
    private final String name;
    private final Map<String, String> attributes;
    public abstract String toString();

    public Tag(String name, Map<String, String> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }
}
// END
