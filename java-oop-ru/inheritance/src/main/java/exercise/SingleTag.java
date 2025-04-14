package exercise;

import java.util.Map;

// BEGIN
public final class SingleTag extends Tag {
    public SingleTag(String name, Map<String, String> attributes) {
        super(name, attributes);
    }

    @Override
    public String toString() {
        var res = String.format("<%s ", getName());
        for (var entry : getAttributes().entrySet()) {
            res += String.format("%s=\"%s\" ", entry.getKey(), entry.getValue());
        }
        return res.trim() + ">";
    }
}
// END
