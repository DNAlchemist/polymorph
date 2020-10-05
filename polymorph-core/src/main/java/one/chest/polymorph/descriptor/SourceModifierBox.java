package one.chest.polymorph.descriptor;

import java.util.Set;

public class SourceModifierBox {

    private final Set<SourceModifier> modifiers;

    public SourceModifierBox(Set<SourceModifier> modifiers) {
        this.modifiers = modifiers;
    }

    public static SourceModifierBox of(Set<SourceModifier> modifiers) {
        return new SourceModifierBox(modifiers);
    }

    boolean isPublic() {
        return modifiers.contains(SourceModifier.PUBLIC);
    }

    boolean isPrivate() {
        return modifiers.contains(SourceModifier.PRIVATE);
    }

    boolean isProtected() {
        return modifiers.contains(SourceModifier.PROTECTED);
    }

    boolean isNative() {
        return modifiers.contains(SourceModifier.NATIVE);
    }

    boolean isAbstract() {
        return modifiers.contains(SourceModifier.ABSTRACT);
    }

    boolean isFinal() {
        return modifiers.contains(SourceModifier.FINAL);
    }

    boolean isStatic() {
        return modifiers.contains(SourceModifier.STATIC);
    }

    boolean isStrictfp() {
        return modifiers.contains(SourceModifier.STRICTFP);
    }

    boolean isDefault() {
        return modifiers.contains(SourceModifier.DEFAULT);
    }

    boolean isSynchronized() {
        return modifiers.contains(SourceModifier.SYNCHRONIZED);
    }

    boolean isTransient() {
        return modifiers.contains(SourceModifier.TRANSIENT);
    }

    boolean isVolatile() {
        return modifiers.contains(SourceModifier.VOLATILE);
    }

}
