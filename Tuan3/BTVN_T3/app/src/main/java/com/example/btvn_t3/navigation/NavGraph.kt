package com.example.btvn_t3.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.btvn_t3.screens.*

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "welcome"
    ) {
        composable("welcome") {
            WelcomeScreen(onGetStarted = {
                navController.navigate("components_list")
            })
        }
        composable("components_list") {
            ComponentsListScreen(
                onNavigateToDetail = { route -> navController.navigate(route) }
            )
        }
        composable("text_detail") {
            TextDetailScreen(onBack = { navController.popBackStack() })
        }
        composable("image_detail") {
            ImageDetailScreen(onBack = { navController.popBackStack() })
        }
        composable("textfield_detail") {
            TextFieldDetailScreen(onBack = { navController.popBackStack() })
        }
        composable("password_detail") {
            PasswordFieldDetailScreen(onBack = { navController.popBackStack() })
        }
        composable("toggle_detail") {
            ToggleDetailScreen(onBack = { navController.popBackStack() })
        }
        composable("slider_detail") {
            SliderDetailScreen(onBack = { navController.popBackStack() })
        }
        composable("datepicker_detail") {
            DatePickerDetailScreen(onBack = { navController.popBackStack() })
        }
        composable("button_detail") {
            ButtonDetailScreen(onBack = { navController.popBackStack() })
        }
        composable("checkbox_detail") {
            CheckboxDetailScreen(onBack = { navController.popBackStack() })
        }
        composable("radiobutton_detail") {
            RadioButtonDetailScreen(onBack = { navController.popBackStack() })
        }
        composable("picker_detail") {
            PickerDetailScreen(onBack = { navController.popBackStack() })
        }
        composable("column_detail") {
            ColumnLayoutScreen(onBack = { navController.popBackStack() })
        }
        composable("row_detail") {
            RowLayoutScreen(onBack = { navController.popBackStack() })
        }
        composable("box_detail") {
            BoxLayoutScreen(onBack = { navController.popBackStack() })
        }
        composable("list_detail") {
            ListDetailScreen(onBack = { navController.popBackStack() })
        }
        composable("card_detail") {
            CardDetailScreen(onBack = { navController.popBackStack() })
        }
        composable("divider_detail") {
            DividerDetailScreen(onBack = { navController.popBackStack() })
        }
        composable("scaffold_detail") {
            ScaffoldDetailScreen(onBack = { navController.popBackStack() })
        }
        composable("tabbar_detail") {
            TabBarDetailScreen(onBack = { navController.popBackStack() })
        }
        composable("menu_detail") {
            MenuDetailScreen(onBack = { navController.popBackStack() })
        }
        composable("dialog_detail") {
            DialogDetailScreen(onBack = { navController.popBackStack() })
        }
        composable("progress_detail") {
            ProgressDetailScreen(onBack = { navController.popBackStack() })
        }
        composable("chip_detail") {
            ChipDetailScreen(onBack = { navController.popBackStack() })
        }
    }
}
