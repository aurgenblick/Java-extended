package Patterns_CompositeInterpreterVisitor;

import java.util.*;

class Employee {

    private String name;
    private double salary;
    protected final String indentation = "   ";

    public Employee(String n, double s) {
        name = n;
        salary = s;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public final boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (!(other instanceof Employee)) return false;
        Employee e = (Employee) other;
        return name.equals(e.name);
    }

    public final int hashCode() {
        return name.hashCode();
    }

    public void accept(Visitor visitor, String indent) {
        visitor.visit(this, indent);
    }

    public void prettyPrint(String indent) {
        System.out.println(indent + this.getName() + " (" + this.getSalary() + ")" + this.getClass());
    }

}


class Manager extends Employee {

    private double bonus;
    private List<Employee> subs = new ArrayList<Employee>();

    public Manager(String n, double s, Employee[] es) {
        super(n, s);
        bonus = 0;
        if (es != null) {
            for (Employee e : es) {
                add(e);
            }
        }
    }

    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double b) {
        bonus = b;
    }

    public void add(Employee sub) {
        if (!subs.contains(sub)) {
            subs.add(sub);
        }
    }

    public void remove(Employee sub) {
        subs.remove(sub);
    }

    @Override
    public void accept(Visitor visitor, String indent) {
        visitor.visit(this, indent);
        /**??? In contrast to BoolDemo2 example, there's no need to pass the visit method to the child classes here**/
//        for (Employee e : subs) {
//            e.accept(visitor, indent+indentation);
//        }
    }

    @Override
    public void prettyPrint(String indent) {
        System.out.println(indent + this.getName() + " (" + this.getSalary() + ")" + this.getClass());
        for (Employee e : subs) {
            String subIndent = indent + indentation;
            e.prettyPrint(subIndent);
        }
    }
}
