package dao; 
 
public class DaoImpl implements IDao { 
    @Override 
    public double getData() { 
        System.out.println("[DAO] Version Base de donnees"); 
        double data = Math.random() * 100; 
        System.out.println("[DAO] Donnee recuperee: " + data); 
        return data; 
    } 
} 
