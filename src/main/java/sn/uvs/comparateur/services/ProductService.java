package sn.uvs.comparateur.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.uvs.comparateur.entities.Product;
import sn.uvs.comparateur.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Récupère tous les produits de la base de données
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Recherche full-text de produits par mots-clés et tri par prix croissant
    public List<Product> searchProductsBasic(String keywords){
        return productRepository.findByKeywordsBasic(keywords);
    }

    // Recherche de produits par nom en utilisant une expression régulière et tri par prix croissant
    public List<Product> searchProductByNameBasic(String name) {
        return productRepository.findProductsByNameRegexAndOrderByPriceAsc(name);
    }

    // Recherche full-text de produits par mots-clés et tri par prix croissant et score décroissant
    public List<Product> searchProducts(String keywords) {
        return productRepository.findByKeywords(keywords);
    }

    // Recherche de produits par nom en utilisant une expression régulière et tri par prix croissant et score décroissant
    public List<Product> searchProductsByName(String name) {
        return productRepository.findProductByNameRegex(name);
    }

}



