# UCE Génie Logiciel Avancé : Techniques de tests

## Introduction

Vous allez à travers ces projet mettre en application une partie des aspects évoqués en cours vis à vis des techniques de tests.  
Pour cela nous allons réaliser un projet logiciel de petite taille, en suivant la roadmap suivante : 
- Setup du projet
- Mise en place des outils d’intégration continue
- Écriture des tests unitaires
- Écriture des mocks, et validation des tests
- Développement dirigé par les tests
- Documentation et conventions de style
- Test d'une implémentation donnée

Durant cette série de TPs, le gestionnaire de version Git sera utilisé à foison, à travers la plateforme GitHub. Si vous n’êtes pas à l’aise avec cet outil[^1], [voici](http://rogerdudler.github.io/git-guide/) un petit guide à garder sous la main.

## Sujets

L'ensemble des sujets de TPs peut être trouvé dans le dossier `TPs`.

Le dossier `src` contient la définition de l'ensemble des interfaces qui seront l'objet de vos travaux.

## Rendus

Le rendu des TPs se fait au rythme suivant :

- TP1 : 2ème séance
- TP2 : 2ème séance
- TP3 : 3ème séance
- TP4 : 5ème séance
- TP5 : dernière séance
- TP6 : dernière séance

Pour chaque rendu vous devez créer un tag à partir du commit qui correspond à la complétion du TP.  
Si vous ne spécifiez pas de tag, le dernier commit à la date-heure de la fin de séance sera celui considéré.

## Fait par qui ?

Grégoire Pierrot, M1 ILSEN, groupe 1

## État du projet

CircleCi : [![CircleCI](https://dl.circleci.com/status-badge/img/circleci/STVR3NFqmXMnaGC6xojpXQ/c60fca33-5ac7-4634-9bbb-c1528742fba2/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/circleci/STVR3NFqmXMnaGC6xojpXQ/c60fca33-5ac7-4634-9bbb-c1528742fba2/tree/master)

CodeCov : [![codecov](https://codecov.io/gh/Gregoire-Pierrot/ceri-m1-techniques-de-test/graph/badge.svg?token=KBY7SUO60T)](https://codecov.io/gh/Gregoire-Pierrot/ceri-m1-techniques-de-test)

Conformité du style : ![Checkstyle Conformity](https://img.shields.io/badge/Checkstyle-100%25-brightgreen)

## Documentations sur l'implémentation

Changement sur les fichiers déjà présents :
- [IPokemonFactory.java](src/main/java/fr/univavignon/pokedex/api/IPokemonFactory.java) : modification sur la méthode `createPokemon` -> rajout des metadatas de l'espèce du pokemon à créer et suppression de l'index déjà présent dans les metadatas.

Précision sur l'implémentation :
- Les classes [PokedexFactory](src/main/java/fr/univavignon/pokedex/api/PokedexFactory.java), [PokemonFactory](src/main/java/fr/univavignon/pokedex/api/PokemonFactory.java), [PokemonMetadataProvider](src/main/java/fr/univavignon/pokedex/api/PokemonMetadataProvider.java), [PokemonTrainerFactory](src/main/java/fr/univavignon/pokedex/api/PokemonTrainerFactory.java) sont définies en singleton puisqu'elles représentent une manière prédéfini de création d'objet ou une liste prédéfinie de metadata. Leurs interfaces quand à elles ne contiennent pas la méthode `getInstance` puisqu'il est possible de créer une classe inmplémentant l'une d'elle qui définis une liste ou une méthode de création à l'instanciation d'un de ses objets.

[^1]: Si vous n’êtes vraiment pas à l’aise avec cet outil nous vous conseillons quand même vivement de vous y mettre.

## TP6

#### Problèmes

- Le package n'est pas le bon. Fichier mal placé.

- La déclaration de la méthode createPokemon a changer

- Dans le cas ou on créer un pokemon avec l'index -1; les variables : attack, defense et stamina ne sont pas entre 0 et 15 -> Problème dans les tests.

- La génération de random doit se faire entre 0 et 15 et non pas avec un boucle qui boucle 1000000x -> Problème dans les tests.

- Pas besoin de faire une Map. Les metadata doivent être passer dans la méthode createPokemon.

- Un TODO est présent.

- Redondance d'import : IPokemonFactory et Pokemon

- Problème de style avec les tabulations.

- JavaDoc manquante.

- La méthode generateRandomStat ne devrait pas être static.