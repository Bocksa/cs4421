public class CPUReader {
    public CoreReader[] cores;
    public int coreCount;
    public float averageActivityPercentage = 0f;

    public CPUReader() {
        getCores();
    }

    private void getCores() {
        cpuInfo cpuRead = new cpuInfo();
        this.coreCount = cpuRead.socketCount() * cpuRead.coresPerSocket();

        for (int i = 1; i <= this.coreCount; i++) {
            cores[i-1] = new CoreReader(i);
        }
    }
}