package sn.uvs.comparateur.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Product {
    @Id
    private String id;
    @TextIndexed
    private String title;
    private String category;
    private String brand;
    private String name;
    private double price;
    private double score;
    private int nbreviews;
    private String image;
    private String url;
}


