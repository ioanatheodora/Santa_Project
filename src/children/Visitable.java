package children;

import santa.Visitor;

public interface Visitable {
    /**
     * This method is implemented to assure double dispatch and the Visitor Design Pattern
     * @param v Visitor
     */
    Double accept(Visitor v);
}
