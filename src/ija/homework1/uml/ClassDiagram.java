package ija.homework1.uml;

import java.util.ArrayList;
import java.util.List;

public class ClassDiagram extends Element {
    private final List<UMLClassifier> classArr = new ArrayList<>();

    public ClassDiagram(String name) {
        super(name);
    }

    public UMLClass createClass(String name) {
        for (UMLClassifier c : this.classArr) {
            if (c.getName().equals(name)) {
                return null;
            }
        }
        UMLClass newClass = new UMLClass(name);
        classArr.add(newClass);
        return newClass;
    }

    public UMLClassifier classifierForName(String name) {
        for (UMLClassifier umlClassifier : this.classArr)
            if (name.equals(umlClassifier.getName())) {
                return umlClassifier;
            }
        UMLClassifier newClass = UMLClassifier.forName(name);
        classArr.add(newClass);
        return newClass;
    }

    public UMLClassifier findClassifier(String name) {
        for (UMLClassifier c : this.classArr) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }
}
