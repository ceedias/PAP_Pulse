/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

/**
 *
 * @author cesardias
 */
@ManagedBean
public class CheckBoxView {
    private String[] selectedCities;
    private String[] selectedCities2;
    private List<String> qtd_func;
    private List<SelectItem> cars;
    private String[] selectedCars;
     
    @PostConstruct
    public void init() {
        qtd_func = new ArrayList<String>();
        qtd_func.add("1 a 50");
        qtd_func.add("51 a 150");
        qtd_func.add("151 a 800");
        qtd_func.add("800 a 3000");
        qtd_func.add("Acima de 3000");
        
    }
}
