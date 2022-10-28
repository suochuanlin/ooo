package com.myooo.myooo.service;

import java.util.ServiceLoader;

public class SpiMain {
    public static void main(String[] args) {
        ServiceLoader<ITestspi> aTestspis = ServiceLoader.load(ITestspi.class);
        for (ITestspi u : aTestspis) {
            u.upload("filePath");
        }
    }
}
