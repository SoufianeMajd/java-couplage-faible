package pres;

import dao.DaoImpl;
import dao.DaoImpl2;
import metier.MetierImpl;
import java.io.InputStream;
import java.util.Properties;

/**
 * Presentation avec injection statique configurable
 * Dependance aux implementations mais choix via configuration
 */
public class PresStatic {
    public static void main(String[] args) throws Exception {
        System.out.println("=== INJECTION STATIQUE CONFIGURABLE ===");

        // Chargement de la configuration
        Properties properties = new Properties();
        String daoClass = "dao.DaoImpl"; // Valeur par défaut

        try (InputStream inputStream = PresStatic.class.getClassLoader().getResourceAsStream("config_static.txt")) {
            if (inputStream != null) {
                properties.load(inputStream);
                daoClass = properties.getProperty("dao");
                System.out.println("📁 Configuration chargée: " + daoClass);
            } else {
                System.out.println("⚠️  Fichier config_static.txt non trouvé, utilisation de la valeur par défaut");
            }
        }

        // Vérification et sélection de l'implémentation
        if (daoClass == null || daoClass.trim().isEmpty()) {
            daoClass = "dao.DaoImpl";
        }

        MetierImpl metier = new MetierImpl();

        if ("dao.DaoImpl".equals(daoClass)) {
            DaoImpl dao = new DaoImpl();
            metier.setDao(dao);
            System.out.println("🔧 Utilisation de dao.DaoImpl (Base de données)");
        } else if ("dao.DaoImpl2".equals(daoClass)) {
            DaoImpl2 dao = new DaoImpl2();
            metier.setDao(dao);
            System.out.println("🔧 Utilisation de dao.DaoImpl2 (Capteurs)");
        } else {
            System.err.println("❌ Classe DAO inconnue: " + daoClass + ", utilisation de DaoImpl par défaut");
            DaoImpl dao = new DaoImpl();
            metier.setDao(dao);
        }

        double result = metier.calcul();
        System.out.println("✅ RESULTAT FINAL: " + result);
    }
}