package org.example.arcesium.models;
import java.util.*;
public class FieldsSet {
    public static Set<String> contactFieldsSet = new HashSet<>();
    public static Set<String> addressFieldsSet = new HashSet<>();

    public static Set<String> geoFieldsSet = new HashSet<>();
    public static Set<String> companyFieldsSet = new HashSet<>();

    static {
        contactFieldsSet.add("id");
        contactFieldsSet.add("name");
        contactFieldsSet.add("username");
        contactFieldsSet.add("email");
        contactFieldsSet.add("website");

        addressFieldsSet.add("street");
        addressFieldsSet.add("suite");
        addressFieldsSet.add("city");
        addressFieldsSet.add("zipcode");

        geoFieldsSet.add("lat");
        geoFieldsSet.add("lng");

        companyFieldsSet.add("name");
        companyFieldsSet.add("basename");
    }

}
