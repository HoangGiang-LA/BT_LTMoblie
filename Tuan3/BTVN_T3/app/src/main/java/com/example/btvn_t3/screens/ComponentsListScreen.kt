package com.example.btvn_t3.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.btvn_t3.ui.theme.*

data class ComponentItem(
    val name: String,
    val description: String,
    val route: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentsListScreen(
    onNavigateToDetail: (String) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "UI Components List",
                            color = Primary,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Surface
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            // Display
            CategorySection(
                title = "Display",
                items = listOf(
                    ComponentItem("Text", "Displays text", "text_detail"),
                    ComponentItem("Image", "Displays an image", "image_detail"),
                    ComponentItem("Progress Indicator", "Circular & Linear loading indicators", "progress_detail")
                ),
                onItemClick = onNavigateToDetail
            )

            // Input
            CategorySection(
                title = "Input",
                items = listOf(
                    ComponentItem("TextField", "Input field for text", "textfield_detail"),
                    ComponentItem("PasswordField", "Input field for passwords", "password_detail"),
                    ComponentItem("Toggle", "On/off switch", "toggle_detail"),
                    ComponentItem("Slider", "Selects a value from a range", "slider_detail"),
                    ComponentItem("DatePicker", "Selects a date and time", "datepicker_detail")
                ),
                onItemClick = onNavigateToDetail
            )

            // Selection
            CategorySection(
                title = "Selection",
                items = listOf(
                    ComponentItem("Button", "Triggers an action when tapped", "button_detail"),
                    ComponentItem("Checkbox", "Selects one or multiple options", "checkbox_detail"),
                    ComponentItem("RadioButton", "Selects a single option", "radiobutton_detail"),
                    ComponentItem("Picker", "Selects a value from a list", "picker_detail"),
                    ComponentItem("Chips", "Compact elements for tags & filters", "chip_detail")
                ),
                onItemClick = onNavigateToDetail
            )

            // Layout
            CategorySection(
                title = "Layout",
                items = listOf(
                    ComponentItem("Column", "Arranges elements vertically", "column_detail"),
                    ComponentItem("Row", "Arranges elements horizontally", "row_detail"),
                    ComponentItem("Box", "Stacks elements on top of each other", "box_detail")
                ),
                onItemClick = onNavigateToDetail
            )

            // Content
            CategorySection(
                title = "Content",
                items = listOf(
                    ComponentItem("List", "Displays a list of items", "list_detail"),
                    ComponentItem("Card", "Container with content and style", "card_detail"),
                    ComponentItem("Divider", "Separates content into sections", "divider_detail")
                ),
                onItemClick = onNavigateToDetail
            )

            // Navigation & Dialogs
            CategorySection(
                title = "Navigation & Dialogs",
                items = listOf(
                    ComponentItem("NavigationView / Scaffold", "Navigation container with title and back button", "scaffold_detail"),
                    ComponentItem("TabBar", "Switches between main sections", "tabbar_detail"),
                    ComponentItem("Menu", "Shows a menu with multiple actions", "menu_detail"),
                    ComponentItem("AlertDialog", "Pop-up dialogs and confirmations", "dialog_detail")
                ),
                onItemClick = onNavigateToDetail
            )

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun CategorySection(
    title: String,
    items: List<ComponentItem>,
    onItemClick: (String) -> Unit
) {
    Text(
        text = title,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        color = CategoryHeader,
        modifier = Modifier.padding(top = 16.dp, bottom = 6.dp)
    )
    items.forEach { item ->
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
                .clickable { onItemClick(item.route) },
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = CardBackground)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 14.dp)
            ) {
                Text(
                    text = item.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1E3A8A)
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = item.description,
                    fontSize = 13.sp,
                    color = SubText
                )
            }
        }
    }
}
