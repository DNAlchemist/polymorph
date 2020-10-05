package one.chest.polymorph.processor;

import one.chest.polymorph.PropertyLocator;
import one.chest.polymorph.annotation.WithConverter;
import one.chest.polymorph.descriptor.*;
import one.chest.polymorph.strategy.GetterPropertyModelStrategy;
import one.chest.polymorph.strategy.PropertyModelStrategy;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes(
        "one.chest.polymorph.annotation.WithConverter"
)
public class ConverterAnnotationProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element annotatedElement : roundEnv.getElementsAnnotatedWith(WithConverter.class)) {
            if (annotatedElement instanceof TypeElement) {
                TypeElement typeElement = (TypeElement) annotatedElement;
                for (Element element : typeElement.getEnclosedElements()) {
                    processingEnv.getMessager().printMessage(Diagnostic.Kind.WARNING, element.toString());
                }
                ClassDescriptor classDescriptor = parseClass(typeElement);
                PropertyModelStrategy propertyModelStrategy = new GetterPropertyModelStrategy();
                Set<PropertyDescriptor> properties = propertyModelStrategy.locateProperties(classDescriptor)
                    .properties(classDescriptor);

            }
        }
        return false;
    }

    public ClassDescriptor parseClass(TypeElement typeElement) {
        Set<FieldDescriptor> fields = new HashSet<>();
        Set<MethodDescriptor> methods = new HashSet<>();

        for (Element element : typeElement.getEnclosedElements()) {
            switch (element.getKind()) {
                case FIELD:
                    fields.add(fieldDescriptorFrom(element));
                    break;
                case METHOD:
                    methods.add(methodDescriptorFrom(element));
                    break;
                case CONSTRUCTOR:
                    processingEnv.getMessager().printMessage(
                            Diagnostic.Kind.WARNING,
                            String.format("Constructor is not supported yet: %s", element)
                    );
                    break;
                case PACKAGE:
                case ENUM:
                case CLASS:
                case ANNOTATION_TYPE:
                case INTERFACE:
                case ENUM_CONSTANT:
                case PARAMETER:
                case LOCAL_VARIABLE:
                case EXCEPTION_PARAMETER:
                case STATIC_INIT:
                case INSTANCE_INIT:
                case TYPE_PARAMETER:
                case OTHER:
                case RESOURCE_VARIABLE:
                default:
                    throw new UnsupportedOperationException(String.valueOf(element.getKind()));
            }
        }
        return new ClassDescriptor(fields, methods);
    }

    private MethodDescriptor methodDescriptorFrom(Element element) {
        Set<Modifier> modifiers = element.getModifiers();
        assert modifiers != null;
        return new MethodDescriptor(
                element.getSimpleName().toString(),
                modifiers.stream().map(Modifier::name).map(SourceModifier::valueOf).collect(Collectors.toSet())
        );
    }

    private FieldDescriptor fieldDescriptorFrom(Element element) {
        Set<Modifier> modifiers = element.getModifiers();
        assert modifiers != null;
        return new FieldDescriptor(
                element.getSimpleName().toString(),
                modifiers.stream().map(Modifier::name).map(SourceModifier::valueOf).collect(Collectors.toSet())
        );
    }
}
