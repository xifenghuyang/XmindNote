package com.java.jikexueyuan.singleton;

public class Test {

    public class Abc {
        private Abc() {
        }

        Abc n1 = new Abc();
    }

    public class Cbd {
        public Cbd() {
            Abc n1, n2;
            n1 = new Abc();
            n2 = new Abc();
        }
    }


    public static void main(String[] args) {


        Abc n1, n2;
// 采用private保证了不能被new
//        n1 = new Abc();


    }

}
