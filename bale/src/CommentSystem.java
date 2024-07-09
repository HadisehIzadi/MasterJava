import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.*;
import java.text.*;




    class Comment {
        String username;
        String time;
        String comment;
        int replyTo;
        List<Comment> replies;
        int depth;

        public Comment(String username, String time, String comment, int replyTo) {
            this.username = username;
            this.time = time;
            this.comment = comment;
            this.replyTo = replyTo;
            this.replies = new ArrayList<>();
            this.depth = 0;
        }

        public Date getTimeAsDate() throws ParseException {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            return sdf.parse(time);
        }
    }

    public class CommentSystem {

        public static void main(String[] args) throws ParseException {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int L = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            List<Comment> comments = new ArrayList<>();
            Map<Integer, Comment> commentMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ", 4);
                String type = parts[0];
                String username = parts[1];
                String time = parts[2];
                String comment = parts[3].substring(1, parts[3].length() - 1);  // Remove quotes

                if (type.equals("send")) {
                    Comment c = new Comment(username, time, comment, -1);
                    comments.add(c);
                    commentMap.put(comments.size(), c);
                } else if (type.equals("reply")) {
                    int replyTo = Integer.parseInt(parts[2]);
                    String replyTime = parts[3].substring(0, 8);
                    String replyComment = parts[3].substring(9, parts[3].length() - 1);
                    Comment c = new Comment(username, replyTime, replyComment, replyTo);
                    comments.add(c);
                    commentMap.get(replyTo).replies.add(c);
                    c.depth = commentMap.get(replyTo).depth + 1;
                }
            }

            comments.sort(Comparator.comparing(c -> {
                try {
                    return c.getTimeAsDate();
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }));

            for (Comment c : comments) {
                if (c.replyTo == -1) {
                    printComment(c, L);
                    printReplies(c, L);
                }
            }
        }

        private static void printComment(Comment c, int L) {
            String border = "+";
            String left = "-";
            String right = "-";
            String middle = "+";
            String spaces = " ";

            String nameLine = border + left + c.username;
            for (int i = 0; i < L - c.username.length() - 2; i++) {
                nameLine += right;
            }
            nameLine += middle;

            List<String> commentLines = wrapText(c.comment, L);
            List<String> formattedCommentLines = new ArrayList<>();

            for (String line : commentLines) {
                String formattedLine = border + line;
                for (int i = 0; i < L - line.length() - 2; i++) {
                    formattedLine += spaces;
                }
                formattedLine += middle;
                formattedCommentLines.add(formattedLine);
            }

            String timeLine = border;
            for (int i = 0; i < L - c.time.length() - 2; i++) {
                timeLine += left;
            }
            timeLine += c.time + right + middle;

            printIndentedLine(nameLine, c.depth);
            for (String line : formattedCommentLines) {
                printIndentedLine(line, c.depth);
            }
            printIndentedLine(timeLine, c.depth);
        }

        private static void printReplies(Comment c, int L) {
            for (Comment reply : c.replies) {
                printComment(reply, L);
                printReplies(reply, L);
            }
        }

        private static void printIndentedLine(String line, int depth) {
            for (int i = 0; i < depth * 4; i++) {
                System.out.print(">");
            }
            System.out.println(line);
        }

        private static List<String> wrapText(String text, int L) {
            List<String> lines = new ArrayList<>();
            String[] words = text.split("\\s+");
            StringBuilder currentLine = new StringBuilder();
            for (String word : words) {
                if (currentLine.length() + word.length() + 1 <= L) {
                    if (currentLine.length() > 0) {
                        currentLine.append(" ");
                    }
                    currentLine.append(word);
                } else {
                    lines.add(currentLine.toString());
                    currentLine = new StringBuilder(word);
                }
            }
            if (currentLine.length() > 0) {
                lines.add(currentLine.toString());
            }
            return lines;
        }
    }


