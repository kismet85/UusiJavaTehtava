package com.ismet;

import java.util.*;

public class Person {

    private String name;
    private int age;
    private String city;



    public Person(String name, int age, String city)
    {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Person: " +
                "name = " + name +
                ", age = " + age +
                ", city = " + city;
    }

    public static void main(String[] args) {
        String[] names = {"Spindleman", "Chatgptyoda", "Sulo", "sivusilmäilijä", "EmmaLotion", "partasäilöjä", "kaulamies", "420", "piraatti", "avutonPyöräilijä"};
        String[] cities = {"Espoo", "Vantaa", "Helsinki", "Tampere", "Turku"};


        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        ArrayList<Person> persons = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            String name = names[random.nextInt(names.length)];
            int age = random.nextInt(45) + 18;
            String city = cities[random.nextInt(cities.length)];

            Person person = new Person(name, age, city);
            persons.add(person);
        }

        persons.sort(Comparator.comparingInt(Person::getAge));

        String cityfilter = "";
        System.out.println("Syötä kaupunki millä filtteroidaan hakua:");
        System.out.println("1: Espoo");
        System.out.println("2: Vantaa");
        System.out.println("3: Helsinki");
        System.out.println("4: Tampere");
        System.out.println("5: Turku");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                cityfilter = "Espoo";
                break;
            case 2:
                cityfilter = "Vantaa";
                break;
            case 3:
                cityfilter = "Helsinki";
                break;
            case 4:
                cityfilter = "Tampere";
                break;
            case 5:
                cityfilter = "Turku";
                break;
            default:
                System.out.println("Ei syötetty mitään");
                break;
        }

        String finalCityfilter = cityfilter;
        persons.removeIf(person -> !person.getCity().equals(finalCityfilter));

        persons.forEach(System.out::println);
    }
}
