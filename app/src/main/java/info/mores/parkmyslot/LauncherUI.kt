package info.mores.parkmyslot

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import info.mores.parkmyslot.ui.theme.SplashBG
import info.mores.parkmyslot.util.Registration
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LauncherUI() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) { Splash(navController) }
        composable(Screen.Registration.route) { Registration(navController)}
        composable(Screen.Login.route) { }
        composable(Screen.Dashboard.route) { }
    }
}


sealed class Screen(val route: String) {

    object Splash : Screen("Splash")
    object Registration : Screen("Registration")
    object Login : Screen("Login")
    object Dashboard : Screen("Login")

}

@Preview
@Composable
fun Splash(navController: NavHostController) {

    val composition by rememberLottieComposition(LottieCompositionSpec.Url("https://assets1.lottiefiles.com/packages/lf20_xyvlbvhc.json"))

    val rememberCoroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        rememberCoroutineScope.launch {
            delay(8000)
            navController.navigate(Screen.Registration.route)
        }
    }

    LottieAnimation(
        composition = composition,
        modifier = Modifier.background(color = SplashBG),
        speed = 2.5f
    )

}

