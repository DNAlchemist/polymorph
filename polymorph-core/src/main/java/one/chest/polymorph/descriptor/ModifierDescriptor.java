package one.chest.polymorph.descriptor;

public interface ModifierDescriptor {

    boolean isPublic();

    boolean isPrivate();

    boolean isProtected();

    boolean isNative();

    boolean isAbstract();

    boolean isFinal();

    boolean isStatic();

    boolean isStrictfp();

    boolean isDefault();

    boolean isSynchronized();

    boolean isTransient();

    boolean isVolatile();

}
