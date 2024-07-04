import java.util.Scanner;

public class compressionFaster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = scanner.next();
        }

        String compressedWord = words[0];
        for (int i = 1; i < n; i++) {
            compressedWord = mergeWords(compressedWord, words[i]);
        }

        System.out.println(compressedWord);

        scanner.close();
    }

    public static String mergeWords(String word1, String word2) {
        int maxLength = Math.min(word1.length(), word2.length());
        int mergePoint = 0;

        for (int i = maxLength; i > 0; i--) {
            if (word1.regionMatches(word1.length() - i, word2, 0, i)) {
                mergePoint = i;
                break;
            }
        }

        return word1 + word2.substring(mergePoint);
    }
}
