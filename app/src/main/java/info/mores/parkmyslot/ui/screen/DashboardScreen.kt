package info.mores.parkmyslot.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import info.mores.parkmyslot.R
import info.mores.parkmyslot.Screen
import info.mores.parkmyslot.ui.theme.SecondaryTxtColor
import info.mores.parkmyslot.uiutil.FontAwesomeText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavHostController?) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Dashboard",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            imageVector = Icons.Filled.Favorite,
                            contentDescription = "Localized description"
                        )
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            AddVehicleUI(
                Modifier
                    .fillMaxSize()
                    .align(Alignment.CenterHorizontally)
            ) {
                navController?.navigate(Screen.AddVehicleScreen.route)
            }
        }
    }
}


@Composable
fun AddVehicleUI(modifier: Modifier, click: () -> Unit?) {
    Box(modifier = modifier.padding(15.dp), contentAlignment = Alignment.Center) {
        Column(Modifier.align(Alignment.Center).padding(bottom = 80.dp)) {
            FontAwesomeText(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clickable {
                        click()
                    }
                    .padding(15.dp),
                fontID = R.string.far_fa_smile_plus,
                fontSize = 50.sp,
                textColor = MaterialTheme.colorScheme.primary
            )
            Text(
                text = stringResource(R.string.add_vehicle_msg),
                color = SecondaryTxtColor,
                textAlign = TextAlign.Center,
                fontSize = 16.sp
            )
        }
    }


}


@Preview(showBackground = true)
@Composable
private fun ShowUI() {
    AddVehicleUI(Modifier) {

    }
}