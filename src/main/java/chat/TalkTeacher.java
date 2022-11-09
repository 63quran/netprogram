package chat;

public class TalkTeacher {
    public static void main(String[] args) {
        new Thread(new TalkSend("localhost", 8888, 9999)).start();
        new Thread(new TalkReceive(6666,"学生")).start();
    }
}
