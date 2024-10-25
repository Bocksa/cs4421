import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.List;

public class CoreReader {
    public int coreNumber;
    public List<Float> activityPerSecond = new ArrayList<Float>();

    // This is the constructor for the class. It runs whenever you create a new object. (ex. CoreReader reader = new CoreReader())
    public CoreReader(int coreNumber) {
        System.loadLibrary("sysinfo");
        this.coreNumber = coreNumber;

        // Sets up the task scheduler to run updateActivityPerSecond() every second (shouldn't stall the thread I think)
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(updateActivityPerSecond, 0, 1000, TimeUnit.MILLISECONDS);
    }

    // Adds the current seconds activity percentage to activityPerSecond
    Runnable updateActivityPerSecond = () -> {
        cpuInfo cpuRead = new cpuInfo();
        cpuRead.read();

        long idleTime = cpuRead.getIdleTime(this.coreNumber);
        long userTime = cpuRead.getUserTime(this.coreNumber);
        long systemTime = cpuRead.getSystemTime(this.coreNumber);
        long busyTime = userTime + systemTime;
        long elapsedTime = idleTime + busyTime;
        float activityPercentage = ((busyTime / elapsedTime)) * 100f;

        if (activityPercentage >= 0) {
            activityPerSecond.add(((busyTime / (busyTime + idleTime))) * 100f);
        } else {
            activityPerSecond.add(0f);
        }
    };

    // Gets the total activity percentage for the core
    public float GetCoreActivity() {
        float total = 0f;
        float totalActivityPercentage = 0f;

        if (!this.activityPerSecond.isEmpty()) {
            for (Float aFloat : this.activityPerSecond) {
                total = total + aFloat;
            }

            totalActivityPercentage = total / activityPerSecond.size();   
        }

        return totalActivityPercentage;
    }
}