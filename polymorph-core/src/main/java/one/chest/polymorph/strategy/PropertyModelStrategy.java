package one.chest.polymorph.strategy;

import one.chest.polymorph.PropertyLocator;
import one.chest.polymorph.descriptor.ClassDescriptor;

public interface PropertyModelStrategy {
    PropertyLocator locateProperties(ClassDescriptor classDescriptor);
}
