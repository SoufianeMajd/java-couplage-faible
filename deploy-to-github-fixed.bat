@echo off
setlocal enabledelayedexpansion

echo ================================================
echo   DEPLOIEMENT VERS GITHUB - VERSION CORRIGEE
echo ================================================
echo.

echo [1/7] Resolution probleme de securite Git...
git config --global --add safe.directory "D:/JAVA/TP"
echo ✅ Probleme de securite resolu

echo [2/7] Verification du dossier Git...
if not exist .git (
    echo ❌ Ce n'est pas un repository Git
    echo Initialisation Git...
    git init
)

echo [3/7] Configuration Git...
git remote remove origin 2>nul
git remote add origin https://github.com/SoufianeMajd/java-couplage-faible.git

echo [4/7] Ajout de tous les fichiers...
git add .

echo [5/7] Commit des modifications...
git commit -m "🚀 Version 2.0 - Projet couplage faible ameliore" -m "Nouvelles fonctionnalites :" -m "- Configuration unifiee pour les 3 versions" -m "- Gestion robuste des erreurs" -m "- Code Java moderne sans methodes depreciees" -m "- Messages de log ameliores" -m "" -m "Ameliorations :" -m "- Injection statique configurable" -m "- Injection dynamique avec reflexion moderne" -m "- Spring Framework avec XML corrige" -m "- Structure de packages coherente"

echo [6/7] Push vers GitHub...
git branch -M main
git push -f origin main

if %errorlevel% equ 0 (
    echo.
    echo ✅ PROJET DEPLOYE AVEC SUCCES!
    echo.
    echo 📍 Lien: https://github.com/SoufianeMajd/java-couplage-faible
    echo.
    echo 📋 Resume des modifications:
    echo - Structure: dao/, metier/, pres/
    echo - 3 versions: Statique, Dynamique, Spring
    echo - Configuration unifiee
    echo - Code Java moderne
) else (
    echo.
    echo ❌ Erreur lors du deploiement
    echo.
    echo Tentative alternative...
    git push -u origin main
)

echo.
pause