package one.chest.polymorph.descriptor;

import java.util.Objects;
import java.util.Set;

public class FieldDescriptor extends SourceDescriptor implements ReferenceDescriptor {

    private final String referenceName;

    public FieldDescriptor(String referenceName, Set<SourceModifier> modifiers) {
        super(modifiers);
        this.referenceName = referenceName;
    }

    @Override
    public String getReferenceName() {
        return referenceName;
    }

    public Class<?> getType() {
        throw new UnsupportedOperationException("getType");
    }

    @Override
    public String toString() {
        return "FieldDescriptor{" +
                "referenceName='" + referenceName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FieldDescriptor that = (FieldDescriptor) o;
        return Objects.equals(referenceName, that.referenceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(referenceName);
    }
}
