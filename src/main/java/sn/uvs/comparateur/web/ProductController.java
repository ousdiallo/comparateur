package sn.uvs.comparateur.web;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sn.uvs.comparateur.entities.Product;
import sn.uvs.comparateur.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @Operation(summary = "Récupérer tous les produits", description = "Cette méthode permet de récupérer la liste de tous les produits qui se trouvent dans la base de données.")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/searchbasic")
    @Operation(summary = "Recherche simple de produits", description = "Cette méthode permet de rechercher un produit par mot-clé en ordonnant les résulats par ordre croissant de prix")
    public ResponseEntity<List<Product>> searchProductsBasic(@RequestParam("k") String keywords) {
        List<Product> results = productService.searchProductByNameBasic(keywords);
        if (results.size() >= 1) {
            return new ResponseEntity<>(results, HttpStatus.OK);
        } else {
            results = productService.searchProductsBasic(keywords);
            if (results.size() == 0) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(results, HttpStatus.OK);
        }
    }

    @GetMapping("/search")
    @Operation(summary = "Recherche complet de produits", description = "Cette méthode permet de rechercher un produit par mot-clé en ordonnant les résulats par ordre croissant de prix et décroissant de score")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam("k") String keywords) {
        List<Product> results = productService.searchProductsByName(keywords);
        if (results.size() >= 1) {
            return new ResponseEntity<>(results, HttpStatus.OK);
        } else {
            results = productService.searchProducts(keywords);
            if (results.size() == 0) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(results, HttpStatus.OK);
        }
    }
}



