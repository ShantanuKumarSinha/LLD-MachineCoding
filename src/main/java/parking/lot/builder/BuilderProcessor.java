package parking.lot.builder;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.lang.model.util.Elements;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
//TODO
@SupportedAnnotationTypes("Builder")
@SupportedSourceVersion(SourceVersion.RELEASE_17)
public class BuilderProcessor extends AbstractProcessor {

    private Elements elementUtils;
    private Filer filer;
    private Messager messager;

/**
     * This method is called when the annotation processor is first created.
     * It is used to initialize the processor and set up any resources it needs.
     *
     * @param processingEnv The processing environment.
     */
    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        elementUtils = processingEnv.getElementUtils();
        filer = processingEnv.getFiler();
        messager = processingEnv.getMessager();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        // Get all the elements annotated with Builder
        for (Element element : roundEnv.getElementsAnnotatedWith(Builder.class)) {
            if (element.getKind() != ElementKind.CLASS) {
                messager.printMessage(javax.tools.Diagnostic.Kind.ERROR, "@Builder can only be applied to classes", element);
                continue;
            }
            TypeElement typeElement = (TypeElement) element;
            try {
                generateBuilderClass(typeElement);
            } catch (IOException e) {
                messager.printMessage(javax.tools.Diagnostic.Kind.ERROR, "Failed to generate builder: " + e.getMessage(), element);

            }

        }
        return true;  // Claim the annotation
    }

    private void generateBuilderClass(TypeElement typeElement) throws IOException {
        var packageName = elementUtils.getPackageOf(typeElement).getQualifiedName().toString();
        var className = typeElement.getSimpleName().toString();
        var builderClassName = className + "Builder";

        //Create the builder class
        JavaFileObject builderFile = filer.createSourceFile(packageName + "." + builderClassName);
        try (PrintWriter out = new PrintWriter(builderFile.openWriter())) {
            out.println("package " + packageName + ";");
            out.println();
            out.println("public class " + builderClassName + "{");
            out.println("private " + typeElement + "instance = new " + typeElement + "();");
            out.println();

            for (Element element : typeElement.getEnclosedElements()) {
                if (element.getKind() == ElementKind.FIELD && !element.getModifiers().contains(Modifier.STATIC)) {
                    var variableElement = (VariableElement) element;
                    var variableName = variableElement.getSimpleName().toString();
                    var variableType = variableElement.asType();

                    out.println("\tpublic " + builderClassName + " set" + capitializeFieldName(variableName) + " (" + variableType + " " + variableName + ") {\n\treturn this;\t}");

                }
            }
            // Generate build method
            out.println("    public " + className + " build() {");
            out.println("        return instance;");
            out.println("    }");
            out.println("}");
        }
    }

    private String capitializeFieldName(String variableName) {
        return variableName.substring(0, 1).toUpperCase() + variableName.substring(1);
    }

}
