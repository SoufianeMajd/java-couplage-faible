package metier; 
 
import dao.IDao; 
 
public class MetierImpl implements IMetier { 
    private IDao dao; 
 
    // Setter pour l'injection de dependance 
    public void setDao(IDao dao) { 
        this.dao = dao; 
    } 
 
    @Override 
    public double calcul() { 
        System.out.println("[METIER] Debut du calcul..."); 
        double data = dao.getData(); 
        double result = data * 10 + 5; 
        System.out.println("[METIER] Calcul: " + data + " * 10 + 5 = " + result); 
        return result; 
    } 
} 
