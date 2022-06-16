package employee;

public class Employee {

    private Integer id;
    private String name;
    private Double salary;

    public Employee(Integer id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void increaseSalary(double percentage) {
        salary += salary * percentage / 100.0;
    }

    public String toString() {
        return  id
                + ", "
                + name
                + ", R$"
                + String.format("%.2f", salary);
    }
}
