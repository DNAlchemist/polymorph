package one.chest.polymorph;

import one.chest.polymorph.descriptor.ClassDescriptor;
import one.chest.polymorph.descriptor.PropertyDescriptor;

@FunctionalInterface
public interface Locator {
    public PropertyDescriptor apply(ClassDescriptor classDescriptor);
}
