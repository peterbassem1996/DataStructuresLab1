public class PolynomialDataStrucClass implements PolynomialADT{
    private PolyNodeClass firstNode;

    public PolynomialDataStrucClass() {
        this.firstNode = null;
    }

    public PolynomialDataStrucClass(double coefficient, double exponent) {
        this.firstNode = new PolyNodeClass(coefficient, exponent, null);
    }

    public PolynomialDataStrucClass(PolynomialDataStrucClass p) {
        this.firstNode = p.getFirstNode();
    }

    public PolyNodeClass getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(PolyNodeClass firstNode) {
        this.firstNode = firstNode;
    }

    public boolean isEmpty(){
        return (this.firstNode == null);
    }

    public void addPolyNodeFirst(double coefficient, double exponent) {
        PolyNodeClass newNode = new PolyNodeClass(coefficient, exponent, this.firstNode);
        this.firstNode = newNode;
    }

    public void addPolyNodeLast(double coefficient, double exponent) {
        if(this.isEmpty()){
            addPolyNodeFirst(coefficient, exponent);
        }
        else {
            PolyNodeClass current = this.firstNode;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new PolyNodeClass(coefficient, exponent, null));
        }
    }

    public void addPolyNode(double coefficient, double exponent) {
        if(this.isEmpty()){
            addPolyNodeFirst(coefficient, exponent);
        }
        else {
            PolyNodeClass current = this.firstNode;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new PolyNodeClass(coefficient, exponent, null));
        }
    }

    public PolynomialDataStrucClass addPolynomials( PolynomialDataStrucClass pol2){
        PolynomialDataStrucClass newPol = new PolynomialDataStrucClass();
        PolyNodeClass p1;
        PolyNodeClass p2;
        PolyNodeClass p3 = null;
        for (int i = 0; i < 2; i++) {
            if (i==0){
                p1 = this.getFirstNode();
            }
            else{
                p1 = pol2.getFirstNode();
            }
            while (p1 != null) {
                newPol.addPolyNode(p1.getCoefficient(),p1.getExponent());
                p1 = p1.getNext();
            }
            p1 = newPol.getFirstNode();
            while (p1 != null) {
                p2 = p1;
                while(p2.getNext() != null){
                    if(p2.getNext().getExponent() == p1.getExponent()){
                        p1.setCoefficient(p1.getCoefficient()+p2.getNext().getCoefficient());
                        if(p2.getNext().getNext() == null){
                            p2.setNext(null);
                            break;
                        }
                        else{
                            p2.setNext(p2.getNext().getNext());
                        }
                    }
                    p2 = p2.getNext();
                }
                p1 = p1.getNext();
            }
        }
        return newPol;
    }

    public String toString(){
        PolyNodeClass current = this.getFirstNode();
        String returnedVal = "";
        while(current != null){
            if (current.getCoefficient() != 0) {
                if (current.getExponent() == 0) {
                    returnedVal += String.format("%.0f ", current.getCoefficient());
                }

                else if (current.getExponent() == 1) {
                    if (current.getCoefficient() == 1) {
                        returnedVal += String.format("X ");
                    }
                    else if(current.getCoefficient() == -1){
                        returnedVal += String.format("-X ");
                    }
                    else{
                        returnedVal += String.format("%.0fX ", current.getCoefficient());
                    }
                }

                else {
                    if (current.getCoefficient() == 1) {
                        returnedVal += String.format("X^%.0f ",  current.getExponent());
                    }
                    else if(current.getCoefficient() == -1){
                        returnedVal += String.format("-X^%.0f ", current.getExponent());
                    }
                    else{
                        returnedVal += String.format("%.0fX^%.0f ",current.getCoefficient(), current.getExponent());
                    }

                }
                current = current.getNext();
                if(current != null){
                    if(current.getCoefficient() > 0) {
                        returnedVal += "+";
                    }
                }
            }
        }
        return returnedVal;
    }
}
