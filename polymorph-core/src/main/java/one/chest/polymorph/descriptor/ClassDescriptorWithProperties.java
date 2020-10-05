package one.chest.polymorph.descriptor;

import java.util.HashSet;
import java.util.Set;

public final class ClassDescriptorWithProperties extends ClassDescriptor {

    private final Set<PropertyDescriptor> properties;

    public ClassDescriptorWithProperties(ClassDescriptor classDescriptor, Set<PropertyDescriptor> properties) {
        super(classDescriptor.getFields(), classDescriptor.getMethods());
        this.properties = new HashSet<>(properties);
    }

    public Set<PropertyDescriptor> getProperties() {
        return properties;
    }
}
