package org.example.consumer;

import org.example.convert.Converter;

import java.util.ServiceLoader;

public class Main {

    public static void main(String[] args) {
        
        ServiceLoader<Converter> serviceLoader = ServiceLoader.load(Converter.class);


        serviceLoader.stream()
                .map(ServiceLoader.Provider::get)
                .filter(converter ->
                        converter
                                .getClass()
                                .getSimpleName()
                                .startsWith("Euro")).
                                forEach(greetingProvider ->
                        System.out.println(greetingProvider.convert()));

//            System.out.println(greeting.getClass().getSimpleName());
//            System.out.println(greeting.greet());
        }
    }
