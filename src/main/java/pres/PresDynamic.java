package pres;

import dao.IDao;
import metier.MetierImpl;
import java.io.InputStream;
import java.util.Properties;

/**
 * Presentation avec couplage faible dynamique
 * Chargement des implementations via fichier de configuration
 */
public class PresDynamic {
    public static void main(String[] args) throws Exception {
        System.out.println("=== INJECTION DYNAMIQUE (Couplage Faible) ===");

        // Chargement de la configuration depuis les ressources
        Properties properties = new Properties();
        String daoClass = "dao.DaoImpl"; // Valeur par défaut

        try (InputStream inputStream = PresDynamic.class.getClassLoader().getResourceAsStream("config_dynamic.txt")) {
            if (inputStream != null) {
                properties.load(inputStream);
                daoClass = properties.getProperty("dao");
                System.out.println("📁 Classe DAO configurée: " + daoClass);
            } else {
                System.out.println("⚠️  Fichier config_dynamic.txt non trouvé, utilisation de la valeur par défaut: " + daoClass);
            }
        }

        // Vérification que daoClass n'est pas null
        if (daoClass == null || daoClass.trim().isEmpty()) {
            System.err.println("❌ Erreur: La classe DAO n'est pas définie dans la configuration");
            daoClass = "dao.DaoImpl"; // Valeur de secours
            System.out.println("🔄 Utilisation de la classe par défaut: " + daoClass);
        }

        // Creation dynamique via Reflection
        Class<?> cDao = Class.forName(daoClass);
        IDao dao = (IDao) cDao.getDeclaredConstructor().newInstance();

        MetierImpl metier = new MetierImpl();
        metier.setDao(dao);

        double result = metier.calcul();
        System.out.println("✅ RESULTAT FINAL: " + result);
    }
}