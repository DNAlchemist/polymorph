package one.chest.polymorph;

import one.chest.polymorph.descriptor.ClassDescriptor;
import one.chest.polymorph.descriptor.MethodDescriptor;
import one.chest.polymorph.descriptor.PropertyDescriptor;

import java.util.Set;
import java.util.stream.Collectors;

public final class PropertyLocators {

    private PropertyLocators() {

    }

    public static PropertyLocator getter() {
        return new PropertyLocator() {
            @Override
            public Set<PropertyDescriptor> properties(ClassDescriptor classDescriptor) {
                return classDescriptor.getMethods()
                        .stream()
                        .filter(MethodDescriptor::isPublic)
                        .filter(methodDescriptor -> isGetterName(methodDescriptor.getReferenceName()))
                        .map(this::getPropertyDescriptorFromGetter)
                        .collect(Collectors.toSet());
            }

            private PropertyDescriptor getPropertyDescriptorFromGetter(MethodDescriptor descriptor) {
                return new PropertyDescriptor(getPropertyNameFromGetter(descriptor.getReferenceName()), descriptor);
            }

            private String getPropertyNameFromGetter(String referenceName) {
                return referenceName.substring(3, 4).toLowerCase() + referenceName.substring(4);
            }

            private boolean isGetterName(String referenceName) {
                assert referenceName != null;
                return referenceName.startsWith("get") && isCapital(referenceName.substring(4, 4));
            }

            private boolean isCapital(String letter) {
                return letter.toUpperCase().equals(letter);
            }
        };
    }
}
