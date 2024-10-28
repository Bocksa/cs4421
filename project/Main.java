import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    CPUReader cpu;
    Graph graph;

    public static void main(String[] args) {
        SetupCPUMenu();
    }

    public static void SetupCPUMenu() {
        CPUReader cpu = new CPUReader();
        cpu.Graph();
        try {Thread.sleep(3000);} catch (InterruptedException e) {}
        cpu.StopGraph();

    }
}
