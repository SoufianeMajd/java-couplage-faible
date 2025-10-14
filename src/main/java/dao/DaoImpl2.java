package dao; 
 
public class DaoImpl2 implements IDao { 
    @Override 
    public double getData() { 
        System.out.println("[DAO] Version Capteurs"); 
        double data = 42.5; 
        System.out.println("[DAO] Valeur capteur: " + data); 
        return data; 
    } 
} 
