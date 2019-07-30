package Practice.Abstract;

abstract class Employee {
    String name;

    public abstract int income();

    public Employee(String n) {
        name = n;
    }

    public void getInformation() {
        System.out.println("¿Ã∏ß : " + name + ", ø¨∫¿ : " + income());
    }
}
