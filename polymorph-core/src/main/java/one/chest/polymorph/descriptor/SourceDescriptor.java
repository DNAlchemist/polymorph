package one.chest.polymorph.descriptor;

import java.util.Set;

public abstract class SourceDescriptor implements ModifierDescriptor {

    private final SourceModifierBox modifierBox;

    public SourceDescriptor(Set<SourceModifier> modifiers) {
        this(SourceModifierBox.of(modifiers));
    }

    public SourceDescriptor(SourceModifierBox modifierBox) {
        this.modifierBox = modifierBox;
    }

    @Override
    public boolean isPublic() {
        return modifierBox.isPublic();
    }

    @Override
    public boolean isPrivate() {
        return modifierBox.isPrivate();
    }

    @Override
    public boolean isProtected() {
        return modifierBox.isProtected();
    }

    @Override
    public boolean isNative() {
        return modifierBox.isNative();
    }

    @Override
    public boolean isAbstract() {
        return modifierBox.isAbstract();
    }

    @Override
    public boolean isFinal() {
        return modifierBox.isFinal();
    }

    @Override
    public boolean isStatic() {
        return modifierBox.isStatic();
    }

    @Override
    public boolean isStrictfp() {
        return modifierBox.isStrictfp();
    }

    @Override
    public boolean isDefault() {
        return modifierBox.isDefault();
    }

    @Override
    public boolean isSynchronized() {
        return modifierBox.isSynchronized();
    }

    @Override
    public boolean isTransient() {
        return modifierBox.isTransient();
    }

    @Override
    public boolean isVolatile() {
        return modifierBox.isVolatile();
    }

}
