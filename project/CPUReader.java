/*
 * Written by Cian McNamara.
 */

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class CPUReader {
    public int coreCount;
    public int socketCount;
    public int coresPerSocket;

    public String model;
    public int l1dCacheSize;
    public int l1iCacheSize;
    public int l2CacheSize;
    public int l3CacheSize;

    private boolean graphing = false;

    // Constructor method for CPUReader. It runs automatically when you create a new object (ex. CPUReader reader = new CPUReader())
    public CPUReader() {
        System.loadLibrary("sysinfo");

        cpuInfo cpuRead = new cpuInfo();
        cpuRead.read(0);

        this.model = cpuRead.getModel();
        this.l1dCacheSize = cpuRead.l1dCacheSize();
        this.l1iCacheSize = cpuRead.l1iCacheSize();
        this.l2CacheSize = cpuRead.l2CacheSize();
        this.l3CacheSize = cpuRead.l3CacheSize();

        this.socketCount = cpuRead.socketCount();
        this.coresPerSocket = cpuRead.coresPerSocket();
        this.coreCount = cpuRead.socketCount() * cpuRead.coresPerSocket();
    }

    public int GetCPULoad() {
        OperatingSystemMXBean os = ManagementFactory.getOperatingSystemMXBean();
        double loadAverage = os.getSystemLoadAverage() * 100;
        return (int)loadAverage;
    }

    public void Graph() {
        this.graphing = true;

        Graph graph = new Graph();
        graph.x = 0;
        graph.y = 5;
        graph.title = "CPU Load Graph: " + this.model;
        graph.body =
                "Sockets: " + this.socketCount + "\n" +
                "Cores: " + this.coreCount + "\n" +
                "L1 Cache: " + this.l1iCacheSize + this.l1dCacheSize + "B\n" +
                "L2 Cache: " + this.l2CacheSize + "B\n" +
                "L3 Cache: " + this.l3CacheSize + "B\n";

        while (graphing == true) {
            try {
                int cpuLoad = this.GetCPULoad();

                graph.AddData(cpuLoad);
                graph.Display();

                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        graph.Hide();
    }

    public void StopGraph() {
        this.graphing = false;
    }
}