package one.chest.polymorph.descriptor;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

public class MethodDescriptor extends SourceDescriptor implements ReferenceDescriptor {

    private final String name;

    public MethodDescriptor(String name, Set<SourceModifier> modifiers) {
        super(modifiers);
        this.name = name;
    }

    @Override
    public String getReferenceName() {
        return name;
    }

    @Override
    public String toString() {
        return "MethodDescriptor{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MethodDescriptor that = (MethodDescriptor) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
