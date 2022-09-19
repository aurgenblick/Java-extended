package Patterns_CompositeInterpreterVisitor;

class Visitor {
    public void visit(Employee e, String indent) {
    }

    public void visit(Manager em, String indent) {
    }


    public static void main(String[] args) {
        final String initialIndent = "";
        Manager CEO = new Manager("Alice", 1, new Employee[]
                {new Manager("Erin", 200000, new Employee[]
                        {new Employee("Frank", 30000)}),
                        new Employee("Bob", 40000),
                        new Manager("Dan", 100000, null),
                        new Employee("Carlos", 50000)
                });
        CEO.setBonus(1000000);
        // Should print the following (note indentation is three spaces!):
        // Alice (1000001.0) Manager
        //    Erin (200000.0) Manager
        //       Frank (30000.0) Employee
        //    Bob (40000.0) Employee
        //    Dan (100000.0) Manager
        //    Carlos (50000.0) Employee
        CEO.accept(new PrettyPrintVisitor(), initialIndent);
    }
}

class PrettyPrintVisitor extends Visitor {
    /**
     * Visit operation here provides printing of the calling Employee's sub-hierarchy .
     **/
    protected String indentation = "   ";

    //Had to implement prettyPrint in Employee class since 'subs' are private .
    public void prettyPrint(Employee e, String indent) {
        System.out.println(indent + e.getName() + " (" + e.getSalary() + ") " + e.getClass().toString().substring(e.getClass().toString().lastIndexOf('.') + 1));
    }

    @Override
    public void visit(Employee e, String indent) {
        //System.out.println(indent + e.getName() + " (" + e.getSalary() + ") " + e.getClass());
        prettyPrint(e, (indent+indentation));
    }

    @Override
    public void visit(Manager em, String indent) {
        //System.out.println(indent + e.getName() + " (" + e.getSalary() + ") " + e.getClass());
        prettyPrint(em, indent);
        if (!em.emptySubs) {
            indentation = indentation + indentation;
        }
    }
}