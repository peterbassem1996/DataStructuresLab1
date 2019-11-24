public class PolynomialDemoClass {
    public static void main(String[] args){
        PolynomialDataStrucClass p1 = new PolynomialDataStrucClass(4,3);
        p1.addPolyNode(3,2);
        p1.addPolyNode(-5,0);
        System.out.println("p1: " + p1);

        PolynomialDataStrucClass p2 = new PolynomialDataStrucClass(3,5);
        p2.addPolyNode(4,4);
        p2.addPolyNode(1,3);
        p2.addPolyNode(-4,2);
        p2.addPolyNode(4,1);
        p2.addPolyNode(2,0);
        System.out.println("p2: " + p2);

        System.out.println("p1 + p2: " + p1.addPolynomials(p2));

        System.out.println();

        PolynomialDataStrucClass p3 = new PolynomialDataStrucClass(5,0);
        p3.addPolyNode(3,2);
        p3.addPolyNode(4,3);
        System.out.println("p3: " + p3);

        PolynomialDataStrucClass p4 = new PolynomialDataStrucClass(-4,0);
        p4.addPolyNode(4,3);
        p4.addPolyNode(5,4);
        System.out.println("p4: " + p4);

        System.out.println("p1 + p2: " + p3.addPolynomials(p4));
    }
}
