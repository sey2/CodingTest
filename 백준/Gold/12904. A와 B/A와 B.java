    import java.io.*;

    public class Main {

        public static void main(String args[]) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String a = br.readLine();
            String b = br.readLine();

            for(int i=b.length()-1; i>=0; i--){

                if(b.length() <= a.length()) break;
    
                if(b.charAt(i) == 'A')
                    b = b.substring(0, b.length()-1);
                else
                    b = new StringBuilder(b.substring(0,b.length()-1)).reverse().toString();

                if(b.equals(a)){
                    System.out.println(1);
                    return;
                }
            }

            System.out.println(0);
        }


    }
