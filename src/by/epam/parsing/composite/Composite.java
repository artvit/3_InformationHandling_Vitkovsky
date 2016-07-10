package by.epam.parsing.composite;

import java.util.ArrayList;

public class Composite implements Component {
    private ArrayList<Component> components;

    public Composite() {
        components = new ArrayList<>();
    }

    @Override
    public boolean add(Component component) {
        return components.add(component);
    }

    @Override
    public Component getChild(int index) {
        return components.get(index);
    }

    @Override
    public boolean remove(Component component) {
        boolean result = false;
        if (!components.remove(component)) {
            Component removingComponent = null;
            for (Component currentComponent : components) {
                if (currentComponent.remove(component)) {
                    if (currentComponent.getLexemeNumber() == 0) {
                        removingComponent = component;
                    }
                    result = true;
                }
            }
            components.remove(removingComponent);
            return result;
        } else {
            return true;
        }
    }

    @Override
    public int getLexemeNumber() {
        return components.stream().mapToInt(Component::getLexemeNumber).sum();
    }

    @Override
    public int getChildNumber() {
        return components.size();
    }
}
