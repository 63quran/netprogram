package chat;

public class TalkStudent {
    public static void main(String[] args) {
        new Thread(new TalkSend("localhost",6666,7777)).start();
        new Thread(new TalkReceive(8888,"老师")).start();
    }
}
