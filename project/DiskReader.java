public class DiskReader {
    diskInfo disk = new diskInfo();
    int diskCount = disk.diskCount(); // Get the total number of disks

   // public native void read ();
    //public native int diskCount ();
   // public native String getName (int disk);
  //  public native long getTotal (int disk);
   // public native long getUsed (int disk);
   // public native long getAvailable (int disk);

        String name;          // Get disk name
        long totalSpace;     // Get total disk space
        long usedSpace ;       // Get used disk space
        long availableSpace; // Get available disk space */

    public DiskReader() {
        this.diskCount = disk.diskCount();
        this.availableSpace = disk.getAvailable(int disk);
        this.totalSpace = disk.getTotal(int disk);
        this.usedSpace = disk.getUsed();

        System.out.println("Disk " + i + ": " + name);
        System.out.println("Total Space: " + getTotal + " bytes");
        System.out.println("Used Space: " + getUsed + " bytes");
        System.out.println("Available Space: " + availableSpace + " bytes");


    }

}
