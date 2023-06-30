package info.mores.parkmyslot.ui.screen

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import info.mores.parkmyslot.R
import info.mores.parkmyslot.ui.theme.SecondaryTxtColor
import info.mores.parkmyslot.ui.theme.hintColor
import info.mores.parkmyslot.uiutil.FontAwesomeText


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AddVehicleScreen(navController: NavHostController?) {

    var isCar by remember {
        mutableStateOf(true)
    }

    var number by remember {
        mutableStateOf("")
    }

    var icon by remember {
        mutableStateOf(R.string.far_fa_car)
    }


    LaunchedEffect(key1 = isCar) {
        icon = if (isCar) {
            R.string.far_fa_car
        } else {
            R.string.far_fa_person_biking
        }
    }

    Box(
        Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary)
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 10.dp)
                .background(
                    color = colorResource(id = R.color.cardWhite),
                    shape = RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp)
                )
        ) {
            AnimatedContent(
                targetState = icon,
                transitionSpec = {
                    (scaleIn() with scaleOut()).using(SizeTransform(clip = true))
                }, label = ""
            ) { targetCount ->
                FontAwesomeText(
                    modifier = Modifier
                        .padding(10.dp)
                        .padding(top = 50.dp),
                    fontID = targetCount,
                    fontSize = 75.sp,
                    textColor = MaterialTheme.colorScheme.primary
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Bike",
                    color = SecondaryTxtColor
                )
                Switch(
                    modifier = Modifier.padding(10.dp),
                    checked = isCar,
                    onCheckedChange = { isCar = it }
                )
                Text(
                    text = "Car",
                    color = SecondaryTxtColor
                )
            }


            OutlinedTextField(
                value = number, onValueChange = { number = it },
                label = { Text(text = "Vehicle Number e.g. MH 15 AA 0000", color = hintColor, fontSize = 12.sp) },
                singleLine = true,
                )

            Button(
                modifier = Modifier.padding(10.dp),
                onClick = { /*TODO*/ },
                enabled = number.isNotEmpty()
            ) {
                Text(text = "Add vehicle")
            }
        }

    }

}


@Preview
@Composable
private fun ShowUI() {
    AddVehicleScreen(null)
}