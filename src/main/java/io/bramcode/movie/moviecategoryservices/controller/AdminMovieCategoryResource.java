package io.bramcode.movie.moviecategoryservices.controller;


import io.bramcode.movie.moviecategoryservices.model.entity.Category;
import io.bramcode.movie.moviecategoryservices.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/movie/v1/category")
public class AdminMovieCategoryResource {

    //Autowire (consumer) 
    //telling spring somebody has bean somewhere of type resttemplate inject me that thing
    //@Autowired
    //private RestTemplate restTemplate;

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/save")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public Category createCategory(@Valid @RequestBody Category category) {
         return category;
        //return categoryService.saveCategory(category);
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMIN_TRAINEE')")
    public List<Category> getAllCategory() {
        Category category = new Category();
        category.setCategoryId(1l);
        category.setCategoryName("Hollywood");
        return Arrays.asList(category);
        //return categoryService.retreiveAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('category:read')")
    public Category getCategory(@PathVariable(value = "id") Long categoryId) {
        Category category = new Category();
        category.setCategoryId(categoryId);

        return category;
        //return categoryService.retreiveById(categoryId);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMIN_TRAINEE')")
    public Category updateCategory(@PathVariable(value = "id") long categoryId,
                                   @Valid @RequestBody Category categoryDetails) {
        System.out.println("Update id : " + categoryId);

        return categoryDetails;
        //return categoryService.updateCategory(categoryId, categoryDetails);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public Map<String, Boolean> deleteCategory(@PathVariable(value = "id") long categoryId) {
        Map<String, Boolean> tempMap = new HashMap<>();
        tempMap.put("1", true);

        return tempMap;
        //System.out.println("Delete id : " + categoryId);
        //return categoryService.deleteCategory(categoryId);
    }

//    @RequestMapping("/{userId}")
//    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
//
//    //get all rated movied id
//
//    //for each movie id, call movie info service and get details
//
//    //put them all together
//
//   // RestTemplate restTemplate = new RestTemplate();
//
//
//    // List<Rating> ratings = Arrays.asList(
//    //     new Rating("1234",4),
//    //     new Rating("5678",3)
//    // );
//    UserRating userRating = restTemplate.getForObject("http://localhost:8083/ratingsdata/user/" + userId, UserRating.class);
//
//    return userRating.getUserRating().stream().map(rating -> {
//        //unmarshall object from rest template to object movie
//        //need empty constructor
//        Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" +rating.getMovieId(),Movie.class);
//        return new CatalogItem(movie.getMovieId(),"desc a", rating.getRating());
//    }).collect(Collectors.toList());
//
//    // return Collections.singletonList(
//    //     new CatalogItem("Transformer","Test",4)
//    // );
//    }
}
