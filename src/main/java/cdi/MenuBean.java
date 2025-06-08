/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author Dell
 */
@Named(value = "menuBean")
@ViewScoped
public class MenuBean implements Serializable {

    private MenuModel model;

    @PostConstruct
    public void init() {
        model = new DefaultMenuModel();

//        DefaultMenuItem dashboard = new DefaultMenuItem("Dashboard");
//        dashboard.setIcon("pi pi-home");
//        dashboard.setOutcome("/dashboard");
//
//        DefaultMenuItem reports = new DefaultMenuItem("Login");
//        reports.setIcon("pi pi-chart-line");
//        reports.setOutcome("/index");
//
//        model.getElements().add(dashboard);
//        model.getElements().add(reports);
    }

    public MenuModel getModel() {
        return model;
    }

}
