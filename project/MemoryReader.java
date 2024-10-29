public class MemoryReader {
    Graph graph;

    public MemoryReader() {
        System.loadLibrary("sysinfo");
    }

    public void DisplayMemoryInformation() {
        memInfo memory = new memInfo();

        this.graph = new Graph();
        this.graph.x = 0;
        this.graph.y = 5;
        this.graph.title = "Memory Load Graph";

        while (true) {
            try {
                memory.read();
                int usedMemory = memory.getUsed();
                int totalMemory = memory.getTotal();
                int memoryPercentage = (int)((usedMemory / (float)totalMemory) * 100);
                this.graph.AddData(memoryPercentage);
                this.graph.body =
                                "Memory Used: " + memory.getUsed() / Math.pow(2,20) + "GB\n" +
                                "Total Memory: " + memory.getTotal() / Math.pow(2,20) + "GB\n";
                Thread.sleep(100);
                this.graph.Display();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
