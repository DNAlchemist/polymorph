package one.chest.polymorph;

import one.chest.polymorph.descriptor.ClassDescriptor;
import one.chest.polymorph.descriptor.PropertyDescriptor;

import java.util.Queue;
import java.util.Set;

public abstract class PropertyLocator {

    private Queue<PropertyLocator> chain;

    public abstract Set<PropertyDescriptor> properties(ClassDescriptor classDescriptor);

    public PropertyLocator and(PropertyLocator propertyLocator) {
        chain.add(propertyLocator);
        return this;
    }
}
