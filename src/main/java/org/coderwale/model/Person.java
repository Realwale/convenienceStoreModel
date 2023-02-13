package org.coderwale.model;

import lombok.Getter;
import lombok.Setter;

    @Getter
    @Setter
    public class Person {
        private String name;
        private String address;
        private int age;


        // constructor overloading

//        public Person(String name, String address, int age){
//            this.name = name;
//            this.address = address;
//            this.age = age;
//        }
//        public Person(String name){
//            this.name = name;
//        }

        public Person(String name, String address, int age, String id) {
            this.name = name;
            this.address = address;
            this.age = age;
        }
        public Person(String name){
            this.name = name;
        }

        public Person(String name, String address, int age) {
            this.name = name;
            this.address = address;
            this.age = age;
        }
    }

