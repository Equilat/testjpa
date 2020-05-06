# Doodle Back, Hélène Heinlé et Emile Georget, M1 MIAGE, groupe 1B


## Contexte
L'objectif de ce projet était de créer une apllication permettant de réaliser des sondages afin d'organiser des réunions entre plusieurs participants. Ce fonctionnement est inspiré de la plateforme existante "Doodle".
Cette partie correspond au back end de l'application. ([front end](https://github.com/Equilat/DoodleFront))

## Base de données et entités JPA
Nous avons commencé par lister les éléments importants d'une application telle que Doodle. C'est ainsi que nous sommes arrivés au diagramme de classe suivant :


Nous sommes ensuite passés au développement en traduisant les classes précédentes en entités JPA.

## API REST
La partie Back-end présentée ici, devait permettre, au final, de fournir une liste de méthodes interrogeant la base de données et donc de servir d'API.

### Services
Dans le but d'implémenter l'API, nous avons implémenté des services.
Nous avons préféré mettre en place un service par entité dans l'ensembe. Ainsi, le service concernant l'entité Utilisateur peut être accessible sur l'url http://localhost:8080/api/user, "user" étant le chamin d'accès attribué au service. Les méthodes utilitaires contenues dans ce service ont elles aussi un chemin d'accès. Ainsi, pour lister tous les utilisateurs, il faudrait interroger l'url http://localhost:8080/api/user/all à l'aide d'une requête HTTP GET.

### Data Access Objects (DAO)
Afin de moduler l'application, nous avons créé des classes DAO. Ces classes sont celles qui ont accès à la base de données et qui peuvent effectuer les opérations CRUD sur celle-ci à l'aide de requêtes JPQL.

Les services ne requêtent pas la base directement mais font appel à des DAO.

## Point d'avancement
A ce jour, le back est complété avec toutes les entités décrites dans le diagramme ci-dessus. Cependant, il manque l'opération de suppression dans les services suite au problème décrit dans les issues du dépôt.



