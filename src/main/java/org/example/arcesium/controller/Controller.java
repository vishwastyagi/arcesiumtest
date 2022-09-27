package org.example.arcesium.controller;

import org.example.arcesium.service.Service;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    public static void main(String[] args) throws IllegalAccessException {
        Service service = new Service();
        List<String> list = new ArrayList<>();

        list.add("username");
        list.add("EQUALS");
        list.add("vinayk");
        System.out.println(Service.apiResponseParser(list,3));


        list = new ArrayList<>();
        list.add("address.city");
        list.add("EQUALS");
        list.add("Kolkata");
        System.out.println(Service.apiResponseParser(list,3));


        list = new ArrayList<>();
        list.add("address.city");
        list.add("IN");
        list.add("Mumbai,Kolkata");
        System.out.println(Service.apiResponseParser(list,3));


        list = new ArrayList<>();
        list.add("company.name");
        list.add("EQUALS");
        list.add("tech infar world");
        System.out.println(Service.apiResponseParser(list,3));


        list = new ArrayList<>();
        list.add("company.name");
        list.add("IN");
        list.add("tech infar world,sec infra");
        System.out.println(Service.apiResponseParser(list,3));


        list = new ArrayList<>();
        list.add("address.geo.lat");
        list.add("EQUALS");
        list.add("-17.3159");
        System.out.println(Service.apiResponseParser(list,3));


        list = new ArrayList<>();
        list.add("address.geo.lat");
        list.add("IN");
        list.add("-17.3159,-67.3159");
        System.out.println(Service.apiResponseParser(list,3));


        list = new ArrayList<>();
        list.add("address.geo.lng");
        list.add("EQUALS");
        list.add("57.2232");
        System.out.println(Service.apiResponseParser(list,3));


        list = new ArrayList<>();
        list.add("address.geo.lng");
        list.add("IN");
        list.add("57.2232,-168.8889");
        System.out.println(Service.apiResponseParser(list,3));



        list = new ArrayList<>();
        list.add("geo.lng");
        list.add("EQUALS");
        list.add("57.2232");
        System.out.println(Service.apiResponseParser(list,3));


        list = new ArrayList<>();
        list.add("geo.lng");
        list.add("IN");
        list.add("57.2232,-168.8889");
        System.out.println(Service.apiResponseParser(list,3));

    }
}
