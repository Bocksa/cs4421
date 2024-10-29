/*
 * Written by Cian McNamara.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class USBReader {
    /// <summary>Prints the USB information to the console.</summary>
    public void DisplayUSBInfo() {
        System.loadLibrary("sysinfo");

        usbInfo usb = new usbInfo();
        usb.read();

        System.out.println("USB Buses: " + usb.busCount());

        for (int bus = 1; bus <= usb.busCount(); bus++) {
            System.out.println("\tBus " + bus + ":" );
            for (int device = 1; device <= usb.deviceCount(bus); device++) {
                String vendorAndProductString = getUSBVendorAndProductAsString(usb.vendorID(bus, device), usb.productID(bus, device));

                if (!vendorAndProductString.equals("UNKNOWN UNKNOWN")) { // making sure everything is set
                    System.out.println("\t\t\t" + vendorAndProductString);
                }
            }
        }
    }

    /// <summary>Outputs a string of the USB's vendor and product name split by a colon.</summary>
    /// @param vendorID The products vendor base 16 id.
    /// @param productID The products product base 16 id.
    private String getUSBVendorAndProductAsString(int vendorID, int productID) {
        String VendorName = "UNKNOWN";
        String ProductName = "UNKNOWN";

        try {
            BufferedReader reader = new BufferedReader(new FileReader("usb_devices.csv"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] products = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // splits a string by commas if its outside of quotes
                if (!products[0].equals("Vendor ID")) { // checking to see if its the title of the CSV file
                    if (Integer.parseInt(products[0], 16) == vendorID && Integer.parseInt(products[2], 16) == productID) {
                        VendorName = products[1];
                        ProductName = products[3];
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return VendorName + " " + ProductName;
    }
}
