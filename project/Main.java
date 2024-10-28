import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Select an option below:");
            System.out.println("1. CPU Info");
            System.out.println("2. PCI Info");
            System.out.println("3. USB Info");

            int input = sc.nextInt();

            ClearScreen();

            try {
                switch (input) {
                    case 1:
                        CPUMenu();
                        return;
                    case 2:
                        PCIMenu();
                        return;
                    case 3:
                        USBMenu();
                        return;
                    default:
                        System.out.println("Invalid option, try again. \n");
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    }

    public static void ClearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void CPUMenu() {
        CPUReader cpu = new CPUReader();
        cpu.DisplayInformation();
    }

    // Removed as it does not allow read to be run. (Tried with sysinfo loaded and unloaded, both options did not work. Template file also errors ever since the changes.)
    public static void DiskMenu() {
        System.out.println("\ndiskInfo class currently has an error when you run diskInfo.read(). As a result it is not being used currently.\n");
    }

    public static void PCIMenu() {
        PCIReader pci = new PCIReader();
        pci.DisplayPCIInfo();
    }

    public static void USBMenu() {
        USBReader usb = new USBReader();
        usb.DisplayUSBInfo();
    }
}
