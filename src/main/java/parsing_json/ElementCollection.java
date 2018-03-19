package parsing_json;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ElementCollection extends ArrayList<Element> {

    public Element findByAtomicNumber(int atomic_number) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getNumber() == atomic_number) {
                return this.get(i);
            }
        }
        return null;
    }

    public Element findByName(String name) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getName().equals(name)) {
                return this.get(i);
            }
        }
        return null;
    }

    public ElementCollection where(String fieldName, Object value) {
        ElementCollection elementCollection = new ElementCollection();

        for (int i = 0; i < elementCollection.size(); i++) {
            if (elementCollection.get(i).getClass().getDeclaredFields().equals(fieldName)){
                for (int j = 0; j < elementCollection.size(); j++) {
                    if (elementCollection.get(i) == value) {
                        return elementCollection;
                    }
                }
            }
        }
        return null;
    }
}
