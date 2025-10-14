@echo off
echo Deploiement simple vers GitHub...

:: Resoudre l'erreur de securite
git config --global --add safe.directory "D:/JAVA/TP" 2>nul

:: Initialiser Git si besoin
if not exist .git (
    echo Initialisation du repository Git...
    git init
)

:: Configurer le remote
git remote remove origin 2>nul
git remote add origin https://github.com/SoufianeMajd/java-couplage-faible.git

:: Configurer user minimal sans demande
git config user.name "SoufianeMajd" 2>nul
git config user.email "majdsoufiane55@gmail.com" 2>nul

:: Ajouter tous les fichiers
git add .

:: Faire le commit
git commit -m "🚀 Version 2.0 - Projet couplage faible ameliore" 2>nul

if %errorlevel% neq 0 (
    echo Configuration Git manquante, utilisation de config globale...
    git config --global user.name "SoufianeMajd" 2>nul
    git config --global user.email "soufiane@example.com" 2>nul
    git commit -m "🚀 Version 2.0 - Projet couplage faible ameliore"
)

:: Changer de branche et pousser
git branch -M main
git push -f origin main

echo.
if %errorlevel% equ 0 (
    echo ✅ Deploiement reussi!
    echo Lien: https://github.com/SoufianeMajd/java-couplage-faible
) else (
    echo ❌ Erreur, verification des identifiants...
    echo Tentative avec authentification classique...
    git push -u origin main
)

pause