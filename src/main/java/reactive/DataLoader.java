package reactive;

public class DataLoader {
    public final void load() {
        long startTime = System.currentTimeMillis();
        loadAll();
        long costTime = System.currentTimeMillis() - startTime;
        System.out.println("loadAll() 總耗時：" + costTime + " 毫秒");
    }

    protected void loadAll() {
        loadA();
        loadB();
        loadC();
    }

    protected void loadA() {
        doLoad("loadA", 1);
    }

    protected void loadB() {
        doLoad("loadB", 2);
    }

    protected void loadC() {
        doLoad("loadC", 3);
    }

    private void doLoad(String name, int second) {
        try {
            long startTime = System.currentTimeMillis();
            Thread.sleep(second * 1000);
            long costTime = System.currentTimeMillis() - startTime;
            System.out.printf("[Thread: %s] %s 耗時: %d 毫秒\n", Thread.currentThread().getName(), name, costTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
