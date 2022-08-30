class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        while(true){
            answer ++;

            int min = Math.min(a,b);

            if( min % 2 != 0 && (a+1 == b || b+1 == a)) break;

            a = (a % 2==0) ? a/2 : (a+1)/2;
            b = (b % 2==0) ? b/2 : (b+1)/2;
        }

        return answer;
    }
}


// A:2, B:3 <- 만나지 말아야함
