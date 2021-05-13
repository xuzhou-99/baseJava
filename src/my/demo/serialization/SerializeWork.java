package my.demo.serialization;

import java.io.Serializable;
import java.time.LocalDateTime;

import jdk.nashorn.internal.parser.JSONParser;

/**
 * SerializeWork
 *
 * @author xuzhou
 * @version v1.0.0
 * @create 2021/5/12 16:37
 */
public class SerializeWork implements Serializable {

    private static final long serialVersionUID = 6077178199418165417L;


    public static void main(String[] args) {
        Person person = new Person("Ali", 22, LocalDateTime.now());

    }




    public static class Person{
        private int AGE;
        private String NAME;
        private LocalDateTime TIME;
        Person(){

        }
        Person(String name,int age,LocalDateTime time){
            this.NAME = name;
            this.AGE = age;
            this.TIME = time;
        }

        public int getAGE() {
            return AGE;
        }

        public void setAGE(int AGE) {
            this.AGE = AGE;
        }

        public String getNAME() {
            return NAME;
        }

        public void setNAME(String NAME) {
            this.NAME = NAME;
        }

        public LocalDateTime getTIME() {
            return TIME;
        }

        public void setTIME(LocalDateTime TIME) {
            this.TIME = TIME;
        }
    }

}
