package io.namoosoru.chap05.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAssist {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();

        customers.add(new Customer("Song",45));
        customers.add(new Customer("Kim",35));
        customers.add(new Customer("Park",21));
        customers.add(new Customer("Lee",67));
        customers.add(new Customer("Choi",19));

        customers.stream().filter(customer -> customer.getAge()>30).sorted(Comparator.comparing(Customer::getAge).reversed()).map(Customer::getName).forEach(System.out::println);
        customers.stream().filter(customer -> customer.getAge()>39).sorted(Comparator.comparing(Customer::getName)).map((customer) -> customer.getName()).forEach((str)->System.out.println(str));
        List<String> customers2 = customers.stream().filter(customer->customer.getAge()>30).map(Customer::getName).collect(Collectors.toList());
        String a = customers2.get(2);
        customers2.add("ss");
    }
}
