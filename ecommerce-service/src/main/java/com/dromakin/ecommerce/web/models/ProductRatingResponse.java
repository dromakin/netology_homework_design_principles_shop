/*
 * File:     ProductRatingResponse
 * Package:  com.dromakin.ecommerce.models
 * Project:  netology_homework_design_principles_shop
 *
 * Created by dromakin as 06.04.2023
 *
 * author - dromakin
 * maintainer - dromakin
 * version - 2023.04.06
 * copyright - ORGANIZATION_NAME Inc. 2023
 */
package com.dromakin.ecommerce.web.models;


import lombok.*;

@Builder
@ToString
public class ProductRatingResponse {

    @Setter(AccessLevel.PUBLIC)
    @Getter(AccessLevel.PUBLIC)
    @ToString.Include
    private String productCode;

    @Setter(AccessLevel.PUBLIC)
    @Getter(AccessLevel.PUBLIC)
    @ToString.Include
    private Rating productRating;

    public enum Rating {
        THE_BEST(5), GOOD(4), NORMAL(3), BAD(2), THE_WORST(1), NODATA(0);

        @Getter(AccessLevel.PUBLIC)
        private final Integer stars;

        Rating(Integer stars) {
            this.stars = stars;
        }


    }
}
