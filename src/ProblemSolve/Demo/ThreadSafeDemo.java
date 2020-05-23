package ProblemSolve.Demo;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadSafeDemo {

    public static void main(String[] args) throws InterruptedException {
       /* StringBuffer sb = new StringBuffer();
        DemoThreadSafeStringBufferThread pt1 = new DemoThreadSafeStringBufferThread(sb, "1");
        DemoThreadSafeStringBufferThread pt2 = new DemoThreadSafeStringBufferThread(sb, "2");
        Thread t1 = new Thread(pt1, "t1");
        t1.start();
        Thread t2 = new Thread(pt2, "t2");
        t2.start();
        //wait for threads to finish processing
        t1.join();
        t2.join();
        System.out.println(sb.toString());
        System.out.println(sb.length());*/
        List<String> l = new CopyOnWriteArrayList<>();//Collections.synchronizedList(new ArrayList<>());
        DemoArrayListVectorThread d1 = new DemoArrayListVectorThread(l, "1");
        DemoArrayListVectorThread d2 = new DemoArrayListVectorThread(l, "2");
        Thread t1 = new Thread(d1);
        Thread t2 = new Thread(d2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(l.size());

    }

}

class DemoThreadSafeStringBufferThread implements Runnable {
    private StringBuffer sb;
    private String name;

    public DemoThreadSafeStringBufferThread(StringBuffer sb, String name) {
        this.sb = sb;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            sb.append(this.name.charAt(0));
        }
    }
}

class DemoArrayListVectorThread implements Runnable {
    private List<String> list;
    private String name;

    public DemoArrayListVectorThread(List<String> sb, String name) {
        this.list = sb;//Collections.synchronizedList(sb);
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            list.add(name);
        }
    }
}


