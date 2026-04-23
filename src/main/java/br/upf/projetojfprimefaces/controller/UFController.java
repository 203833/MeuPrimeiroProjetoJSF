package br.upf.projetojfprimefaces.controller;

import br.upf.projetojfprimefaces.enumeration.UFEnum;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;

import java.io.Serializable;

@Named(value = "ufController")
@SessionScoped
public class UFController implements Serializable {
    
    public SelectItem[] getUFs() {
        SelectItem[] items = new SelectItem[UFEnum.values().length];
        int i = 0;
        for (UFEnum t : UFEnum.values()) {
            items[i++] = new SelectItem(t, t.getValue());
        }
        return items;
    }
}