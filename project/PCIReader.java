/*
 * Written by Cian McNamara.
 */

import java.io.*;

public class PCIReader {
    private pciInfo pci;

    public PCIReader() {
        this.pci = new pciInfo();
    }

    public void DisplayPCIInfo() {
        System.loadLibrary("sysinfo");
        this.pci.read();

        System.out.println("PCI Buses: " + this.pci.busCount());

        for (int bus = 0; bus < this.pci.busCount(); bus++) {
            System.out.println("\tBus " + bus + " has " + this.pci.deviceCount(bus) + " device(s): ");

            for (int device = 0; device < this.pci.deviceCount(bus); device++) {
                if (this.pci.functionCount(bus, device) > 0) {
                    System.out.println("\t\tDevice " + device + " has:");

                    for (int function = 0; function < 8; function++) {
                        String vendorAndProductString = getPCIVendorAndProductAsString(this.pci.vendorID(bus, device, function), this.pci.productID(bus, device, function));

                        if (!vendorAndProductString.equals("Vendor INVALID and product \"INVALID\".")) {
                            System.out.println("\t\t\t" + vendorAndProductString);
                        }
                    }
                }
            }
        }
    }

    private String getPCIVendorAndProductAsString(int vendorID, int productID) {
        String VendorName = "INVALID";
        String ProductName = "INVALID";

        try {
            BufferedReader reader = new BufferedReader(new FileReader("pci_devices.csv"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] products = line.split(",");
                if (!products[0].equals("Vendor ID")) {
                    if (Integer.parseInt(products[0], 16) == vendorID && Integer.parseInt(products[2], 16) == productID) {
                        VendorName = products[1];
                        ProductName = products[3];
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Vendor " + VendorName + " and product \"" + ProductName + "\".";
    }
}
