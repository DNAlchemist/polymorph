package one.chest.polymorph.descriptor;

import java.util.Collections;
import java.util.Objects;

public class PropertyDescriptor extends SourceDescriptor {

    private final String propertyName;
    private final SourceDescriptor source;

    public PropertyDescriptor(String propertyName, SourceDescriptor source) {
        super(Collections.emptySet());
        this.propertyName = propertyName;
        this.source = source;
    }

    @Override
    public boolean isPublic() {
        return true;
    }

    @Override
    public boolean isPrivate() {
        return false;
    }

    @Override
    public boolean isProtected() {
        return false;
    }

    @Override
    public boolean isNative() {
        return false;
    }

    @Override
    public boolean isAbstract() {
        return false;
    }

    @Override
    public boolean isFinal() {
        return false;
    }

    @Override
    public boolean isStatic() {
        return false;
    }

    @Override
    public boolean isStrictfp() {
        return false;
    }

    @Override
    public boolean isDefault() {
        return false;
    }

    @Override
    public boolean isSynchronized() {
        return false;
    }

    @Override
    public boolean isTransient() {
        return false;
    }

    @Override
    public boolean isVolatile() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropertyDescriptor that = (PropertyDescriptor) o;
        return Objects.equals(propertyName, that.propertyName) &&
                Objects.equals(source, that.source);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propertyName, source);
    }

    @Override
    public String toString() {
        return "PropertyDescriptor{" +
                "propertyName='" + propertyName + '\'' +
                ", source=" + source +
                '}';
    }
}
