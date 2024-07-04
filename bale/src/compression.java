import java.util.Scanner;

    public class compression {
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
                compressedWord = mergeWordsByPoint(compressedWord, words[i]);
            }

            System.out.println(compressedWord);

            scanner.close();
        }

        public static String mergeWordsByPoint(String word1, String word2) {
            int maxLength = Math.min(word1.length(), word2.length());
            int mergePoint = 0;

            for (int i = 1; i <= maxLength; i++) {
                if (word1.endsWith(word2.substring(0, i))) {
                    mergePoint = i;
                }
            }

            return word1 + word2.substring(mergePoint);
        }
    }




