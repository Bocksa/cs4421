/*
 * Written by Cian McNamara.
 */

import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;

public class CPUReader {
    public int coreCount;
    public int socketCount;
    public int coresPerSocket;

    public String model;
    public int l1dCacheSize;
    public int l1iCacheSize;
    public int l2CacheSize;
    public int l3CacheSize;

    private Graph graph;

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

    /// <summary>Gets the CPU load as a rounded percentage.</summary>
    /// <returns></returns>
    public int GetCPULoad() {
        OperatingSystemMXBean os = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        double loadAverage = os.getCpuLoad() * 100;
        return (int)loadAverage;
    }

    /// <summary>Displays all the CPU info.</summary>
    public void DisplayCPUInfo() {
        this.graph = new Graph();
        this.graph.x = 0;
        this.graph.y = 5;
        this.graph.title = "CPU Load Graph: " + this.model;
        this.graph.body =
                "Sockets: " + this.socketCount + "\n" +
                "Cores: " + this.coreCount + "\n" +
                "L1 Cache: " + (this.l1iCacheSize + this.l1dCacheSize) / Math.pow(2,10) + "KB\n" +
                "L2 Cache: " + (this.l2CacheSize / Math.pow(2,20)) + "MB\n" +
                "L3 Cache: " + (this.l3CacheSize / Math.pow(2,20)) + "MB\n";

        while (true) {
            try {
                int cpuLoad = GetCPULoad();
                this.graph.AddData(cpuLoad);
                Thread.sleep(100);
                this.graph.Display();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}