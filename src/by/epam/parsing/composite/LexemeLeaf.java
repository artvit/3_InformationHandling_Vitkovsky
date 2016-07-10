package by.epam.parsing.composite;


public abstract class LexemeLeaf implements Component{

    @Override
    public boolean add(Component component) {
        return false;
    }

    @Override
    public Component getChild(int index) {
        return null;
    }

    @Override
    public boolean remove(Component component) {
        return false;
    }

    @Override
    public int getLexemeNumber() {
        return 1;
    }

    @Override
    public int getChildNumber() {
        return 1;
    }
}
