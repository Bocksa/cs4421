public class CPUReader {
    public CoreReader[] cores;
    public int coreCount;

    public String model;
    public int l1dCacheSize;
    public int l1iCacheSize;
    public int l2CacheSize;
    public int l3CacheSize;

    private float averageActivityPercentage = 0f;

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

        getCores(cpuRead);
    }

    public float GetCPUActivity() {
        if (this.coreCount > 0) {
            for (int i = 0; i < this.coreCount; i++) {
                System.out.println(cores.length);
                this.averageActivityPercentage = this.averageActivityPercentage + cores[i].GetCoreActivity();
            }

            this.averageActivityPercentage = this.averageActivityPercentage / this.coreCount;
        }

        return this.averageActivityPercentage;
    }

    /* 
    /   Private method is an example of encapsulation
    /   It is used as anyone using the class doesn't need to see it.
    /   This also reduces confusion when someone is trying to get useful information out.
    */
    private void getCores(cpuInfo cpuRead) {
        this.coreCount = cpuRead.socketCount() * cpuRead.coresPerSocket();
        this.cores = new CoreReader[coreCount];

        for (int i = 1; i <= this.coreCount; i++) {
            cores[i-1] = new CoreReader(i);
        }
    }
}