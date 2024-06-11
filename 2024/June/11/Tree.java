import java.util.ArrayList;
import java.util.List;

public class Tree<E> {

    public Tree<E> parent;
    public E item;
    private List<Tree<E>> children;

    public Tree(E item) {
        this.parent = null;
        this.item = item;
        children = new ArrayList<Tree<E>>();
    }

    public void addChild(Tree<E> tree) {
        children.add(tree);
        tree.parent = this;
    }

    public void addChild(int index, Tree<E> tree) {
        children.add(index, tree);
        tree.parent = this;
    }

    public Tree<E> removeChild(int index) {
        Tree<E> child = children.remove(index);
        child.parent = null;
        return child;
    }

    public Tree<E> getChild(int index) {
        return children.get(index);
    }

    public int childrenCount() {
        return children.size();
    }

    public int size() {
        return 0;
    }

}
