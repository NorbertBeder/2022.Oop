package lab10_2;

import java.util.Comparator;

public class Lab10Main2 {
    public static void main(String[] args) {
        Company company = new Company("FirstComp");
        company.hireAll("company.csv");
        company.printAll(System.out);

        System.out.println();
        System.out.println("Alphabetically:");
        System.out.println();

        company.sortByComparator(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if(o1.getFirstName().equals(o2.getFirstName())){
                    return o1.getLastName().compareTo(o2.getLastName());
                }
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
        });
        company.printAll(System.out);

        System.out.println();
        System.out.println("By salary:");
        System.out.println();

        company.sortByComparator(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) (o1.getSalary() - o2.getSalary());
            }
        });
        company.printAll(System.out);

        System.out.println();
        System.out.println("Managers first then alphabetically");
        System.out.println();

        company.sortByComparator(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getClass().equals(o2.getClass())) {
                    if (o1.getFirstName().equals(o2.getFirstName())) {
                        return o1.getLastName().compareTo(o2.getLastName());
                    }
                    return o1.getFirstName().compareTo(o2.getFirstName());
                } else if (o1 instanceof Manager) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        company.printAll(System.out);
    }
}
