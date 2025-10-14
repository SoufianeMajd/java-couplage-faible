package pres;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Presentation avec Spring Framework (Injection XML)
 * Configuration via fichier applicationContext.xml
 */
public class TestApplication {
    public static void main(String[] args) {
        System.out.println("=== SPRING FRAMEWORK (Injection XML) ===");

        // Chargement du contexte Spring
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // Récupération du bean via le conteneur IoC - SANS CAST
        Object metierBean = context.getBean("metier");

        // Utilisation de la réflexion pour appeler la méthode calcul()
        try {
            java.lang.reflect.Method calculMethod = metierBean.getClass().getMethod("calcul");
            double result = (double) calculMethod.invoke(metierBean);
            System.out.println(">>> Resultat final: " + result);
        } catch (Exception e) {
            System.err.println("Erreur: " + e.getMessage());
            e.printStackTrace();
        }
    }
}