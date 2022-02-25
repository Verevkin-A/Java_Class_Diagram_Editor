package ija.homework1.uml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UMLOperation extends UMLAttribute{
    private final List<UMLAttribute> args;

    public UMLOperation(String name, UMLClassifier type) {
        super(name, type);
        this.args = new ArrayList<>();
    }

    public static UMLOperation create(String name, UMLClassifier type, UMLAttribute... args) {
        UMLOperation newOp = new UMLOperation(name, type);
        for(UMLAttribute a: args) {
            newOp.addArgument(a);
        }
        return newOp;
    }

    public boolean addArgument(UMLAttribute arg) {
        for(UMLAttribute a : this.args) {
            if (a.getName().equals(arg.getName())) {
                return false;
            }
        }
        this.args.add(arg);
        return true;
    }

    public List<UMLAttribute> getArguments() {
        return Collections.unmodifiableList(this.args);
    }
}
