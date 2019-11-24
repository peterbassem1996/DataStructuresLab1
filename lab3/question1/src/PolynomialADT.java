public interface PolynomialADT {
    public abstract PolyNodeClass getFirstNode();
    public abstract boolean isEmpty();
    public abstract void addPolyNodeFirst(double coefficient, double exponent);
    public abstract void addPolyNodeLast(double coefficient, double exponent);
    public abstract void addPolyNode(double coefficient, double exponent);
    public abstract PolynomialDataStrucClass addPolynomials( PolynomialDataStrucClass pol2);
    public abstract String toString();
    }
