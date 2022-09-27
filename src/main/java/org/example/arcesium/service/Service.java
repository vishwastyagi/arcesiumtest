package org.example.arcesium.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.arcesium.models.Address;
import org.example.arcesium.models.Company;
import org.example.arcesium.models.Contact;
import org.example.arcesium.models.FieldsSet;
import org.example.arcesium.models.Geo;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;


public class Service {
    public static List<Integer> apiResponseParser(List<String> inputList, int size) throws IllegalAccessException {
        if(inputList==null || inputList.size()!=3 || size!=3){
            return null;
        }
        String contactUrl="https://raw.githubusercontent.com/arcjsonapi/ApiSampleData/master/api/users";
        List<Integer> response = new ArrayList<>();
        String holdingData = getApiResponse(contactUrl);
        Contact contacts[] =  mapApiResponseToModel(holdingData);

        for(Contact contact:contacts){
            String queryFields[] = inputList.get(0).split("\\.");
            if(queryFields.length==1 && FieldsSet.contactFieldsSet.contains(inputList.get(0))){
                Field[] fields = Contact.class.getDeclaredFields();
                for (int i = 0; i < fields.length; i++) {
                    if(fields[i].getName().equalsIgnoreCase(inputList.get(0))){

                        fields[i].setAccessible(true);

                        String fieldValue = (String)fields[i].get(contact);
                        if(fieldValue!=null) {
                            if ("EQUALS".equalsIgnoreCase(inputList.get(1))) {
                                if (fieldValue.trim().equals(inputList.get(2).trim())) {
                                    response.add(contact.getId());
                                }
                            }
                            if ("IN".equalsIgnoreCase(inputList.get(1))) {
                                String values[] = inputList.get(2).split(",");
                                for (String value : values) {
                                    if (fieldValue.trim().equals(value.trim())) {
                                        response.add(contact.getId());
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else {
                //String queryFields[] = inputList.get(0).split("\\.");
                if (queryFields.length==2) {
                    String queryField = queryFields[1];
                    if(FieldsSet.addressFieldsSet.contains(queryField)){
                        // search in address
                        Address address = contact.getAddress();
                        Field[] fields = Address.class.getDeclaredFields();
                        for (int i = 0; i < fields.length; i++) {
                            if(fields[i].getName().equalsIgnoreCase(queryField)){

                                fields[i].setAccessible(true);

                                String fieldValue = (String)fields[i].get(address);
                                //System.out.println("fields[i] = "+fields[i]+", fieldValue = "+fieldValue);
                                if(fieldValue!=null) {
                                    if ("EQUALS".equalsIgnoreCase(inputList.get(1))) {
                                        if (fieldValue.trim().equals(inputList.get(2).trim())) {
                                            response.add(contact.getId());
                                        }
                                    }
                                    if ("IN".equalsIgnoreCase(inputList.get(1))) {
                                        String values[] = inputList.get(2).split(",");
                                        for (String value : values) {
                                            if (fieldValue.trim().equals(value.trim())) {
                                                response.add(contact.getId());
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }

                    } else if (FieldsSet.companyFieldsSet.contains(queryField)) {
                        // search in company
                        Company company = contact.getCompany();
                        Field[] fields = Company.class.getDeclaredFields();
                        for (int i = 0; i < fields.length; i++) {
                            if(fields[i].getName().equalsIgnoreCase(queryField)){

                                fields[i].setAccessible(true);

                                String fieldValue = (String)fields[i].get(company);
                               // System.out.println("fields[i] = "+fields[i]+", fieldValue = "+fieldValue);
                                if(fieldValue!=null) {
                                    if ("EQUALS".equalsIgnoreCase(inputList.get(1))) {
                                        if (fieldValue.trim().equals(inputList.get(2).trim())) {
                                            response.add(contact.getId());
                                        }
                                    }
                                    if ("IN".equalsIgnoreCase(inputList.get(1))) {
                                        String values[] = inputList.get(2).split(",");
                                        for (String value : values) {
                                            if (fieldValue.trim().equals(value.trim())) {
                                                response.add(contact.getId());
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }else if (FieldsSet.geoFieldsSet.contains(queryField)) {
                        // search in company
                        Geo geo = contact.getAddress().getGeo();
                        Field[] fields = Geo.class.getDeclaredFields();
                        for (int i = 0; i < fields.length; i++) {
                            if(fields[i].getName().equalsIgnoreCase(queryField)){

                                fields[i].setAccessible(true);

                                double fieldValue = (double)fields[i].get(geo);
                                //System.out.println("fields[i] = "+fields[i]+", fieldValue = "+fieldValue);

                                    if ("EQUALS".equalsIgnoreCase(inputList.get(1))) {
                                        double targetValue = Double.parseDouble(inputList.get(2));
                                        if (fieldValue==targetValue) {
                                            response.add(contact.getId());
                                        }
                                    }
                                    if ("IN".equalsIgnoreCase(inputList.get(1))) {
                                        String values[] = inputList.get(2).split(",");
                                        for (String value : values) {
                                            double targetValue = Double.parseDouble(value);
                                            if (fieldValue==targetValue) {
                                                response.add(contact.getId());
                                                break;
                                            }
                                        }
                                    }

                            }
                        }
                    }
                }
                else if (queryFields.length==3) {
                    String queryField = queryFields[2];
                    if(FieldsSet.geoFieldsSet.contains(queryField)){
                        // search in geo
                        Geo geo = contact.getAddress().getGeo();
                        Field[] fields = Geo.class.getDeclaredFields();
                        for (int i = 0; i < fields.length; i++) {
                            if(fields[i].getName().equalsIgnoreCase(queryField)){

                                fields[i].setAccessible(true);

                                double fieldValue = (double)fields[i].get(geo);
                                //System.out.println("fields[i] = "+fields[i]+", fieldValue = "+fieldValue);
                                    if ("EQUALS".equalsIgnoreCase(inputList.get(1))) {
                                        double targetValue = Double.parseDouble(inputList.get(2));
                                        if (fieldValue==targetValue) {
                                            response.add(contact.getId());
                                        }
                                    }
                                    if ("IN".equalsIgnoreCase(inputList.get(1))) {
                                        String values[] = inputList.get(2).split(",");
                                        for (String value : values) {
                                            double targetValue = Double.parseDouble(value);
                                            if (fieldValue==targetValue) {
                                                response.add(contact.getId());
                                                break;
                                            }
                                        }
                                    }

                            }
                        }
                    }
                }
            }
        }

        if(response.size()==0){
            response.add(-1);
        }
        return response;


    }

    private static Contact[] mapApiResponseToModel(String holdingData) {
        Gson gson = new GsonBuilder().create();
        Contact[] contacts = gson.fromJson(holdingData, Contact[].class);
        return contacts;
    }

    private static String getApiResponse(String url){
        try {
            URL connectionUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) connectionUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            StringBuffer inline=new StringBuffer("");
            Scanner scanner = new Scanner(connectionUrl.openStream());
            while(scanner.hasNext()){
                inline.append(scanner.nextLine());
            }
            scanner.close();
            return inline.toString();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
