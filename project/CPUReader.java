public class CPUReader {
    public CoreReader[] cores;
    public int coreCount;
    public float averageActivityPercentage = 0f;

    public String model;
    public int l1dCacheSize;
    public int l1iCacheSize;
    public int l2CacheSize;
    public int l3CacheSize;

    // Initialiser method for CPUReader. It runs automatically when you create a new object (ex. CPUReader reader = new CPUReader())
    public CPUReader() {
        cpuInfo cpuRead = new cpuInfo();

        this.model = cpuRead.model;
        this.l1dCacheSize = cpuRead.l1dCacheSize;
        this.l1iCacheSize = cpuRead.l1iCacheSize;
        this.l2CacheSize = cpuRead.l2CacheSize;
        this.l3CacheSize = cpuRead.l3CacheSize;

        getCores();
    }

    public float GetCPUActivity() {

    }

    /* 
    /   Private method is an example of encapsulation
    /   It is used as anyone using the class doesn't need to see it.
    /   This also reduces confusion when someone is trying to get useful information out.
    */
    private void getCores() {
        cpuInfo cpuRead = new cpuInfo();

        this.coreCount = cpuRead.socketCount() * cpuRead.coresPerSocket();

        for (int i = 1; i <= this.coreCount; i++) {
            cores[i-1] = new CoreReader(i);
        }
    }
}