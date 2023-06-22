package sn.uvs.comparateur.repositories;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import sn.uvs.comparateur.entities.Product;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository <Product, String> {

    // Recherche de produits par mots-clés de base et tri par prix croissant
    @Aggregation(pipeline = {
            "{$match: { $text: { $search: ?0 } } }",
            "{$sort: { price: 1} }"
    })
    List<Product> findByKeywordsBasic(String keywords);

    // Recherche de produits par nom en utilisant une expression régulière et tri par prix croissant
    @Aggregation(pipeline = {
            "{'$match':{'name':{$regex : ?0, $options: 'i'}}}",
            "{'$sort':{'price': 1 }}"
    })
    List<Product> findProductsByNameRegexAndOrderByPriceAsc(String name);

    // Recherche de produits par mots-clés et tri par prix croissant, avec un tri secondaire par score décroissant
    @Aggregation(pipeline = {
            "{$match: { $text: { $search: ?0 } } }",
            "{$sort: { price: 1, 'score': -1 } }"
    })
    List<Product> findByKeywords(String keywords);

    // Recherche de produits par nom en utilisant une expression régulière, avec un tri par prix croissant
    // et un tri secondaire par score décroissant
    @Aggregation(pipeline = {
            "{'$match':{'name':{$regex : ?0, $options: 'i'}}}",
            "{'$sort':{'price': 1, 'score': -1 }}"
    })
    List <Product> findProductByNameRegex(String name);
}



