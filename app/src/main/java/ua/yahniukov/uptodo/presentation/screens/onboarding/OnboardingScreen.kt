package ua.yahniukov.uptodo.presentation.screens.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import ua.yahniukov.uptodo.presentation.data.Onboarding
import ua.yahniukov.uptodo.presentation.screens.onboarding.components.BackButton
import ua.yahniukov.uptodo.presentation.screens.onboarding.components.DoneButton
import ua.yahniukov.uptodo.presentation.screens.onboarding.components.HorizontalPageIndicator
import ua.yahniukov.uptodo.presentation.screens.onboarding.components.NextButton
import ua.yahniukov.uptodo.presentation.screens.onboarding.components.OnboardingPage
import ua.yahniukov.uptodo.presentation.screens.onboarding.components.SkipButton

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(
    onNavigateToHomeScreen: () -> Unit,
    onboardingViewModel: OnboardingViewModel = koinViewModel(),
) {
    val onboardingPages = listOf(
        Onboarding.FirstPage,
        Onboarding.SecondPage,
        Onboarding.ThirdPage,
    )

    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState(initialPage = 0) {
        onboardingPages.size
    }

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
            ) {
                SkipButton(
                    onClick = {
                        coroutineScope.launch {
                            pagerState.scrollToPage(onboardingPages.lastIndex)
                        }
                    },
                )
            }
            HorizontalPager(
                modifier = Modifier.weight(11f),
                state = pagerState,
            ) { index ->
                OnboardingPage(
                    modifier = Modifier.fillMaxWidth(),
                    page = onboardingPages[index],
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                BackButton(
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage - 1)
                        }
                    },
                )
                HorizontalPageIndicator(
                    onboardingPageCount = onboardingPages.size,
                    currentPage = pagerState.currentPage,
                )
                if (pagerState.currentPage == onboardingPages.lastIndex) {
                    DoneButton(
                        onClick = {
                            onboardingViewModel.setOnBoardingCompleted(true)
                            onNavigateToHomeScreen()
                        },
                    )
                } else {
                    NextButton(
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            }
                        },
                    )
                }
            }
        }
    }
}