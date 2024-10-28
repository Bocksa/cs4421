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
            for (int device = 1; device <= usb.deviceCount(bus); device++) {
                System.out.println(String.format("\t\tVendor 0x%04X Product 0x%04X", usb.vendorID(bus, device), usb.productID(bus, device)));
            }
        }
    }
}
