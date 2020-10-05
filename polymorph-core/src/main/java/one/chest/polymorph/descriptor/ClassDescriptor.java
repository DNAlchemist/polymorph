package one.chest.polymorph.descriptor;

import java.util.HashSet;
import java.util.Set;

public class ClassDescriptor {

    private final Set<FieldDescriptor> fields;
    private final Set<MethodDescriptor> methods;

    public ClassDescriptor(Set<FieldDescriptor> fields, Set<MethodDescriptor> methods) {
        this.fields = new HashSet<>(fields);
        this.methods = new HashSet<>(methods);
    }

    public Set<FieldDescriptor> getFields() {
        return this.fields;
    }

    public Set<MethodDescriptor> getMethods() {
        return this.methods;
    }
}
