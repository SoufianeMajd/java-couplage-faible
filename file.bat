# 1. Résoudre l'erreur de sécurité
git config --global --add safe.directory "D:/JAVA/TP"

# 2. Initialiser Git si besoin
git init

# 3. Configurer le remote
git remote add origin https://github.com/SoufianeMajd/java-couplage-faible.git

# 4. Configurer user
git config user.name "SoufianeMajd"
git config user.email "majdsoufiane55@gmail.com"

# 5. Ajouter tous les fichiers
git add .

# 6. Faire le commit
git commit -m "V2.0 - Projet couplage faible ameliore"

# 7. Changer de branche et pousser
git branch -M main
git push -f origin main