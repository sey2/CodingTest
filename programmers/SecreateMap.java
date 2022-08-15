class Solution {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        for(int i=0; i<arr1.length; i++){
            list1.add(toBinary(arr1[i], n));
            list2.add(toBinary(arr2[i], n));
        }

        String[] answer = new String[n];

        for(int i=0; i < list1.size(); i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<list1.size(); j++) {

                if (list1.get(i).charAt(j) == '1' || list2.get(i).charAt(j) =='1')
                    sb.append("#");
                else
                    sb.append(" ");
            }
            answer[i] = sb.toString();
        }


        return answer;
    }

    public static String toBinary(int num, int pow){
        StringBuilder sb = new StringBuilder();

        while(num>0){
            sb.insert(0,Integer.toString(num%2));
            num /= 2;
        }

        if(pow > sb.length()){
            for(int i=sb.length(); i< pow; i++)
                sb.insert(0,"0");
        }

        return sb.toString();
    }
}
