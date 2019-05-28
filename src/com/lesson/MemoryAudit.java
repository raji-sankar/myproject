package com.lesson;

import com.sun.management.HotSpotDiagnosticMXBean;

import javax.management.MBeanServer;
import java.io.IOException;
import java.lang.management.ManagementFactory;

public class MemoryAudit {

    private static final long MEGABYTE = 1024L * 1024L;
    private static final Runtime runtime = Runtime.getRuntime();

    public static void printBusyMemory(){
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println(String.format("Free memory: %d MB", (runtime.freeMemory() / MEGABYTE)));
        System.out.println(String.format("Occupied memory: %d MB", (memory / MEGABYTE)));
    }

    public static void printTotalMemory(){
        System.out.println(String.format("Total Program memory: %d MB", (runtime.totalMemory()/MEGABYTE)));
        System.out.println(String.format("Max Program memory: %d MB", (runtime.maxMemory()/MEGABYTE)));
    }

    public static void dumpHeap(String filePath, boolean live) throws IOException {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        HotSpotDiagnosticMXBean mxBean = ManagementFactory.newPlatformMXBeanProxy(
                server, "com.sun.management:type=HotSpotDiagnostic", HotSpotDiagnosticMXBean.class);
        mxBean.dumpHeap(filePath, live);
    }

    public static void main(String[] args) throws IOException {
        printTotalMemory();
        printBusyMemory();
        printTotalMemory();
        dumpHeap("C:\\Users\\Raji\\IdeaProjects\\myproject\\src\\com\\lesson\\heapdump.hprof", true);
        dumpHeap("C:\\Users\\Raji\\IdeaProjects\\myproject\\src\\com\\lesson\\heapdump2.hprof", false);
    }

}
