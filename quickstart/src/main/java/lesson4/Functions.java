package lesson4;

public class Functions {
    public static boolean isPrime(Integer number) {
        //1,2,3 простое число = true
        // 0,4 не простое = false
        if (number <= 0) return false;
        if (number <= 3) return true;
        for (int i = 2; i < number - 1; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static boolean isPalindrome(String word) {
        if (word.length() < 2) {
            return true;
        }
        if (word.charAt(0) != word.charAt(word.length() - 1)) {
            return false;
        }

        return isPalindrome(word.substring(1, word.length() - 1));
    }
    //123321 true
    //2332 true
    //33 true
    // - true
}
