public class task3 {
    public static void main(String[] args) {
        int[] arr1 = new int[] { 1, 3, 4, 4, 4, 5 };
        int[] arr2 = new int[] { 2, 5, 7 };
        System.out.println(solutions(1, 0, 0));
        System.out.println(FindZip("all zip files are zipped"));
        System.out.println(checkPerfect(6));
        System.out.println(flipEndChars("Cat, dog, and mouse."));
        System.out.println(isValidHexCode("#CD5C5C"));
        System.out.println(same(arr1, arr2));
        System.out.println(isKaprekar(297));
        System.out.println(longestZero("01100001011000"));
        System.out.println(nextPrime(12));
        System.out.println(rightTriangle(3, 4, 5));
    }

    //1 задание найти количество решений дискриминанта
    public static int solutions(double a, double b, double c) {
        if (Math.pow(b, 2) - 4 * a * c < 0) {
            return 0;
        } else if (Math.pow(b, 2) - 4 * a * c == 0) {
            return 1;
        } else
            return 2;
    }


    public static int FindZip(String str) {
        int count = 0;
        int index = -1;
        for (int i = 1; i < str.length() - 1; i++) {
            if (str.charAt(i - 1) == 'z' && str.charAt(i) == 'i' && str.charAt(i+1)== 'p' && count == 0) {
                count++;
            } else if (str.charAt(i - 1) == 'z' && str.charAt(i) == 'i' && str.charAt(i+1)== 'p' && count < 2) {
                index = i - 1;
                return index;
            }
        }
        return index;
    }

    public static boolean checkPerfect(int num) {
        int num1 = 0;
        for (int i = 1; i < num; i++) {
            if(num%i==0){
                num1+=i;
            }
        }
        if (num1 != num)
            return false;
        else
            return true;
    }

    public static String flipEndChars(String str) {
        String str1 = "";
        str1 += str.charAt(str.length() - 1);
        if (str.length() <= 2)
            return "Incompatible.";
        else if (str.charAt(0) == str.charAt(str.length() - 1))
            return "Two's a pair.";
        for (int i = 1; i < str.length() - 1; i++) {
            str1 += str.charAt(i);
        }
        str1 += str.charAt(0);
        return str1;
    }

    public static boolean isValidHexCode(String str) {
        if (str.charAt(0) != '#') {
            return false;
        }
        int z=0;
        for (int i = 1; i < str.length(); i++) {
            int numOfSymbol = (int)str.charAt(i);
            if ((numOfSymbol >= 65 && numOfSymbol <= 70) || (numOfSymbol >= 97 && numOfSymbol <= 102) || (numOfSymbol >= 49 && numOfSymbol <= 57)) {
                z++;
            }
        }
        if(z==6) return true;
        else return false;
    }

    public static boolean same(int[] arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length];
        int z=0;
        int q1=0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = i; j < arr1.length; j++) {
                if (arr1[i] == arr1[j]) {
                    z++;
                }
            }
            if(z==arr1.length-i-1){
                arr3[q1]=arr1[i];
                q1++;
            }
        }
        int[] arr4 = new int[arr2.length];
        z=0;
        int q2=0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = i; j < arr2.length; j++) {
                if (arr2[i] == arr2[j]) {
                    z++;
                }
            }
            if(z==arr2.length-i-1){
                arr4[q2]=arr2[i];
                q2++;
            }
        }
        if (q1==q2)
            return true;
        else
            return false;
    }

    public static boolean isKaprekar(int num) {
        double left = 0,s;
        double n = Math.pow(num, 2);
        double w = Math.pow(num, 2);
        while(n>0){
            n=(int)n/10;
            left++;
        }
        if((int)left%2==0){
            int x1 = (int)left/2;
            s=(int)(w/Math.pow(10,x1))+(int)(w%Math.pow(10,x1));
        }
        else{
            int x1 = (int)((left+1)/2);
            int x2 = (int)((left+1)/2);
            s=(int)(w/Math.pow(10,x1))+(int)(w%Math.pow(10,x2));
        }
        if (s == num) {
            return true;
        } else {
            return false;
        }
    }

    public static String longestZero(String str) {
        int count = 0;
        int one=0;
        int max = 0;
        int index = 0;
        String str2 = "";
        for (int i = 0; i < str.length()-1; i++) {
            if (str.charAt(i) == '0') {
                count++;
                if(str.charAt(i+1) == '1' || i+2==str.length()){
                    if(count>=max){
                        max=count;
                        index=i+1-count;
                    }
                    count=0;}}
            else{
                one++;
                if(str.charAt(i+1) == '1'  || i+2==str.length()){
                    if(max<=one){
                        max=one;
                        index=i+1-one;
                    }
                    one=0;}}
        }
        if (max == 0) {
            return str2;
        } else {
            for (int i = 0; i < max; i++) {
                str2 += str.charAt(index + i);
            }
        }
        return str2;
    }

    public static int nextPrime(int num) {
        int s=0;
        for (int i = 1; i <= num; i++) {
            if ((num % i) == 0)
                s++;
        }
        if(s==2)
        return num;
        else{
            return  nextPrime(++num);
        }
    }

    public static boolean rightTriangle(int a, int b, int c) {
        double max = a;
        int index = 1;
        if (max < b) {
            max = b;
            index = 2;
        }
        if (max < c) {
            max = c;
            index = 3;
        }
        if ((Math.pow(max, 2) == Math.pow(b, 2) + Math.pow(c, 2)) && index == 1) {
            return true;
        }
        if ((Math.pow(max, 2) == Math.pow(a, 2) + Math.pow(c, 2)) && index == 2) {
            return true;
        }
        if ((Math.pow(max, 2) == Math.pow(b, 2) + Math.pow(a, 2)) && index == 3) {
            return true;
        }
        return false;
    }
}