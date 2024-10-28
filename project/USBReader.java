/*
 * Written by Cian McNamara.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class USBReader {
    public void DisplayUSBInfo() {
        System.loadLibrary("sysinfo");

        usbInfo usb = new usbInfo();
        usb.read();

        System.out.println("USB Buses: " + usb.busCount());

        for (int bus = 1; bus <= usb.busCount(); bus++) {
            System.out.println("\tBus " + bus + ":" );
            for (int device = 1; device < usb.deviceCount(bus); device++) {
                String vendorAndProductString = getPCIVendorAndProductAsString(usb.vendorID(bus, device), usb.productID(bus, device));

                if (!vendorAndProductString.equals("Vendor INVALID and product \"INVALID\".")) {
                    System.out.println("\t\t " + vendorAndProductString);
                }
            }
        }
    }

    private String getPCIVendorAndProductAsString(int vendorID, int productID) {
        String VendorName = "INVALID";
        String ProductName = "INVALID";

        try {
            BufferedReader reader = new BufferedReader(new FileReader("project/usb_devices.csv"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] products = line.split(",");
                if (!products[0].equals("vendor")) {
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
