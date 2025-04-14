package exercise;

import java.util.Map;
import java.util.List;

// BEGIN
public final class PairedTag extends Tag {
    private final String bodyOfTag;
    private final List<Tag> children;

    public PairedTag(String name, Map<String, String> attributes, String bodyOfTag, List<Tag> children) {
        super(name, attributes);
        this.bodyOfTag = bodyOfTag;
        this.children = children;
    }

    @Override
    public String toString() {
        Tag simpleTag = new SingleTag(getName(), getAttributes());
        var res = simpleTag.toString();
        if (children.isEmpty()) {
            res = res + bodyOfTag;
        } else {
            for (var child : children) {
                res += child.toString();
            }
        }
        return res + String.format("</%s>", getName());
    }
}
// END
