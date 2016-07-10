package by.epam.parsing.composite;

public interface Component{
    boolean add(Component component);
    Component getChild(int index);
    boolean remove(Component component);
    int getLexemeNumber();
    int getChildNumber();
}
