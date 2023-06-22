# Comparateur de Prix - API REST

API REST comparateur de prix au Sénégal ! Cette API permet aux utilisateurs d'obtenir des informations sur les prix des produits dans différents magasins afin de faciliter la comparaison et de prendre des décisions d'achat éclairées.

## Fonctionnalités

- Affichage de tous les produits
- Recherche de produits par mot-clé et le résultats par ordre de prix croissant.
- Recherche de produits par mot-clé et le résultats par ordre de prix croissant et de score décroissant. 
- Comparaison des prix des produits entre différents magasins.

## Configuration requise

- Java 17
- Maven
- MongoDB

## Installation et exécution

1. Clonez ce référentiel sur votre machine locale.

2. Configurez votre base de données MongoDB et mettez à jour les paramètres de connexion dans le fichier `application.properties`.

3. Exécutez la commande suivante pour lancer l'application :

   ```shell
   mvn spring-boot:run

## Documentation de l'API

L'API est documentée avec OpenAPI (Swagger) pour faciliter l'intégration et la compréhension. Vous pouvez accéder à la documentation interactive en exécutant l'application et en visitant l'URL **http://localhost:8080/swagger-ui.html**.
