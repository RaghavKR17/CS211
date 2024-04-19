/*
Name: Raghav Krishna Ranganathan
ID: 203035901
*/

import java.util.*;

public class CP4 {

    static HashSet<String> CS210 = new HashSet<String>();
    static HashSet<String> CS211 = new HashSet<String>();
    static HashSet<String> CS212 = new HashSet<String>();
    
    public static void Initialize() {
        
        CS210.add("Bill"); CS210.add("Eva"); CS210.add("Olivia");
        CS211.add("Eva"); CS211.add("Olivia"); CS211.add("Kim");   
        CS212.add("Chloe"); CS212.add("Jane"); CS212.add("Olivia"); CS212.add("Bill");    
    }
    
    public static void atLeastOneClass() {
        HashSet<String> result = new HashSet<>(CS210);
        result.addAll(CS211);
        result.addAll(CS212);
        System.out.println("at least one class: " + result);
    }

    public static void allClasses() {
        HashSet<String> result = new HashSet<>(CS210);
        result.retainAll(CS211);
        result.retainAll(CS212);
        System.out.println("CS 210 and CS 211 and CS 212: " + result);
    }

    public static void violation() {
        HashSet<String> result = new HashSet<>(CS211);
        result.removeAll(CS210);
        System.out.println("CS211 without taking CS 210: " + result);
    }

    public static void CS210andCS211notCS212Classes() {
        HashSet<String> result = new HashSet<>(CS210);
        result.retainAll(CS211);
        result.removeAll(CS212);
        System.out.println("CS 210 and CS 211 but not CS 212: " + result);
    }
    
    public static void main(String[] args) {
        Initialize();
        atLeastOneClass();
        allClasses();
        violation();
        CS210andCS211notCS212Classes();
    }
}
