import java.io.*;
import java.util.Random;
import java.util.Scanner;
import org.apache.commons.lang3.RandomStringUtils;
public class main {
    public static void main(String args[]){

        String decision;
        int selection =0;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Registry Main Menu\n*******************\n");
            System.out.println("1- Register \n2- View"
                    + "\n3- Quit");

            System.out.println("Select Option [1, 2, 3] :>");
             decision = input.nextLine();

                try{

                    selection = Integer.parseInt(decision);
                    if (selection == 1) {
                        doRegister();
                    }else if (selection == 2){
                            viewRegister();
                    }else if ( selection == 3){
                        System.out.println("GoodBye :)");
                    }else if(selection > 3 || selection <1) {
                        System.out.println("Please enter 1 or 2 or 3 to make a selection");
                        break;
                    }

            } catch (NumberFormatException ex){
                System.out.println("Please enter 1 or 2 or 3 to make a selection");
            }

//                decision.trim();
//                selection = Integer.parseInt(decision);

        }while (!(selection == 3));

    }

   static void doRegister(){
        Scanner input = new Scanner(System.in);
        System.out.println("Input Index number");
        String indexNumber = input.nextLine();
       System.out.println("Input First Name");
       String firstName = input.nextLine();
       System.out.println("Input Last Name");
       String lastName = input.nextLine();
       System.out.println("Input Department Name");
       String department = input.nextLine();
       System.out.println("Input Level");
       String level = input.nextLine();
       System.out.println("Input age");
       String age = input.nextLine();
       int acAge = Integer.parseInt(age);
       Random rnd = new Random(acAge);
       String num = "", num1 = null, num2 = null, num3=null;
       for(int k =0; k<=3; k++){
           for(int i = 1; i<=4; i++){
               num += RandomStringUtils.randomAlphanumeric(acAge);
           }
           switch (k){
               case 1:
                   num1 = num;
                   break;
               case 2:
                   num2 = num;
                   break;
               case 3:
                   num3 = num;
                   break;
           }
       }
       String randomNumber = num1 +"-"+num2+"-"+num3;
       Writer write = null;
       try {
           write = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Random Numbers.txt"), "utf-8"));
           write.write("Age: "+age+"\n"+"Index number: "+indexNumber+"\n"+"Random number: "+randomNumber+"\n"+"First name: "+firstName+"\n"+"Last name: "+lastName+"\n"+"Department: "+department+"\n"+"Lavel: "+level);
           System.out.println("succes");
       } catch (UnsupportedEncodingException e) {
           e.printStackTrace();
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       };
    }
    static void viewRegister(){
        Scanner input = new Scanner(System.in);
        String index ;
        System.out.println("What is your Index number?");
        index = input.nextLine();
        Scanner s = null;
        String result = "";
        try {
            s = new Scanner(new BufferedReader(new FileReader("Random Numbers.txt")));
            while(s.hasNextLine()){
                String nextline = s.nextLine();
                if(nextline.contains(index)){
                    while (s.hasNextLine()){
                        nextline = s.nextLine();
                        if(nextline.contains("Random number: ")){
                            result = nextline;
                            System.out.println(result);
                        }
                    }
                }else {
                    System.out.println("nothing to display");
                }
        }
        } catch (FileNotFoundException e) {
            System.out.println("A random number is not generated for you yet.");
        }finally {
            if(s != null){
                s.close();
            }
        }
    }
}
