/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.DesignPatterns;

/**
 *
 * @author shivam
 */
public class ProxyPattern {

    public static void main(String[] args) {
        internetAccess access = new proxyOfficeInternet("Shivam");
        access.grantInternetAccess();
        internetAccess access1 = new proxyOfficeInternet("Shivam123");
        access1.grantInternetAccess();
    }
}

interface internetAccess {

    void grantInternetAccess();
}

class officeInternet implements internetAccess {

    private String employeeName;

    officeInternet(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public void grantInternetAccess() {
        System.out.println("Internet Access granted for employee: " + employeeName);
    }
}

class proxyOfficeInternet implements internetAccess {

    private String employeeName;
    private officeInternet realaccess;

    proxyOfficeInternet(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public void grantInternetAccess() {
        if (employeeName.equals("Shivam")) {
            realaccess = new officeInternet(employeeName);
            realaccess.grantInternetAccess();
        } else {
            System.out.println("No Internet access granted.");
        }
    }
}
