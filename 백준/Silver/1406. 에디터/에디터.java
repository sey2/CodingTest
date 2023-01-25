    import java.io.*;
    import java.util.ArrayList;
    import java.util.LinkedList;
    import java.util.ListIterator;
    import java.util.StringTokenizer;

    public class Main {


        public static void main(String args[]) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


            LinkedList<Character> list = new LinkedList<>();

            String in = br.readLine();

            for(int i=0; i<in.length(); i++) list.add(in.charAt(i));
            
            int commandNum = Integer.parseInt(br.readLine());

            ListIterator<Character> iter = list.listIterator();

            while(iter.hasNext())
                iter.next();


            for(int i=0; i<commandNum; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();

                switch (command){
                    case "L":
                        if(iter.hasPrevious()) iter.previous();
                        break;

                    case "D":
                        if(iter.hasNext()) iter.next();
                        break;

                    case "B":
                        if(iter.hasPrevious()){
                            iter.previous();
                            iter.remove();
                        }
                        break;

                    case "P":
                        char c = st.nextToken().charAt(0);
                        iter.add(c);
                        break;
                }
            }

            for(char c : list) bw.write(c);

            bw.flush();


        }
    }
