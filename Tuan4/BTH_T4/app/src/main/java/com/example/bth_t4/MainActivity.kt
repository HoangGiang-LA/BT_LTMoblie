package com.example.bth_t4

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bth_t4.screens.*
import com.example.bth_t4.ui.theme.BTH_T4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BTH_T4Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    val context = LocalContext.current

                    NavHost(
                        navController = navController,
                        startDestination = "root"
                    ) {
                        // 1. Màn hình Root (Intro Navigation + nút PUSH)
                        composable("root") {
                            RootScreen(
                                onPush = { navController.navigate("choose_type") }
                            )
                        }

                        // 2. Màn hình chọn kiểu danh sách (Thực hành 2)
                        composable("choose_type") {
                            ChooseListTypeScreen(
                                onSelectLazyColumn = { navController.navigate("lazy_list") },
                                onSelectColumn = {
                                    Toast.makeText(
                                        context,
                                        "Lưu ý: Column không thể render 1,000,000 item cùng lúc vì sẽ tràn bộ nhớ (OOM)! Hãy dùng LazyColumn.",
                                        Toast.LENGTH_LONG
                                    ).show()
                                }
                            )
                        }

                        // 3. Màn hình LazyColumn (Hiển thị 1,000,000 phần tử mượt mà)
                        composable("lazy_list") {
                            LazyListScreen(
                                onNavigateToDetail = { itemId ->
                                    navController.navigate("detail/$itemId")
                                },
                                onBack = { navController.popBackStack() }
                            )
                        }

                        // 4. Màn hình Detail (Có nút Back to Root xóa sạch stack)
                        composable(
                            route = "detail/{itemId}",
                            arguments = listOf(navArgument("itemId") { type = NavType.IntType })
                        ) { backStackEntry ->
                            val itemId = backStackEntry.arguments?.getInt("itemId") ?: 1
                            DetailScreen(
                                itemId = itemId,
                                onBack = { navController.popBackStack() },
                                onBackToRoot = {
                                    // Quay về thẳng Root và dọn sạch stack
                                    navController.popBackStack("root", inclusive = false)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
