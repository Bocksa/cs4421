import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import com.fasterxml.jackson.databind.*;
import java.io.File;
import java.io.IOException;

public class CoreReader {
    public int coreNumber;
    public List<Float> activityPerSecond = new ArrayList<>();
    private List<Float> cycle1ActivityData = new ArrayList<>();
    private List<Float> cycle2ActivityData = new ArrayList<>();

    // Constructor for CoreReader
    public CoreReader(int coreNumber) {
        System.loadLibrary("sysinfo");
        this.coreNumber = coreNumber;

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(updateActivityPerSecond, 0, 1000, TimeUnit.MILLISECONDS);
    }

    // Adds the current second's activity percentage to activityPerSecond
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

    // Saves the collected activity data for the specified cycle
    public void saveCurrentCycleData(int cycleNumber) {
        if (cycleNumber == 1) {
            cycle1ActivityData = new ArrayList<>(activityPerSecond);
        } else if (cycleNumber == 2) {
            cycle2ActivityData = new ArrayList<>(activityPerSecond);
        }
        activityPerSecond.clear();
    }

    // Serializes the cycle data as JSON to specified file path
    public void saveCycleDataAsJson() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File jsonFile = new File("core_" + coreNumber + "_cycleData.json");

            // Create a data structure to hold cycle data
            CycleData cycleData = new CycleData(cycle1ActivityData, cycle2ActivityData);
            mapper.writeValue(jsonFile, cycleData);

            System.out.println("Cycle data saved for core " + coreNumber + " at " + jsonFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper class to structure cycle data for JSON
    private static class CycleData {
        public List<Float> cycle1ActivityData;
        public List<Float> cycle2ActivityData;

        public CycleData(List<Float> cycle1Data, List<Float> cycle2Data) {
            this.cycle1ActivityData = cycle1Data;
            this.cycle2ActivityData = cycle2Data;
        }
    }
}

