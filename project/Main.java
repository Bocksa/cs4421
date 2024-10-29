import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MainMenu();
    }

    /// <summary>Displays the main menu.</summary>
    public static void MainMenu() {
        try {
            Scanner sc = new Scanner(System.in);

            final String ANSI_RESET = "\u001B[0m";
            final String ANSI_BLACK = "\u001B[30m";
            final String ANSI_RED = "\u001B[31m";
            final String ANSI_GREEN = "\u001B[32m";
            final String ANSI_YELLOW = "\u001B[33m";
            final String ANSI_BLUE = "\u001B[34m";
            final String ANSI_PURPLE = "\u001B[35m";
            final String ANSI_CYAN = "\u001B[36m";
            final String ANSI_WHITE = "\u001B[37m";

            while (true) {
                System.out.println("\n" + ANSI_RED +
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
                        "░╚════╝░╚═╝░░░░░░░░╚═╝░░░╚═╝░╚════╝░╚═╝░░╚══╝  ╚═════╝░╚══════╝╚══════╝░╚════╝░░░░╚═╝░░░╚═╝░░╚═╝" + ANSI_RESET);


                System.out.println("\n█████████████████████████████████████████████████████████████████████████████████████████████████" + ANSI_RESET);



                System.out.println(ANSI_PURPLE + "\n" +
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
                        "╚═════╝░╚═╝  ░╚═════╝░╚═════╝░╚═════╝░    ░░░░░╚═╝╚═╝  ╚═════╝░╚═╝╚═════╝░╚═╝░░╚═╝" + ANSI_RESET);


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
                        case 5:
                            MemoryMenu();
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

    /// <summary>Clears the console.</summary>
    public static void ClearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /// <summary>Displays all the information in the CPU menu.</summary>
    public static void CPUMenu() {
        CPUReader cpu = new CPUReader();
        cpu.DisplayInformation();
    }

    /// <summary>Displays all the information in the disk menu.</summary>
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

    /// <summary>Displays all the information in the CPU menu.</summary>
    public static void MemoryMenu() {
        MemoryReader memory = new MemoryReader();
        memory.DisplayMemoryInformation();
    }
}
