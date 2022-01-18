/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anjana Deshan
 */
public class srch {
        private int id;
    private String name;
    private String vno;
    private String bdate;
//id,c_Name, vehino,Bill date
    public srch(int Id, String Name, String Vno, String  Bdate) {
        this.id = Id;
        this.name = Name;
        this.vno = Vno;
        this.bdate = Bdate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getVno() {
        return vno;
    }

    public String getBdate() {
        return bdate;
    }
}

