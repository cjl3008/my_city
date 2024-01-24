package com.example.mycity.data

import androidx.annotation.StringRes
import com.example.mycity.R
import com.example.mycity.model.Category
import com.example.mycity.model.Outlet

object MyCityDataProvider {
    val categories = listOf(
        Category(
            name = R.string.coffee_shops,
            thumbnail = R.drawable.coffee_shop_1,
            recommendations = listOf(
                Outlet(
                    name = R.string.java_jive,
                    image = R.drawable.coffee_shop_1,
                    category = R.string.coffee_shops,
                    content = R.string.java_jive_content,
                    selected = true
                ),
                Outlet(
                    name = R.string.brew_haven,
                    image = R.drawable.coffee_shop_2,
                    category = R.string.coffee_shops,
                    content = R.string.brew_haven_content,
                ),
                Outlet(
                    name = R.string.cosmic_cup,
                    image = R.drawable.coffee_shop_3,
                    category = R.string.coffee_shops,
                    content = R.string.cosmic_cup_content,
                )
            ),
            selected = true
        ),
        Category(
            name = R.string.restaurants,
            thumbnail = R.drawable.restaurant_4,
            recommendations = listOf(
                Outlet(
                    name = R.string.culinary_creations,
                    image = R.drawable.restaurant_1,
                    category = R.string.restaurants,
                    content = R.string.culinary_creations_content,
                ),
                Outlet(
                    name = R.string.time_warp,
                    image = R.drawable.restaurant_3,
                    category = R.string.restaurants,
                    content = R.string.time_warp_content,
                ),
                Outlet(
                    name = R.string.sakura_heaven,
                    image = R.drawable.restaurant_2,
                    category = R.string.restaurants,
                    content = R.string.sakura_heaven_content,
                ),
                Outlet(
                    name = R.string.senor_taco,
                    image = R.drawable.restaurant_4,
                    category = R.string.restaurants,
                    content = R.string.senor_taco_content,
                ),
                Outlet(
                    name = R.string.ocean_pearl,
                    image = R.drawable.restaurant_5,
                    category = R.string.restaurants,
                    content = R.string.ocean_pearl_content
                )
            )
        ),
        Category(
            name = R.string.kid_friendly_places,
            thumbnail = R.drawable.kid_friendly_1,
            recommendations = listOf(
                Outlet(
                    name = R.string.toy_shop,
                    image = R.drawable.kid_friendly_1,
                    category = R.string.kid_friendly_places,
                    content = R.string.toy_shop_content
                ),
                Outlet(
                    name = R.string.game_centre,
                    image = R.drawable.kid_friendly_2,
                    category = R.string.kid_friendly_places,
                    content = R.string.game_centre_content
                ),
                Outlet(
                    name = R.string.playground,
                    image = R.drawable.kid_friendly_3,
                    category = R.string.kid_friendly_places,
                    content = R.string.playground_content
                ),
                Outlet(
                    name = R.string.library,
                    image = R.drawable.kid_friendly_4,
                    category = R.string.kid_friendly_places,
                    content = R.string.library_content
                )
            ),
        ),
        Category(
            name = R.string.shopping_centres,
            thumbnail = R.drawable.shopping_centre1,
            recommendations = listOf(
                Outlet(
                    name = R.string.avenue_central_park,
                    image = R.drawable.shopping_centre1,
                    category = R.string.shopping_centres,
                    content = R.string.avenue_central_park_content
                ),
                Outlet(
                    name = R.string.hilltop_emporium,
                    image = R.drawable.shopping_centre2,
                    category = R.string.shopping_centres,
                    content = R.string.hilltop_emporium_content
                ),
                Outlet(
                    name = R.string.harbor_point_marketplace,
                    image = R.drawable.shopping_centre3,
                    category = R.string.shopping_centres,
                    content = R.string.harbor_point_marketplace_content
                )
            )
        ),
        Category(
            name = R.string.parks,
            thumbnail = R.drawable.park_1,
            recommendations = listOf(
                Outlet(
                    name = R.string.cloud_cuckoo_park,
                    image = R.drawable.park_1,
                    category = R.string.parks,
                    content = R.string.cloud_cuckoo_park_content
                ),
                Outlet(
                    name = R.string.starlight_soiree,
                    image = R.drawable.park_2,
                    category = R.string.parks,
                    content = R.string.starlight_soiree_content
                ),
                Outlet(
                    name = R.string.wind_harp_woods,
                    image = R.drawable.park_3,
                    category = R.string.parks,
                    content = R.string.wind_harp_woods_content
                ),
            )
        )
    )

    private var activeCategory: Category? = categories[0]

    fun selectActiveCategory(@StringRes categoryId: Int){
        if(activeCategory?.name != categoryId)
            activeCategory?.selected = false

        activeCategory = categories.find { category -> category.name == categoryId }
        activeCategory?.selected = true
    }

    private var activeOutlet: Outlet? = categories[0].recommendations[0]

    fun selectActiveOutlet(@StringRes outletId: Int){
        if(activeOutlet?.name != outletId)
            activeOutlet?.selected = false

        activeOutlet = activeCategory?.recommendations?.find{outlet -> outlet.name == outletId }
        activeOutlet?.selected = true
    }
}