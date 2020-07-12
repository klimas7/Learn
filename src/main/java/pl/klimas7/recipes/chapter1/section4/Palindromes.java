package pl.klimas7.recipes.chapter1.section4;

public class Palindromes {
    public static void main(String[] args) {
        PalindromeChecker p = (String s) -> {
            if (s == null || s.length() < 2) {
                return true;
            } else {
                int half = s.length() / 2;
                for (int i = 0; i < half; i++) {
                    if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                        return false;
                    }
                }
            }
            return true;
        };

        PalindromeChecker p2 = (String s) -> {
            if (s == null || s.length() < 0) {
                return true;
            }
            else {
                return s.equalsIgnoreCase(new StringBuilder(s).reverse().toString());
            }
        };

        testPalindrome(p);
        testPalindrome(p2);
    }

    private static void testPalindrome(PalindromeChecker p) {
//        assertTrue(p.isPalindrome(""));
//        assertTrue(p.isPalindrome("a"));
//        assertTrue(p.isPalindrome("aa"));
//        assertTrue(p.isPalindrome("aba"));
//        assertFalse(p.isPalindrome("abca"));
    }
}
