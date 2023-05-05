package io.namoosoru.chap05.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StreamAssist {

    static public class Customer {
        private String name;
        private int age;

        public Customer(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Customer customer = (Customer) o;
            return age == customer.age && Objects.equals(name, customer.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }


    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();

        customers.add(new Customer("Song",45));
        customers.add(new Customer("Kim",35));
        customers.add(new Customer("Park",21));
        customers.add(new Customer("Lee",67));
        customers.add(new Customer("Choi",19));

        customers.stream().filter(customer -> customer.getAge()>30).sorted(Comparator.comparing(Customer::getAge).reversed()).map(Customer::getName).forEach(System.out::println);
        customers.stream().filter(customer -> customer.getAge()>39).sorted(Comparator.comparing(Customer::getName)).map((customer) -> customer.getName()).forEach((str)->System.out.println(str));

       List<String> n1= customers.stream().filter(customer -> customer.getAge()>30).sorted(Comparator.comparing(Customer::getAge).thenComparing(Customer::getName)).map(Customer::getName).collect(Collectors.toCollection(ArrayList::new));
       String[] n2= customers.stream().filter(customer -> customer.getAge()>30).sorted(Comparator.comparing(Customer::getAge).thenComparing(Customer::getName)).map(Customer::getName).toArray(String[]::new);

        List<String> customers2 = customers.stream().filter(customer->customer.getAge()>30).map(Customer::getName).collect(Collectors.toList());

        customers.sort(Comparator.comparing(Customer::getAge));

        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(3);
        intList.add(2);
        intList.add(4);
        intList.add(6);
        intList.sort(Comparator.naturalOrder());

        String a = customers2.get(2);
        customers2.add("ss");
    }
}
