package algorithm.books.arraysandstring;

public class Chapter1 {
    /*
     주어진 문자열 내의 모든 공백을 '%20'으로 바꾸는 메소드를 작성하라.
     문자열 끝에 추가로 필요한 문자들을 더할 수  있는 충분한 공간이 있다고 가정하고 공백을 포함하는 문자열의 길이도 함께 주어진다.
     ex) "Mr John Smith    ", 13
         "Mr%20John%20Smith"
     */
    public static void main(String[] args) {
        String str = "Mr John Smith    ";
        char[] strToChar = str.toCharArray();
        replaceSpaces(strToChar, 13);
    }

    public static void replaceSpaces(char[] str, int length){
        int spaceCount = 0;
        int newLength = 0;
        for(int i = 0; i < length; i++){
            if(str[i] == ' '){
                spaceCount++;
            }
        }
        newLength = length + spaceCount*2;

        char[] answer = new char[newLength];

        for(int i = length-1; i>=0 ; i-- ){
            if(str[i]==' '){
                answer[newLength-1] = '0';
                answer[newLength-2] = '2';
                answer[newLength-3] = '%';
                newLength -= 3;
            } else {
                answer[newLength-1] = str[i];
                newLength -= 1;
            }
        }
        System.out.println(String.valueOf(answer));
    }
}
