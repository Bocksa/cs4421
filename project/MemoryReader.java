public class MemoryReader {
    Graph graph;

    /// <summary>Constructor method for MemoryReader.</summary>
    public MemoryReader() {
        System.loadLibrary("sysinfo");
    }

    /// <summary>Displays all the memory information on the console.</summary>
    public void DisplayMemoryInfo() {
        memInfo memory = new memInfo();
        memory.read();

        this.graph = new Graph();
        this.graph.x = 0;
        this.graph.y = 3;
        this.graph.title = "Memory Load Graph (" + Math.round((memory.getTotal() / Math.pow(2,20)) * 10) / 10f + " GB)";

        while (true) {
            try {
                memory.read();
                float usedMemory = Math.round((memory.getUsed() / Math.pow(2, 20)) * 10) / 10f;
                float totalMemory = Math.round((memory.getTotal() / Math.pow(2,20)) * 10) / 10f;
                int memoryPercentage = (int)((usedMemory / totalMemory) * 100);

                this.graph.AddData(memoryPercentage);
                this.graph.body =
                        "Memory in use: " + usedMemory + "/" + totalMemory + " GB  \n";
                this.graph.Display();

                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
