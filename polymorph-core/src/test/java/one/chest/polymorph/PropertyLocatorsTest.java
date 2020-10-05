package one.chest.polymorph;

import one.chest.polymorph.descriptor.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class PropertyLocatorsTest {

    @Test
    void getter() {
        ClassDescriptor classDescriptor = new ClassDescriptor(
                setOf(
                        new FieldDescriptor("property", setOf(SourceModifier.PRIVATE)),
                        new FieldDescriptor("privateProperty", setOf(SourceModifier.PRIVATE))
                ),
                setOf(new MethodDescriptor("getProperty", setOf(SourceModifier.PUBLIC)))
        );
        Set<PropertyDescriptor> expected = setOf(
                new PropertyDescriptor("property", new MethodDescriptor("getProperty", setOf(SourceModifier.PUBLIC)))
        );
        Set<PropertyDescriptor> was = PropertyLocators.getter().properties(classDescriptor);
        Assertions.assertEquals(expected, was);
    }

    @SafeVarargs
    private final <T> Set<T> setOf(T... args) {
        return new HashSet<>(Arrays.asList(args));
    }
}