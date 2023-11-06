package ua.yahniukov.uptodo.presentation.screens.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HorizontalPageIndicator(
    onboardingPageCount: Int,
    currentPage: Int,
) {
    Row {
        repeat(onboardingPageCount) { page ->
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .clip(CircleShape)
                    .background(
                        if (currentPage == page) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            Color.Gray.copy(alpha = 0.65f)
                        }
                    )
                    .size(14.dp)
            )
        }
    }
}