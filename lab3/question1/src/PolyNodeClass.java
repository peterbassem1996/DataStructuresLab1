public class PolyNodeClass {
    private double coefficient;
    private double exponent;
    private PolyNodeClass next;

    public PolyNodeClass() {
        this.coefficient = 0;
        this.exponent = 0;
        this.next = null;
    }

    public PolyNodeClass(double coefficient, double exponent, PolyNodeClass next) {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.next = next;
    }

    public PolyNodeClass(PolyNodeClass p) {
        this.coefficient = p.getCoefficient();
        this.exponent = p.getExponent();
        this.next = p.getNext();
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public double getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    public PolyNodeClass getNext() {
        return next;
    }

    public void setNext(PolyNodeClass next) {
        this.next = next;
    }
}
