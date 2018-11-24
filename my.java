package org.haughki.cli;

import javafx.util.Pair;

import java.util.*;

public class Main {
    public static void main(String[] args) {

/*
        List<? extends List<?>> list = new LinkedList<List<Integer>>();
        List<List<?>> list2 = new LinkedList<>();
        list.add(list2);
*/


        // ERROR: parameterized types don't support inheritance.
        // Here, you *must* pass a List of Object.
        //acceptListOfObject(new ArrayList<String>());
        acceptListOfObject(new ArrayList<Object>());


        List<String> listString = new ArrayList<>();
        List<Integer> listInteger = new ArrayList<>();
        acceptListOfAnyType(listString);
        acceptListOfAnyType(listInteger);
        acceptListOfAnyWildType(listString);
        acceptListOfAnyWildType(listInteger);

        // ERROR: again, parameterized types don't support inheritance.
        // Even tho ArrayList is a subtype of List, this won't work.
        //List<ArrayList<String>> listOfArrayList = new ArrayList<>();
        //acceptListOfList(listOfArrayList);

        List<List<String>> listOfList = new ArrayList<>();
        acceptListOfList(listOfList);


        Map<String, String> mapOfString = new HashMap<>();
        Map<String, List<?>> mapOfListOfAnyType = new HashMap<>();
        mapOfListOfAnyType.put("k1", new ArrayList<String>());
        mapOfListOfAnyType.put("k2", new ArrayList<Integer>());

        Map<String, List<String>> mapOfListOfString = new HashMap<>();
        Map<String, List<Integer>> mapOfListOfInteger = new HashMap<>();

        acceptMapOfListOfAnyType(mapOfListOfAnyType);
        // ERROR: List is of a specific type, not _any_ type
        //acceptMapOfListOfAnyType(mapOfListOfString);

        SortedSet

        acceptMapOfListOfSpecifiedType(mapOfListOfString);
        acceptMapOfListOfSpecifiedType(mapOfListOfInteger);
        // ERROR: List is of _any_ type, not a specific,
        // parameterized type. Doesn't specify the type in the List<>.
        //acceptMapOfListOfSpecifiedType(mapOfListOfAnyType);


        acceptMapOfAnyType(mapOfListOfInteger);
        acceptMapOfAnyType(mapOfListOfAnyType);
        acceptMapOfAnyType(mapOfString);  // really, anything

        acceptMapOfAnySubtypeOfListOfAnyType(mapOfListOfString);
        acceptMapOfAnySubtypeOfListOfAnyType(mapOfListOfAnyType);


        // ERROR: Signature wants a Map that can take a List of any type.
        // Here, we're trying to pass a Map that can only take Lists over Strings.
        //acceptMapOfListOfExtendsObject(mapOfListOfString);


        Collection<Pair<String, ?>> pairs = new ArrayList<>();
        pairs.add(new Pair<String, String>("k", "v"));
        pairs.add(new Pair<String, Integer>("k", 1));
    }

    public static void acceptListOfObject(List<Object> aList) {
    }

    public static <T> void acceptListOfAnyType(List<T> aList) {
    }

    public static void acceptListOfAnyWildType(List<?> aList) {
    }

    public static <T> void acceptListOfList(List<List<T>> aListOfList) {
    }

    public static void acceptMapOfListOfAnyType(Map<String, List<?>> multiMap) {
        multiMap.put("Dates", new ArrayList<>(Arrays.<Date>asList(new Date())));
    }

    public static <T> void acceptMapOfListOfSpecifiedType(Map<String, List<T>> multiMap) {
    }

    public static void acceptMapOfAnyType(Map<String, ?> multiMap) {
    }

    public static void acceptMapOfAnySubtypeOfListOfAnyType(Map<String, ? extends List<?>> multiMap) {
        List<?> listOfAny = new ArrayList<>();
        //new ArrayList<>(Arrays.<Date>asList(new Date()))
        ArrayList<String> strings = new ArrayList<>();
        multiMap.put("Dates", strings);
    }

    public static <T> void acceptMapOfAnySubtypeOfListOfSpecifiedType(Map<String, ? extends List<T>> multiMap) {
    }

    public static void acceptMapOfListOfExtendsObject(Map<String, List<? extends Object>> multiMap) {
    }

    public static void collection(Collection<Pair<String, ?>> pairs) {

    }
}
