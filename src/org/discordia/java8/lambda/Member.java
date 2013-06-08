package org.discordia.java8.lambda;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * This is (kinda) from Oracles Java 8 docs about lambdas:
 * http://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#approach7
 *
 * @author robban
 */
public class Member {

    public enum Sex {
        MALE, FEMALE
    }

    private final String name;
    private final int age;
    private final Sex gender;
    private final String emailAddress;


    public Member(String name, Sex gender, int age, String emailAddress) {

        this.name = name;
        this.gender = gender;
        this.age = age;
        this.emailAddress = emailAddress;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Sex getGender() {
        return gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public static void processMembersWithFunction(
            List<Member> roster,
            Predicate<Member> tester,
            Function<Member, String> mapper,
            Consumer<String> block
    ) {
        for (Member p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }


    public static void main(String[] args) {
        List<Member> members = new ArrayList<>();


        members.add(new Member("Pelle", Sex.MALE, 12, "pelle@gmail.com"));
        members.add(new Member("Johan", Sex.MALE, 42, "johan@gmail.com"));
        members.add(new Member("Katja", Sex.FEMALE, 22, "katja@gmail.com"));
        members.add(new Member("Lisa", Sex.FEMALE, 52, "lisa@gmail.com"));


        for (Sex gender : Sex.values()) {
            System.out.println("All " + gender + ":");
            Member.processMembersWithFunction(
                    members,
                    p -> p.getGender() == gender,
                    Member::getName,
                    System.out::println);
        }

        System.out.println("All FEMALE over 30:");
        Member.processMembersWithFunction(
                members,
                p -> p.getGender() == Sex.FEMALE &&
                p.getAge() > 30,
                Member::getName,
                System.out::println);
    }

}
