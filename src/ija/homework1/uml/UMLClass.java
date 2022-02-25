package ija.homework1.uml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UMLClass extends UMLClassifier{
    private boolean isAbstract;
    private final List<UMLAttribute> attrArr = new ArrayList<>();

    public UMLClass(String name) {
        super(name);
        this.isAbstract = false;
    }

    public boolean isAbstract() {
        return isAbstract;
    }

    public void setAbstract(boolean isAbstract) {
        this.isAbstract = isAbstract;
    }

    public boolean addAttribute(UMLAttribute attr) {
        for(UMLAttribute a : this.attrArr) {
            if (a.getName().equals(attr.getName())) {
                return false;
            }
        }
        this.attrArr.add(attr);
        return true;
    }

    public int getAttrPosition(UMLAttribute attr) {
        for(int i = 0; i < attrArr.size(); i++) {
            if(attr.equals(attrArr.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public int moveAttrAtPosition(UMLAttribute attr, int pos) {
        boolean found = false;
        int i;
        for(i = 0; i < attrArr.size(); i++) {
            if(attr.equals(attrArr.get(i))) {
                found = true;
                break;
            }
        }
        if (found) {
            UMLAttribute temp = attrArr.get(i);
            this.attrArr.remove(i);
            this.attrArr.add(pos, temp);
            return 0;
        } else {
            return -1;
        }
    }

    public List<UMLAttribute> getAttributes() {
        return Collections.unmodifiableList(this.attrArr);
    }
}
