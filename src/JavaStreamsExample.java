import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.List;

public class JavaStreamsExample {
    static class Employee {
        public String getName() {
            return "xxx";
        }
        public int getSalary() {
            return 10;
        }
        public boolean isActive() {
            return true;
        }

        public String getId() {
            return "3245";
        }
    }

    public static void main(String[] args) {
        int[] numbers = { 7, 10, 50, 3, 2, 25, 76};
        int min1 = IntStream.of(numbers).min().getAsInt();
        System.out.println("Min using stream = " + min1);

        //IntStream.of(numbers).min().ifPresent(min -> System.out.println(min));

        //IntStream.of(numbers).min().ifPresent(System.out::println);
        //IntStream.of(numbers).forEach(System.out::println);
        System.out.println(IntStream.of(numbers).allMatch(num -> num%2 == 1));

        /*List<Employee> employeeList = new ArrayList<Employee>();
        List<Employee> nameList =
                employeeList.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .filter(employee -> isActive(employee))
                .limit(3)
                .map(Employee::getName)
                .forEach(System.out::println);*/

        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getSalary() - o2.getSalary();
            }
        };
        Comparator<Employee> comparator1 = (o1, o2) -> o1.getSalary() - o2.getSalary();
    }
}
