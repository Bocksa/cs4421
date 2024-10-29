public class DiskReader {
    diskInfo disk;

   // public native void read ();
    //public native int diskCount ();
   // public native String getName (int disk);
  //  public native long getTotal (int disk);
   // public native long getUsed (int disk);
   // public native long getAvailable (int disk)

    /// <summary>Disk Info initialiser, sets up the object.</summary>
    public DiskReader() {
        this.disk = new diskInfo();
    }

    /// <summary>Displays all the disk information in the console.</summary>
    public void DisplayDiskInfo() {
        System.loadLibrary("sysinfo");
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
