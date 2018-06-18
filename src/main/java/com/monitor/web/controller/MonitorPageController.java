package com.monitor.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MonitorPageController {

    @RequestMapping("/")
    public String loadMainLayoutPage() {
        return "main-layout";
    }
    
    @RequestMapping("/dashboard")
    public String loadDashboardPage() {
        return "dashboard";
    }	
    
    @RequestMapping("/service")
    public String loadServicesPage() {
        return "service";
    }   
    
    @RequestMapping("/caller")
    public String loadCallersPage() {
        return "caller";
    }
    
    @RequestMapping("/service-subscription")
    public String loadServiceSubscriptionPage() {
        return "service-subscription";
    }         
}
