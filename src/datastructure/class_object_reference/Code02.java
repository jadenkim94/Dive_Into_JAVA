package datastructure.class_object_reference;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.Scanner;

public class Code02 {

    static Person[] members;
    static int n = 0;

    public static void main(String[] args) throws FileNotFoundException {
        String path = Code02.class.getResource("").getPath();
        Scanner in = new Scanner(new File(path+"/input.txt"));
        while (in.hasNextLine()){
            in.nextLine();
            n++;
        }

        in.close();

        members = new Person[n];

        Scanner in2 = new Scanner(new File(path+"/input.txt"));

        int j = 0;
        while (in2.hasNext()){
            String name = in2.next();
            String number = in2.next();
            Person p = new Person();
            p.name = name;
            p.number = number;
            members[j] = p;
            j++;
        }

        in2.close();

        bubbleSort();

        for(int i = 0 ; i < members.length; i++){
            System.out.println(members[i].name + " " + members[i].number);
        }

    }

    private static void bubbleSort() {
        for(int i = n-1; i >0; i--){
            for(int j = 0 ; j < i; j++){
                if(members[j].name.compareTo(members[j+1].name) > 0){
                    //swap
                    Person temp = members[j+1];
                    members[j+1] = members[j];
                    members[j] = temp;
                }
            }
        }
    }

}
