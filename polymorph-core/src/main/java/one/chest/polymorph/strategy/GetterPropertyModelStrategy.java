package one.chest.polymorph.strategy;

import one.chest.polymorph.PropertyLocator;
import one.chest.polymorph.PropertyLocators;
import one.chest.polymorph.descriptor.ClassDescriptor;

public class GetterPropertyModelStrategy implements PropertyModelStrategy {

    @Override
    public PropertyLocator locateProperties(ClassDescriptor classDescriptor) {
        return PropertyLocators.getter();
    }
}
