public class DiskReader {
    diskInfo disk;

    /// <summary>Disk Info constructor, sets up the object.</summary>
    public DiskReader() {
        System.loadLibrary("sysinfo");
    }

    /// <summary>Displays all the disk information in the console.</summary>
    public void DisplayDiskInfo() {
        this.disk = new diskInfo();
        this.disk.read();

        System.out.println("Disk Count: " + this.disk.diskCount());

        for (int disk = 0; disk < this.disk.diskCount(); disk++) {

            System.out.println("\tDisk " + disk + ": "
                    + this.disk.getName(disk) + " "
                    + this.disk.getUsed(disk) + "/"
                    + this.disk.getTotal(disk) + "B");
        }
    }
}
