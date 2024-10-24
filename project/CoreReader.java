import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.*;
import java.util.ArrayList;
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
        cpuRead.read(0);

        float idleTime = cpuRead.getIdleTime(this.coreNumber);
        float activityPercentage = 1f - (idleTime / 100f);

        activityPerSecond.add(activityPercentage);
    };

    // Gets the total activity percentage for the core
    public float GetCoreActivity() {
        float total = 0f;
        float totalActivityPercentage = 0f;

        if (this.activityPerSecond.size() > 0) {
            for (int i = 0; i < this.activityPerSecond.size(); i++) {
                total = total + this.activityPerSecond.get(i);
            }

            totalActivityPercentage = total / activityPerSecond.size();   
        }

        return totalActivityPercentage * 100f;
    }
}