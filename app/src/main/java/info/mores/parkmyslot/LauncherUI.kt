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
import info.mores.parkmyslot.ui.screen.AddVehicleScreen
import info.mores.parkmyslot.ui.screen.DashboardScreen
import info.mores.parkmyslot.ui.screen.LoginScreen
import info.mores.parkmyslot.ui.screen.OTPScreen
import info.mores.parkmyslot.ui.screen.Registration
import info.mores.parkmyslot.ui.theme.SplashBG
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LauncherUI() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Dashboard.route) {
        composable(Screen.Splash.route) { Splash(navController) }
        composable(Screen.Registration.route) { Registration(navController) }
        composable(Screen.Login.route) { LoginScreen(navController) }
        composable(Screen.OTP.route) { OTPScreen(navController) }
        composable(Screen.Dashboard.route) { DashboardScreen(navController) }
        composable(Screen.AddVehicleScreen.route) { AddVehicleScreen(navController) }
    }
}




sealed class Screen(val route: String) {

    object Splash : Screen("Splash")
    object Registration : Screen("Registration")
    object Login : Screen("Login")
    object Dashboard : Screen("Dashboard")
    object OTP : Screen("OTP")
    object AddVehicleScreen : Screen("AddVehicleScreen")

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

