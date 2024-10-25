import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

/*
 *  Example class containing methods to read and display CPU, PCI, and USB information
 */
public class template {

    // Display CPU information in a JFrame
    public static void showCPUWindow() {
        cpuInfo cpu = new cpuInfo();
        cpu.read(0);

        StringBuilder cpuInfoText = new StringBuilder();
        cpuInfoText.append("CPU ").append(cpu.getModel())
                .append(" has ").append(cpu.socketCount()).append(" sockets each with ")
                .append(cpu.coresPerSocket()).append(" cores.\n")
                .append("L1d Cache Size: ").append(cpu.l1dCacheSize()).append(" KB\n")
                .append("L1i Cache Size: ").append(cpu.l1iCacheSize()).append(" KB\n")
                .append("L2 Cache Size: ").append(cpu.l2CacheSize()).append(" KB\n")
                .append("L3 Cache Size: ").append(cpu.l3CacheSize()).append(" KB\n");

        cpu.read(1);
        cpuInfoText.append("Core 1 Idle Time: ").append(cpu.getIdleTime(1)).append("%\n");

        // Create window to display CPU info
        JFrame frame = new JFrame("CPU Information");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JLabel label = new JLabel("<html>" + cpuInfoText.toString().replace("\n", "<br>") + "</html>");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(label, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    // Display PCI information in a JFrame
    public static void showPCIWindow() {
        pciInfo pci = new pciInfo();
        pci.read();

        StringBuilder pciInfoText = new StringBuilder();
        pciInfoText.append("This machine has ").append(pci.busCount()).append(" PCI buses.\n");

        for (int i = 0; i < pci.busCount(); i++) {
            pciInfoText.append("Bus ").append(i).append(" has ").append(pci.deviceCount(i)).append(" devices.\n");
            for (int j = 0; j < 32; j++) {
                if (pci.functionCount(i, j) > 0) {
                    pciInfoText.append("Bus ").append(i).append(" device ").append(j)
                            .append(" has ").append(pci.functionCount(i, j)).append(" functions.\n");

                    for (int k = 0; k < 8; k++) {
                        if (pci.functionPresent(i, j, k) > 0) {
                            pciInfoText.append("Bus ").append(i).append(" device ").append(j)
                                    .append(" function ").append(k)
                                    .append(" has vendor ").append(String.format("0x%04X", pci.vendorID(i, j, k)))
                                    .append(" and product ").append(String.format("0x%04X", pci.productID(i, j, k)))
                                    .append(".\n");
                        }
                    }
                }
            }
        }

        // Create window to display PCI info
        JFrame frame = new JFrame("PCI Information");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        JLabel label = new JLabel("<html>" + pciInfoText.toString().replace("\n", "<br>") + "</html>");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(label, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    // Display USB information in a JFrame
    public static void showUSBWindow() {
        usbInfo usb = new usbInfo();
        usb.read();

        StringBuilder usbInfoText = new StringBuilder();
        usbInfoText.append("This machine has ").append(usb.busCount()).append(" USB buses.\n");

        for (int i = 1; i <= usb.busCount(); i++) {
            usbInfoText.append("Bus ").append(i).append(" has ").append(usb.deviceCount(i)).append(" devices.\n");

            for (int j = 1; j <= usb.deviceCount(i); j++) {
                usbInfoText.append("Bus ").append(i).append(" device ").append(j)
                        .append(" has vendor ").append(String.format("0x%04X", usb.vendorID(i, j)))
                        .append(" and product ").append(String.format("0x%04X", usb.productID(i, j)))
                        .append(".\n");
            }
        }

        // Create window to display USB info
        JFrame frame = new JFrame("USB Information");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JLabel label = new JLabel("<html>" + usbInfoText.toString().replace("\n", "<br>") + "</html>");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(label, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        System.loadLibrary("sysinfo");

        // Take input from the terminal
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose which information to display:");
        System.out.println("1. CPU Information");
        System.out.println("2. PCI Information");
        System.out.println("3. USB Information");

        // Ensure valid input
        while (true) {
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();

                // Based on the user input, open a specific window
                switch (choice) {
                    case 1:
                        SwingUtilities.invokeLater(() -> showCPUWindow());
                        break;
                    case 2:
                        SwingUtilities.invokeLater(() -> showPCIWindow());
                        break;
                    case 3:
                        SwingUtilities.invokeLater(() -> showUSBWindow());
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                        continue; // Loop again for valid input
                }
                break; // Exit the loop after valid input is received
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume invalid input
            }
        }
    }
}
