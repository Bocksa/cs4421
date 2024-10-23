public class CoreReader() {
    public int coreNumber;
    public float[] activityPerSecond;

    // This is the initialiser for the class. It runs whenever you create a new object. (ex. CoreReader reader = new CoreReader())
    public CoreReader(int coreNumber) {
        this.coreNumber = coreNumber;

        // Sets up the task scheduler to run updateActivityPerSecond() every second (shouldn't stall the thread I think)
        final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(updateActivityPerSecond, 0, 1, TimeUnit.SECONDS);
    }

    // Adds the current seconds activity percentage to activityPerSecond
    public updateActivityPerSecond() {
        cpuInfo cpuRead = new cpuInfo();
        cpuInfo.read();

        float activeTime = cpuRead.GetCoreActivity(this.coreNumber);
        float activityPercentage = activeTime / 100f;

        activityPerSecond[activityPerSecond.length - 1] = activity; 
    }

    // Gets the total activity percentage for the core
    public float GetCoreActivity() {
        float total = 0f;
        float totalActivityPercentage = 0f;

        if (activityPerSecond.length > 0) {
            for (int i = 0; i < activityPerSecond.length; i++) {
                total = total + activityPerSecond[i];
            }

            totalActivityPercentage = total / activityPerSecond.length;   
        }

        return totalActivityPercentage;
    }
}