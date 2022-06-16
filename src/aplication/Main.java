package aplication;

import employee.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos funcionários gostaria de registrar? ");
        int n = sc.nextInt();
        System.out.println();

        List<Employee> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.println("Funcionário #" + i + ": ");

            System.out.print("ID: ");
            Integer id = sc.nextInt();
            while (hasId(list, id)) {
                System.out.println("Código existente, tente novamente!: ");
                id = sc.nextInt();
            }

            System.out.print("Nome: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Salário: ");
            double salary = sc.nextDouble();
            System.out.println();

            Employee emb = new Employee(id, name, salary);
            list.add(emb);
        }

        System.out.print("Ponha o ID correspondente ao funcionário que irá receber o aumento no salário: ");
        int idSalary = sc.nextInt();

        Integer pos = position(list, idSalary);
        if (pos == null) {
            System.out.println("Esse ID não existe!! ");
        } else {
            System.out.print("Qual a porcentagem de aumento? ");
            double percent = sc.nextDouble();
            list.get(pos).increaseSalary(percent);
        }

        System.out.println();
        System.out.println("Lista de Funcionários: ");
        for (Employee emb : list) {
            System.out.println(emb);
        }
    }
    public static Integer position(List <Employee> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return null;
    }

    public static boolean hasId(List<Employee> list, int id) {
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;
    }
}
