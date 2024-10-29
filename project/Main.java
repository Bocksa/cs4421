import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MainMenu();
    }

    /// <summary>Displays the main menu.</summary>
    public static void MainMenu() {
        try {
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\n" +
                        "░██████╗███████╗██╗░░░░░███████╗░█████╗░████████╗  ░█████╗░███╗░░██╗\n" +
                        "██╔════╝██╔════╝██║░░░░░██╔════╝██╔══██╗╚══██╔══╝  ██╔══██╗████╗░██║\n" +
                        "╚█████╗░█████╗░░██║░░░░░█████╗░░██║░░╚═╝░░░██║░░░  ███████║██╔██╗██║\n" +
                        "░╚═══██╗██╔══╝░░██║░░░░░██╔══╝░░██║░░██╗░░░██║░░░  ██╔══██║██║╚████║\n" +
                        "██████╔╝███████╗███████╗███████╗╚█████╔╝░░░██║░░░  ██║░░██║██║░╚███║\n" +
                        "╚═════╝░╚══════╝╚══════╝╚══════╝░╚════╝░░░░╚═╝░░░  ╚═╝░░╚═╝╚═╝░░╚══╝\n" +
                        "\n" +
                        "░█████╗░██████╗░████████╗██╗░█████╗░███╗░░██╗  ██████╗░███████╗██╗░░░░░░█████╗░░██╗░░░░░░░██╗██╗\n" +
                        "██╔══██╗██╔══██╗╚══██╔══╝██║██╔══██╗████╗░██║  ██╔══██╗██╔════╝██║░░░░░██╔══██╗░██║░░██╗░░██║╚═╝\n" +
                        "██║░░██║██████╔╝░░░██║░░░██║██║░░██║██╔██╗██║  ██████╦╝█████╗░░██║░░░░░██║░░██║░╚██╗████╗██╔╝░░░\n" +
                        "██║░░██║██╔═══╝░░░░██║░░░██║██║░░██║██║╚████║  ██╔══██╗██╔══╝░░██║░░░░░██║░░██║░░████╔═████║░░░░\n" +
                        "╚█████╔╝██║░░░░░░░░██║░░░██║╚█████╔╝██║░╚███║  ██████╦╝███████╗███████╗╚█████╔╝░░╚██╔╝░╚██╔╝░██╗\n" +
                        "░╚════╝░╚═╝░░░░░░░░╚═╝░░░╚═╝░╚════╝░╚═╝░░╚══╝  ╚═════╝░╚══════╝╚══════╝░╚════╝░░░░╚═╝░░░╚═╝░░╚═╝");
                System.out.println("\n" +
                        "░░███╗░░░░░  ░█████╗░██████╗░██╗░░░██╗    ██████╗░░░░  ██████╗░░█████╗░██╗  \n" +
                        "░████║░░░░░  ██╔══██╗██╔══██╗██║░░░██║    ╚════██╗░░░  ██╔══██╗██╔══██╗██║  \n" +
                        "██╔██║░░░░░  ██║░░╚═╝██████╔╝██║░░░██║    ░░███╔═╝░░░  ██████╔╝██║░░╚═╝██║  \n" +
                        "╚═╝██║░░░░░  ██║░░██╗██╔═══╝░██║░░░██║    ██╔══╝░░░░░  ██╔═══╝░██║░░██╗██║  \n" +
                        "███████╗██╗  ╚█████╔╝██║░░░░░╚██████╔╝    ███████╗██╗  ██║░░░░░╚█████╔╝██║  \n" +
                        "╚══════╝╚═╝  ░╚════╝░╚═╝░░░░░░╚═════╝░    ╚══════╝╚═╝  ╚═╝░░░░░░╚════╝░╚═╝  \n" +
                        "\n" +
                        "██████╗░░░░  ██╗░░░██╗░██████╗██████╗░    ░░██╗██╗░░░  ██████╗░██╗░██████╗██╗░░██╗\n" +
                        "╚════██╗░░░  ██║░░░██║██╔════╝██╔══██╗    ░██╔╝██║░░░  ██╔══██╗██║██╔════╝██║░██╔╝\n" +
                        "░█████╔╝░░░  ██║░░░██║╚█████╗░██████╦╝    ██╔╝░██║░░░  ██║░░██║██║╚█████╗░█████═╝░\n" +
                        "░╚═══██╗░░░  ██║░░░██║░╚═══██╗██╔══██╗    ███████║░░░  ██║░░██║██║░╚═══██╗██╔═██╗░\n" +
                        "██████╔╝██╗  ╚██████╔╝██████╔╝██████╦╝    ╚════██║██╗  ██████╔╝██║██████╔╝██║░╚██╗\n" +
                        "╚═════╝░╚═╝  ░╚═════╝░╚═════╝░╚═════╝░    ░░░░░╚═╝╚═╝  ╚═════╝░╚═╝╚═════╝░╚═╝░░╚═╝");


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
                        case 4:
                            DiskMenu();
                            return;
                        default:
                            System.out.println("Invalid option, try again. \n");
                    }
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }
        } catch(RuntimeException e) {
            System.out.println("Invalid choice, please pick a number.\n");
            MainMenu();
        }
    }

    /// <summary></summary>
    public static void ClearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /// <summary>Displays all the information in the CPU menu.</summary>
    public static void CPUMenu() {
        CPUReader cpu = new CPUReader();
        cpu.DisplayInformation();
    }

    // Removed as it does not allow read to be run. (Tried with sysinfo loaded and unloaded, both options did not work. Template file also errors ever since the changes.)
    public static void DiskMenu() {
       DiskReader disk = new DiskReader();
       disk.DisplayDiskInfo();
    }

    /// <summary>Displays all the information in the PCI menu.</summary>
    public static void PCIMenu() {
        PCIReader pci = new PCIReader();
        pci.DisplayPCIInfo();
    }

    /// <summary>Displays all the information in the CPU menu.</summary>
    public static void USBMenu() {
        USBReader usb = new USBReader();
        usb.DisplayUSBInfo();
    }
}
