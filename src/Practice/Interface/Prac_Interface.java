package Practice.Interface;

public class Prac_Interface implements Height {
    private double cm =0;

    public Prac_Interface(double cm) {
        this.cm = cm;
    }


    @Override
    public double getInch() {
        return cm/INCH;
    }

    @Override
    public double getCM() {
        return cm;
    }

    @Override
    public double getMeter() {
        return cm/100;
    }

    public static void main(String[] args) {
        Prac_Interface myHeight = new Prac_Interface(183);

        System.out.println(myHeight.getCM() + " cm");
        System.out.println(myHeight.getInch() + " inch");
        System.out.println(myHeight.getMeter() + " meter");
    }
}
